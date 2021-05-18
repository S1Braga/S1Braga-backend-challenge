package com.train.supplytransport.supplytransportapplication.domain.service;

import com.train.supplytransport.supplytransportapplication.domain.model.Trip;
import com.train.supplytransport.supplytransportapplication.domain.model.StepTrip;
import com.train.supplytransport.supplytransportapplication.domain.repository.TripStepRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TripService {

    private final TripStepRepository tripStepRepository;

    public List<Trip> findAvaliableTrips(String mainOrigin, String mainDestiny, LocalDate departureDate) {

        List<Trip> trips = new ArrayList<>();

        var stepsByOrigin = findStepsByOrigin(mainOrigin, departureDate);
        var stepsByDestiny = findStepsByDestiny(mainDestiny, departureDate);

        trips.addAll(findConnectionBasedTrips(stepsByOrigin, stepsByDestiny));
        trips.addAll(findStandAloneTrips(mainOrigin, stepsByDestiny));

        trips.sort(Comparator.comparing(Trip::getArrival));

        return trips;

    }

    private List<Trip> findConnectionBasedTrips(List<StepTrip> stepsByOrigin, List<StepTrip> stepsByDestiny) {

        List<Trip> trips = new ArrayList<>();

        stepsByOrigin.forEach(firstStop ->

                stepsByDestiny.forEach(lastStop -> {

                    if (locationsAndDateMatch(firstStop, lastStop)) {

                        var maintrip = Trip.builder()
                                .origin(firstStop.getOrigin())
                                .destiny(firstStop.getDestiny())
                                .departureDate(firstStop.getDepartureDate())
                                .departure(firstStop.getDeparture())
                                .arrival(lastStop.getArrival())
                                .steps(Arrays.asList(firstStop, lastStop))
                                .build();

                        trips.add(maintrip);

                    }
                })
        );
        return trips;
    }

    private List<Trip> findStandAloneTrips(String origin, List<StepTrip> stepsByDestiny) {

        return stepsByDestiny.stream()
                .filter(d -> d.getOrigin().equals(origin))
                .map(it ->
                        Trip.builder()
                                .origin(it.getOrigin())
                                .destiny(it.getDestiny())
                                .departureDate(it.getDepartureDate())
                                .departure(it.getDeparture())
                                .arrival(it.getArrival())
                                .steps(Collections.singletonList(it))
                                .build()

                ).collect(Collectors.toList());
    }


    private boolean locationsAndDateMatch(StepTrip firstStop, StepTrip nextStop) {

        return (nextStop.getOrigin().equals(firstStop.getDestiny())) &&
                (!nextStop.getDeparture().isBefore(firstStop.getArrival()));

    }

    private List<StepTrip> findStepsByDestiny(String mainDestiny, LocalDate departureDate) {

        return tripStepRepository.findAll().stream().filter(t -> t.getDestiny().equalsIgnoreCase(mainDestiny) &&
                t.getDepartureDate().isEqual(departureDate)).collect(Collectors.toList());
    }

    private List<StepTrip> findStepsByOrigin(String mainOrigin, LocalDate departureDate) {
        return tripStepRepository.findAll().stream().filter(t -> t.getOrigin().equalsIgnoreCase(mainOrigin)
                && t.getDepartureDate().isEqual(departureDate)).collect(Collectors.toList());

    }

}



