package com.project.microservices.weightservice.controller;

import com.project.microservices.weightservice.bean.Weight;
import com.project.microservices.weightservice.config.WeightConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class weightController {
    @Autowired
    WeightConfiguration weightConfiguration;

    @GetMapping("/weight")
    public Weight getWeightInRange(){
        return new Weight(weightConfiguration.getMinimum(), weightConfiguration.getMaximum());
    }
}
