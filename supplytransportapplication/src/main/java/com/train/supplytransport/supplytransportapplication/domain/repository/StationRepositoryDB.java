package com.train.supplytransport.supplytransportapplication.domain.repository;

import com.train.supplytransport.supplytransportapplication.domain.model.StationRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StationRepositoryDB extends JpaRepository<StationRepository, String> {

}