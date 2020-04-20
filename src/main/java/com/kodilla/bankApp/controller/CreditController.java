package com.kodilla.bankApp.controller;

import com.kodilla.bankApp.controller.exceptions.CreditNotFoundException;
import com.kodilla.bankApp.domain.dTo.CreditDto;
import com.kodilla.bankApp.mapper.CreditMapper;
import com.kodilla.bankApp.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("v1/credit")
@CrossOrigin(origins ="*")
public class CreditController {
    @Autowired
    private CreditService service;
    @Autowired
    private CreditMapper creditMapper;

    @RequestMapping(method = RequestMethod.GET,value = "/getCredits")
    public List<CreditDto> getCredits() {
        return creditMapper.mapToCreditDtoList(service.getAllCredits());
    }

    @RequestMapping(method = RequestMethod.GET,value = "/getCredit")
    public CreditDto getCredit(Long creditId) throws CreditNotFoundException {
        return creditMapper.mapToCreditDto(service.getCredit(creditId).orElseThrow(CreditNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/deleteCredit")
    public void deleteCredit(@PathVariable Long creditId){

    }
    @RequestMapping(method = RequestMethod.PUT,value = "/updateCredit")
    public CreditDto updateCredit(@RequestBody CreditDto creditDto){
        return creditMapper.mapToCreditDto(service.saveCredit(creditMapper.mapToCredit(creditDto))); }

    //
    @RequestMapping(method = RequestMethod.POST,value = "/createCredit",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createCredit(@RequestBody CreditDto creditDto){
        service.saveCredit(creditMapper.mapToCredit(creditDto));
    }
}
