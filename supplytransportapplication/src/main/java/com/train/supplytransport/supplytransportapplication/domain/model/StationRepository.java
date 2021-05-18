package com.train.supplytransport.supplytransportapplication.domain.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "station")
public class StationRepository {

    @Id
    private String initials;

    private String station;

    private String city;

}
