package com.project.microservices.currencyexchangeservice.repository;

import com.project.microservices.currencyexchangeservice.bean.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyExchangeRepo extends JpaRepository<CurrencyExchange,Long> {

    CurrencyExchange findByFromAndTo(String from , String to);
}
