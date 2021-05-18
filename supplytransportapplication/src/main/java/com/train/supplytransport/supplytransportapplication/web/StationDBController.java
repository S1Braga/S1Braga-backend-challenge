package com.train.supplytransport.supplytransportapplication.web;

import com.train.supplytransport.supplytransportapplication.domain.model.StationRepository;
import com.train.supplytransport.supplytransportapplication.domain.repository.StationRepositoryDB;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping({"/StationRepositoryDB"})
public class StationDBController {

    private StationRepositoryDB repository;

    @GetMapping
    public List findAll() {
        return repository.findAll();
    }

    @GetMapping(path = {"/{initials}"})
    public ResponseEntity findById(@PathVariable String initials) {
        return repository.findById(initials)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public StationRepository create(@RequestBody StationRepository stationRepository) {
        return repository.save(stationRepository);
    }

    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity<?> delete(@PathVariable String initials) {
        return repository.findById(initials)
                .map(record -> {
                    repository.deleteById(initials);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

}
