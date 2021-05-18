package com.train.supplytransport.supplytransportapplication.domain.repository;

import com.train.supplytransport.supplytransportapplication.domain.model.TrainStation;

import java.util.List;

public interface TrainStationRepository {

    List<TrainStation> findByName(String name);

}
