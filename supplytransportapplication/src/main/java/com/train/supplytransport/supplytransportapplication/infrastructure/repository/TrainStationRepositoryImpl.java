package com.train.supplytransport.supplytransportapplication.infrastructure.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.train.supplytransport.supplytransportapplication.domain.model.TrainStation;
import com.train.supplytransport.supplytransportapplication.domain.repository.TrainStationRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TrainStationRepositoryImpl implements TrainStationRepository {

    private final ObjectMapper mapper = new ObjectMapper();
    private final List<TrainStation> store = new ArrayList<>();


    @PostConstruct
    private void postconstruct() throws IOException {

        store.addAll(Arrays.asList(mapper.readValue(Paths.get("src/trainStations.json").toFile(), TrainStation[].class)));

    }

    @Override
    public List<TrainStation> findByName(String name) {

        var nameCriteria = name != null ? name.toLowerCase() : "";

        return store.stream().filter(t -> t.getName().toLowerCase().contains(nameCriteria))
                .collect(Collectors.toList());

    }

}
