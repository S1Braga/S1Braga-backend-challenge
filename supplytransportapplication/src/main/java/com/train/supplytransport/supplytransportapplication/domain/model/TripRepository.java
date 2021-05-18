package com.train.supplytransport.supplytransportapplication.domain.model;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "trip")
public class TripRepository {

    @Id
    private String trip_number;

    private String origin_station;

    private String destiny_station;

    private LocalDate trip_date;

    private LocalTime departure_time;

    private LocalTime arrival_time;

    private String price;
}
