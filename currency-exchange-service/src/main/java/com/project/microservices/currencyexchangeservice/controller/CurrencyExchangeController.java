package com.project.microservices.currencyexchangeservice.controller;

import com.project.microservices.currencyexchangeservice.bean.CurrencyExchange;
import com.project.microservices.currencyexchangeservice.repository.CurrencyExchangeRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CurrencyExchangeController {

    private Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);

    @Autowired
    private Environment environment;

    @Autowired
    CurrencyExchangeRepo currencyExchangeRepo;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retriveExchangeValue(@PathVariable String from, @PathVariable String to) {
        logger.info("retriveExchangeValue called with {} to {}",from,to);
        //[currency-exchange] [nio-8000-exec-1] [467112802e2bc96348a8c4a3b22658a3-05b340f585d57ef1] c.p.m.c.c.CurrencyExchangeController     : retriveExchangeValue called with USD to INR
        CurrencyExchange currencyExchange = currencyExchangeRepo.findByFromAndTo(from, to);
        if(currencyExchange == null) throw new RuntimeException("Unable to find Data form "+ from + " to "+to);
        //CurrencyExchange currencyExchange = new CurrencyExchange(1L,from,to, BigDecimal.valueOf(100));
        currencyExchange.setEnvironment(environment.getProperty("local.server.port"));
        return currencyExchange;
    }
}
