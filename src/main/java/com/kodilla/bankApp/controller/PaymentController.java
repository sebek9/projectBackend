package com.kodilla.bankApp.controller;

import com.kodilla.bankApp.domain.PaymentDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("v1/payment")
public class PaymentController {

    @RequestMapping(method = RequestMethod.GET,value = "getPayments")
    public List<PaymentDto> getPayments(){
        return new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.GET,value = "getPayment")
    public PaymentDto getPayment(Long paymentId){
        return new PaymentDto(1L,"12345",1000,"PLN");
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "deletePayment")
    public void deletePayment(Long paymentId){

    }
    @RequestMapping(method = RequestMethod.PUT,value = "updatePayment")
    public PaymentDto updatePayment(PaymentDto paymentDto){
        return new PaymentDto(1L,"898989",1500,"EUR");
    }
    @RequestMapping(method = RequestMethod.POST,value = "createPayment")
   public void createPayment(PaymentDto paymentDto){

   }
}
