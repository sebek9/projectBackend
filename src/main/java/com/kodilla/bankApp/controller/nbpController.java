package com.kodilla.bankApp.controller;

import com.kodilla.bankApp.client.NbpClient;
import com.kodilla.bankApp.domain.NbpDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rates/a")
public class nbpController {

    @Autowired
    private NbpClient nbpClient;

    @RequestMapping(method = RequestMethod.GET,value = "/eur")
    public void getCourse(){
        NbpDto course=nbpClient.getExchange();

        System.out.println(course.getRate());

    }
}
