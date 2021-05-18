package com.train.supplytransport.supplytransportapplication.web;

import com.train.supplytransport.supplytransportapplication.domain.model.TrainStation;
import com.train.supplytransport.supplytransportapplication.domain.service.TrainStationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/train-station")
@RequiredArgsConstructor
public class TrainStationController {

    private final TrainStationService trainStationService;

    @GetMapping

    public List<TrainStation> findByName(@RequestParam(required = false) String name) {

        return trainStationService.findByName(name);
    }

}


