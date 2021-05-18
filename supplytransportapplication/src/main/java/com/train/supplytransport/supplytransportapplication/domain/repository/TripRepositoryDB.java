package com.train.supplytransport.supplytransportapplication.domain.repository;

import com.train.supplytransport.supplytransportapplication.domain.model.TripRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TripRepositoryDB extends JpaRepository<TripRepository, String> {

}
