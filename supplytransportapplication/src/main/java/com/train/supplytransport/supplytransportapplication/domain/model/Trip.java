package com.train.supplytransport.supplytransportapplication.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Trip extends BaseTrip implements Serializable {

    @JsonProperty("steps")
    private List<StepTrip> steps = new ArrayList<>();

}
