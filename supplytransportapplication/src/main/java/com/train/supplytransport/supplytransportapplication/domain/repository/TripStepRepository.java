package com.train.supplytransport.supplytransportapplication.domain.repository;

import com.train.supplytransport.supplytransportapplication.domain.model.StepTrip;

import java.util.List;

public interface TripStepRepository {

    public List<StepTrip> findAll();

}
