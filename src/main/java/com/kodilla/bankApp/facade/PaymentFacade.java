package com.kodilla.bankApp.facade;

import com.kodilla.bankApp.domain.Payment;
import com.kodilla.bankApp.domain.dTo.PaymentDto;
import com.kodilla.bankApp.mapper.PaymentMapper;
import com.kodilla.bankApp.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PaymentFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentFacade.class);

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private PaymentMapper paymentMapper;


    public List<PaymentDto> getPayments() {
        List<PaymentDto> paymentList = paymentMapper.mapToPaymentDtoList(paymentService.getAllPayments());
        return paymentList;
    }

    public Payment createPayment(PaymentDto paymentDto) {
        return paymentService.savePayment(paymentMapper.mapToPayment(paymentDto));
    }

}
