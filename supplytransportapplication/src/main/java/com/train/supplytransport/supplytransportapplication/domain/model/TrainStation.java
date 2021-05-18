package com.train.supplytransport.supplytransportapplication.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TrainStation {

    @Getter
    @JsonProperty("name")
    private String name;

    @JsonProperty("station")
    private String station;

    @JsonProperty("city")
    private String city;
}
