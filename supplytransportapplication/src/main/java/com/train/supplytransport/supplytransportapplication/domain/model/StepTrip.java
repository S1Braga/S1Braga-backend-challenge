package com.train.supplytransport.supplytransportapplication.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.opencsv.bean.CsvBindByPosition;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class StepTrip extends BaseTrip {

    @JsonProperty("trip")
    @CsvBindByPosition(position = 0)
    private String code;

    @JsonProperty("value")
    @CsvBindByPosition(position = 6)
    private String price;

    @Setter
    private String company;

}
