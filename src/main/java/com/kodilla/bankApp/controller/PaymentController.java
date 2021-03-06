package com.kodilla.bankApp.controller;

import com.kodilla.bankApp.controller.exceptions.PaymentNotFoundException;
import com.kodilla.bankApp.domain.dTo.PaymentDto;
import com.kodilla.bankApp.facade.PaymentFacade;
import com.kodilla.bankApp.mapper.PaymentMapper;
import com.kodilla.bankApp.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("v1/payment")
@CrossOrigin(origins ="*")
public class PaymentController {
    @Autowired
    private PaymentService service;
    @Autowired
    private PaymentMapper paymentMapper;
    @Autowired
    private PaymentFacade paymentFacade;


    @RequestMapping(method = RequestMethod.GET,value = "/getPayments")
    public List<PaymentDto> getPayments() {
        return paymentFacade.getPayments();
    }

    @RequestMapping(method = RequestMethod.GET,value = "/getPayment")
    public PaymentDto getPayment(Long paymentId) throws PaymentNotFoundException {
        return paymentMapper.mapToPaymentDto(service.getPayment(paymentId).orElseThrow(PaymentNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/deletePayment")
    public void deletePayment(@RequestParam Long paymentId){
        service.deletePayment(paymentId);
    }
    @RequestMapping(method = RequestMethod.PUT,value = "/updatePayment")
    public PaymentDto updatePayment(@RequestBody PaymentDto paymentDto){
        return paymentMapper.mapToPaymentDto(service.savePayment(paymentMapper.mapToPayment(paymentDto))); }

    @RequestMapping(method = RequestMethod.POST,value = "/createPayment",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createPayment(@RequestBody PaymentDto paymentDto){
        paymentFacade.createPayment(paymentDto);
    }
}

