package com.example.codeclan.WhiskyDistilleries.controllers;

import com.example.codeclan.WhiskyDistilleries.models.Distillery;
import com.example.codeclan.WhiskyDistilleries.repositories.DistilleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.GeneratedValue;
import java.util.List;
import java.util.Optional;

@RestController
public class DistilleryController {

    @Autowired
    DistilleryRepository distilleryRepository;

    //GET - /distilleries?region=Highland

    @GetMapping(value = "/distilleries")
    public ResponseEntity<List<Distillery>> getAllDistilleries(

            @RequestParam(name = "region", required = false) String region,
            @RequestParam(name ="whiskyAge", required = false) Integer whiskyAge
    ){
        if(region != null){
            return new ResponseEntity<>(distilleryRepository.findByRegion(region), HttpStatus.OK);
        }
        if (whiskyAge != null){
            return new ResponseEntity<>(distilleryRepository.findByWhiskiesAge(whiskyAge),
                    HttpStatus.OK);
        }
        List<Distillery> allDistilleries = distilleryRepository.findAll();
        return new ResponseEntity<>(allDistilleries, HttpStatus.OK);
    }

    @GetMapping(value = "/distilleries/{id}")
    public ResponseEntity<Optional<Distillery>> getDistillery(@PathVariable Long id){
        return new ResponseEntity<>(distilleryRepository.findById(id), HttpStatus.OK);
    }

}
