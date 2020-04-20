package com.kodilla.bankApp.mapper;

import com.kodilla.bankApp.domain.Payment;
import com.kodilla.bankApp.domain.dTo.PaymentDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PaymentMapper {
    public Payment mapToPayment(final PaymentDto paymentDto){
        return new Payment(
                paymentDto.getId(),
                paymentDto.getAccount(),
                paymentDto.getAmount(),
                paymentDto.getCurrency()
        );
    }
    public PaymentDto mapToPaymentDto(final Payment payment){
        return new PaymentDto(
                payment.getId(),
                payment.getAccount(),
                payment.getAmount(),
                payment.getCurrency()
        );
    }

    public List<PaymentDto>mapToPaymentDtoList(final List<Payment>paymentList){
        return paymentList.stream()
                .map(p->new PaymentDto(p.getId(),p.getAccount(),p.getAmount(),p.getCurrency()))
                .collect(Collectors.toList());
    }
}
