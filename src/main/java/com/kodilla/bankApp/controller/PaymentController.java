package com.kodilla.bankApp.controller;

import com.kodilla.bankApp.domain.PaymentDto;
import com.kodilla.bankApp.mapper.PaymentMapper;
import com.kodilla.bankApp.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("v1/payment")
@CrossOrigin(origins ="*")
public class PaymentController {
    @Autowired
    private DbService service;
    @Autowired
    private PaymentMapper paymentMapper;

    @RequestMapping(method = RequestMethod.GET,value = "/getPayments")
    public List<PaymentDto> getPayments() {
        return paymentMapper.mapToPaymentDtoList(service.getAllPayments());
    }

    @RequestMapping(method = RequestMethod.GET,value = "/getPayment")
    public PaymentDto getPayment(Long paymentId) throws PaymenNotFoundException{
        return paymentMapper.mapToPaymentDto(service.getPayment(paymentId).orElseThrow(PaymenNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/deletePayment")
    public void deletePayment(Long paymentId){

    }
    @RequestMapping(method = RequestMethod.PUT,value = "/updatePayment")
    public PaymentDto updatePayment(@RequestBody PaymentDto paymentDto){
        return paymentMapper.mapToPaymentDto(service.savePayment(paymentMapper.mapToPayment(paymentDto))); }

    //@RequestMapping(method = RequestMethod.POST,value = "/createPayment",consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(method = RequestMethod.POST,value = "/createPayment")
    public void createPayment(@RequestBody PaymentDto paymentDto){
    service.savePayment(paymentMapper.mapToPayment(paymentDto));
   }
}
