package com.train.supplytransport.supplytransportapplication.web;

import com.train.supplytransport.supplytransportapplication.domain.model.TripRepository;
import com.train.supplytransport.supplytransportapplication.domain.repository.TripRepositoryDB;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping({"/tripRepositoryDB"})
public class TripStepDBController {

    private TripRepositoryDB repository;

    @GetMapping
    public List<TripRepository> findAll(){
        return repository.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<TripRepository> findById(@PathVariable String id){
        return repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public TripRepository create(@RequestBody TripRepository tripRepository){
        return repository.save(tripRepository);
    }

    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity <?> delete(@PathVariable("id") String tripNumber) {
        return repository.findById(tripNumber)
                .map(record -> {
                    repository.deleteById(tripNumber);
                    return ResponseEntity.noContent().build();
                }).orElse(ResponseEntity.notFound().build());
    }

}
