package com.project.microservices.lengthservice.controller;

import com.project.microservices.lengthservice.bean.Length;
import com.project.microservices.lengthservice.config.LengthConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LengthController {

    @Autowired
    LengthConfig lengthConfig;

    @GetMapping("/length")
    public Length getLength(){
        return new Length(lengthConfig.getMinimum(), lengthConfig.getMaximum());
    }
}
