package com.train.supplytransport.supplytransportapplication.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.time.LocalTime;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public abstract class BaseTrip {


    @JsonProperty("origin")
    @CsvBindByPosition(position = 1)
    private String origin;

    @JsonProperty("destiny")
    @CsvBindByPosition(position = 2)
    private String destiny;

    @JsonProperty("departureDate")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @CsvBindByPosition(position = 3)
    @CsvDate(value = "yyyy/MM/dd")
    private LocalDate departureDate;

    @JsonProperty("departure")
    @JsonDeserialize(using = LocalTimeDeserializer.class)
    @CsvBindByPosition(position = 4)
    @CsvDate(value = "HH:mm")
    private LocalTime departure;

    @JsonProperty("arrival")
    @JsonDeserialize(using = LocalTimeDeserializer.class)
    @CsvBindByPosition(position = 5)
    @CsvDate(value = "HH:mm")
    private LocalTime arrival;

}


