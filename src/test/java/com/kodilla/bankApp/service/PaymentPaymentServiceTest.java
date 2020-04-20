package com.kodilla.bankApp.service;

import com.kodilla.bankApp.controller.PaymentController;
import com.kodilla.bankApp.domain.Payment;
import com.kodilla.bankApp.repository.PaymentRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PaymentPaymentServiceTest {

    @InjectMocks
    private PaymentService paymentService;

    @Mock
    private PaymentRepository paymentRepository;

    @Mock
    private PaymentController paymentController;

    @Test
    public void shouldGetAllTasks() {
        //Given
        List<Payment> payments = new ArrayList<>();
        payments.add(new Payment(1L, "88888888888", 200.00, "PLN"));

        when(paymentRepository.findAll()).thenReturn(payments);

        //When
        List<Payment> theList = paymentService.getAllPayments();

        //Then
        assertEquals(1, theList.size());
    }

    @Test
    public void shouldGetTask() {
        //Given
        Payment payment = new Payment(1L, "88888888888", 200.00, "PLN");
        long t = 1L;
        when(paymentRepository.findById(t)).thenReturn(Optional.ofNullable(payment));

        //When
        Optional<Payment> theList = paymentService.getPayment(t);
        long o = theList.get().getId();

        //Then
        assertEquals(1L, o);
    }

    @Test
    public void shouldSaveTask() {
        //Given
        Payment payment = new Payment(1L, "88888888888", 200.00, "PLN");

        when(paymentRepository.save(any())).thenReturn(payment);

        //When
        Payment thePayment = paymentService.savePayment(payment);
        long id = thePayment.getId();

        //Then
        assertEquals(1L, id);
        assertEquals("88888888888", thePayment.getAccount());
    }

    @Test
    public void shouldDeleteTask() {
        //Given
        Payment payment = new Payment(1L, "88888888888", 200.00, "PLN");
        long paymentId = payment.getId();

        //When
        paymentController.deletePayment(paymentId);

        //Then
        verify(paymentController, times(1)).deletePayment(paymentId);
    }
}

