package com.kodilla.bankApp.controller;

import com.kodilla.bankApp.controller.exceptions.BondNotFoundException;
import com.kodilla.bankApp.domain.dTo.BondDto;
import com.kodilla.bankApp.mapper.BondMapper;
import com.kodilla.bankApp.service.BondService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("v1/bond")
@CrossOrigin(origins ="*")
public class BondController {
    @Autowired
    private BondService service;
    @Autowired
    private BondMapper bondMapper;

    @RequestMapping(method = RequestMethod.GET,value = "/getBonds")
    public List<BondDto> getBonds() {
        return bondMapper.mapToBondDtoList(service.getAllBonds());
    }

    @RequestMapping(method = RequestMethod.GET,value = "/getBond")
    public BondDto getBond(Long bondId) throws BondNotFoundException {
        return bondMapper.mapToBondDto(service.getBond(bondId).orElseThrow(BondNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/deleteBond")
    public void deleteBond(@PathVariable Long bondId){

    }
    @RequestMapping(method = RequestMethod.PUT,value = "/updateBond")
    public BondDto updateBond(@RequestBody BondDto bondDto){
        return bondMapper.mapToBondDto(service.saveBond(bondMapper.mapToBond(bondDto))); }

    //
    @RequestMapping(method = RequestMethod.POST,value = "/createBond",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createBond(@RequestBody BondDto bondDto){
        service.saveBond(bondMapper.mapToBond(bondDto));
    }
}
