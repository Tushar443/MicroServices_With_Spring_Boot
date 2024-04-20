package com.project.microservices.currencyconversionservice.controller;

import com.project.microservices.currencyconversionservice.bean.CurrencyConversion;
import com.project.microservices.currencyconversionservice.service.CurrencyExchangeProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyConversionController {
    @Autowired
    private CurrencyExchangeProxy currencyExchangeProxy;

    //http://localhost:8000/currency-conversion/from/USD/to/INR/quantity/10
//    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
//    public CurrencyConversion calculateCurrencyConversion(@PathVariable String from,@PathVariable String to,
//                                                          @PathVariable BigDecimal quantity){
//        HashMap<String,String> uriVariables = new HashMap<>();
//        uriVariables.put("from",from);
//        uriVariables.put("to",to);
//        ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",CurrencyConversion.class,uriVariables);
//        CurrencyConversion currencyConversion = responseEntity.getBody();
//        return new CurrencyConversion(currencyConversion.getId()
//                , from,to,quantity,
//                currencyConversion.getConversionMultiple()
//                ,quantity.multiply(currencyConversion.getConversionMultiple()),currencyConversion.getEnvironment());
//    }

    // Feign Implementation
    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateCurrencyConversionUsingFeign(@PathVariable String from,@PathVariable String to,
                                                          @PathVariable BigDecimal quantity){
        CurrencyConversion currencyConversion = currencyExchangeProxy.retriveExchangeValue(from, to);
        return new CurrencyConversion(currencyConversion.getId()
                , from,to,quantity,
                currencyConversion.getConversionMultiple()
                ,quantity.multiply(currencyConversion.getConversionMultiple()),currencyConversion.getEnvironment());
    }
}
