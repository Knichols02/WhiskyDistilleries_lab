package com.example.codeclan.WhiskyDistilleries.controllers;

import com.example.codeclan.WhiskyDistilleries.models.Whisky;
import com.example.codeclan.WhiskyDistilleries.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    //GET - /whiskies                   findAll()
    //GET - /whiskies?year=12           findByYear()
    //GET - /whiskies?distilleryName
    //GET - /whiskies?region=Lowland

    @GetMapping(value = "/whiskies")
    public ResponseEntity<List<Whisky>> getAllWhiskies(

            @RequestParam(name = "year", required = false) Integer year,
            @RequestParam(name = "distilleryName", required = false) String distilleryName,
            @RequestParam(name = "age", required = false) Integer age,
            @RequestParam(name = "distilleryRegion", required = false) String distilleryRegion
    ){
      //if year is != null = do + return year query
        if(year != null){
            return new ResponseEntity<>(whiskyRepository.findByYear(year), HttpStatus.OK);
        }
        if (distilleryName != null && age != null){
            return new ResponseEntity<>(whiskyRepository.findByDistilleryNameAndAge(distilleryName, age), HttpStatus.OK);
        }
        if (distilleryRegion != null){
            return new ResponseEntity<>(whiskyRepository.findByDistilleryRegion(distilleryRegion),
                    HttpStatus.OK);
        }
        List<Whisky> allWhiskies = whiskyRepository.findAll();
        return new ResponseEntity<>(allWhiskies, HttpStatus.OK);
    }

    @GetMapping(value = "/whiskies/{id}")
    public ResponseEntity<Optional<Whisky>> getWhisky(@PathVariable Long id){
        return new ResponseEntity<>(whiskyRepository.findById(id), HttpStatus.OK);
    }
}
