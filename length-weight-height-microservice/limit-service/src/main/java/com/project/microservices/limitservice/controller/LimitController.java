package com.project.microservices.limitservice.controller;

import com.project.microservices.limitservice.bean.Limit;
import com.project.microservices.limitservice.configuration.LimitConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitController {

    @Autowired
    private LimitConfiguration limitConfiguration;

    @GetMapping("/limits")
    public Limit getAllLimit() {
        return new Limit(limitConfiguration.getMinimum(), limitConfiguration.getMaximum());
//        return new Limit(1,1000);
    }
}
