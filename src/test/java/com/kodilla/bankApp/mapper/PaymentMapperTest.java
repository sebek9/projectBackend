package com.kodilla.bankApp.mapper;


import com.kodilla.bankApp.domain.Payment;
import com.kodilla.bankApp.domain.dTo.PaymentDto;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class PaymentMapperTest {


    @InjectMocks
    private PaymentMapper paymentMapper;


    @Test
    public void testMapToPayment(){
        //Given
        PaymentDto paymentDto1=new PaymentDto(1L, "88888888888", 200.00, "PLN");

        //When
        Payment payment=paymentMapper.mapToPayment(paymentDto1);

        //Then
        assertEquals("88888888888",payment.getAccount());
        assertEquals(200.00,payment.getAccount());
        assertEquals("PLN",payment.getCurrency());
    }

    @Test
    public void testMapToPaymentDto(){
        //Given
        Payment payment1=new Payment(1L, "88888888888", 200.00, "PLN");
        //When
        PaymentDto paymentDto=paymentMapper.mapToPaymentDto(payment1);
        //Then
        assertEquals("88888888888", payment1.getAccount());
        //TODO poprawic
      //  assertEquals(200.00, payment1.getAmount());
        assertEquals("PLN",payment1.getCurrency());
    }

    @Test
    public void testMapToPaymentDtoList(){

        //Given
        PaymentDto paymentDto = new PaymentDto(1L, "88888888888", 200.00, "PLN");
        List<PaymentDto> paymentDtoList = Arrays.asList(paymentDto);

        Payment payment=new Payment(1L, "88888888888", 200.00, "PLN");
        List<Payment> paymentList = Arrays.asList(payment);

        //When
        List<PaymentDto> mappedList = paymentMapper.mapToPaymentDtoList(paymentList);

        //Then
        assertNotNull(mappedList);
        assertEquals(1, mappedList.size());

        mappedList.forEach(t -> {
            assertEquals(paymentDto.getId(), t.getId());
            assertEquals(paymentDto.getAccount(), t.getAccount());
            assertEquals(paymentDto.getAmount(),t.getAmount());
            assertEquals(paymentDto.getCurrency(),t.getCurrency());
        });
    }


}









