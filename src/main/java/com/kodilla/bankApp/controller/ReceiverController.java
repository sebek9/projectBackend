package com.kodilla.bankApp.controller;

import com.kodilla.bankApp.domain.PaymentDto;
import com.kodilla.bankApp.domain.ReceiverDto;
import com.kodilla.bankApp.mapper.PaymentMapper;
import com.kodilla.bankApp.mapper.ReceiverMapper;
import com.kodilla.bankApp.service.DbService;
import com.kodilla.bankApp.service.ReceiverDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/receiver")
@CrossOrigin(origins ="*")
public class ReceiverController {
    @Autowired
    private ReceiverDbService service;
    @Autowired
    private ReceiverMapper receiverMapper;

    @RequestMapping(method = RequestMethod.GET,value = "/getReceivers")
    public List<ReceiverDto> getReceivers() {
        return receiverMapper.mapToReceiverDtoList(service.getAllReceivers());
    }

    @RequestMapping(method = RequestMethod.GET,value = "/getReceiver")
    public ReceiverDto getReceiver(Long receiverId) throws ReceiverNotFoundException{
        return receiverMapper.mapToReceiverDto(service.getReceiver(receiverId).orElseThrow(ReceiverNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/deleteReceiver")
    public void deleteReceiver(Long receiverId){

    }
    @RequestMapping(method = RequestMethod.PUT,value = "/updateReceiver")
    public ReceiverDto updateReceiver(@RequestBody ReceiverDto receiverDto){
        return receiverMapper.mapToReceiverDto(service.saveReceiver(receiverMapper.mapToReceiver(receiverDto))); }

    @RequestMapping(method = RequestMethod.POST,value = "/createReceiver",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createReceiver(@RequestBody ReceiverDto receiverDto){
        service.saveReceiver(receiverMapper.mapToReceiver(receiverDto));
    }
}

