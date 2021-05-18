package com.train.supplytransport.supplytransportapplication.infrastructure.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.bean.CsvToBeanBuilder;
import com.train.supplytransport.supplytransportapplication.domain.model.StepTrip;
import com.train.supplytransport.supplytransportapplication.domain.repository.TripStepRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class TripStepRepositoryImpl implements TripStepRepository {

    private final ObjectMapper mapper = new ObjectMapper();
    private final List<StepTrip> storeTrips = new ArrayList<>();

    @PostConstruct
    private void postconstruct() throws IOException {

        List<StepTrip> iTrainTrips = new CsvToBeanBuilder(new FileReader("src/iTrain.csv"))
                .withType(StepTrip.class).withSkipLines(1).build().parse();

        iTrainTrips.forEach(it -> it.setCompany("iTrain"));

        var uberOnRailsTrips = Arrays.asList(mapper.readValue(Paths.get("src/uberOnRails.json").toFile(), StepTrip[].class));

        uberOnRailsTrips.forEach(it -> it.setCompany("UberOnRails"));

        storeTrips.addAll(iTrainTrips);
        storeTrips.addAll(uberOnRailsTrips);
    }

    public List<StepTrip> findAll() {
        return storeTrips;
    }

}
