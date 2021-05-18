package com.train.supplytransport.supplytransportapplication.domain.service;

import com.train.supplytransport.supplytransportapplication.domain.model.TrainStation;
import com.train.supplytransport.supplytransportapplication.domain.repository.TrainStationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class TrainStationService {

    private final TrainStationRepository repository;

    public List<TrainStation> findByName(String name) {

        return repository.findByName(name);

    }
}
