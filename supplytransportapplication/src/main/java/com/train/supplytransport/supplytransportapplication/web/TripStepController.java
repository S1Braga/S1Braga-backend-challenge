package com.train.supplytransport.supplytransportapplication.web;

import com.train.supplytransport.supplytransportapplication.domain.model.Trip;
import com.train.supplytransport.supplytransportapplication.domain.service.TripService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("/main-trip")
@RequiredArgsConstructor
public class TripStepController {

    private final TripService tripService;

    @GetMapping
    public List<Trip> findAvaliableTrips(@RequestParam String origin,
                                         @RequestParam String destiny,
                                         @RequestParam
                                          @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate departureDate) {

        return tripService.findAvaliableTrips(origin, destiny, departureDate);

    }

}
