package com.project.microservices.currencyexchangeservice.controller;

import com.project.microservices.currencyexchangeservice.bean.CurrencyExchange;
import com.project.microservices.currencyexchangeservice.repository.CurrencyExchangeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {
    @Autowired
    private Environment environment;

    @Autowired
    CurrencyExchangeRepo currencyExchangeRepo;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retriveExchangeValue(@PathVariable String from, @PathVariable String to) {
        CurrencyExchange currencyExchange = currencyExchangeRepo.findByFromAndTo(from, to);
        if(currencyExchange == null) throw new RuntimeException("Unable to find Data form "+ from + " to "+to);
        //CurrencyExchange currencyExchange = new CurrencyExchange(1L,from,to, BigDecimal.valueOf(100));
        currencyExchange.setEnvironment(environment.getProperty("local.server.port"));
        return currencyExchange;
    }
}
