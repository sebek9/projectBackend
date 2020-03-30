package com.kodilla.bankApp.controller;

import com.kodilla.bankApp.client.NbpClient;
import com.kodilla.bankApp.domain.NbpDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class nbpController {

    @Autowired
    private NbpClient nbpClient;

    @RequestMapping(method = RequestMethod.GET,value = "/latest/")
    public void getExchangeRates(){
        List<NbpDto> rates = nbpClient.getExchangeRates();

        rates.forEach(NbpDto-> System.out.println(NbpDto.getRate() + NbpDto.getBase() + NbpDto.getDate()));


    }
}


