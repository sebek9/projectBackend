package com.kodilla.bankApp.controller;

import com.kodilla.bankApp.domain.Payment;
import com.kodilla.bankApp.domain.dTo.PaymentDto;
import com.kodilla.bankApp.mapper.PaymentMapper;
import com.kodilla.bankApp.service.PaymentService;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

//import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import com.google.gson.Gson;

import org.mockito.ArgumentMatchers;
import org.springframework.http.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(PaymentController.class)
public class PaymentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PaymentService service;

    @MockBean
    private PaymentMapper paymentMapper;

    @Test
    public void shouldGetPayments() throws Exception {
        //given
        List<Payment> payments = new ArrayList<>();
        payments.add(new Payment(1L, "88888888888", 200.00, "PLN"));
        payments.add(new Payment(2L, "99999999999", 500.00, "EUR"));

        List<PaymentDto> paymentDto = new ArrayList<>();
        paymentDto.add(new PaymentDto(1L, "88888888888", 200.00, "PLN"));
        paymentDto.add(new PaymentDto(2L, "99999999999", 500.00, "EUR"));

        when(service.getAllPayments()).thenReturn(payments);
        when(paymentMapper.mapToPaymentDtoList(payments)).thenReturn(paymentDto);

        //when & then
        mockMvc.perform(get("/v1/payment/").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].account", is("88888888888")))
                .andExpect(jsonPath("$[0].amount", is(200.00)))
                .andExpect(jsonPath("$[0].currency", is("PLN")))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].account", is("99999999999")))
                .andExpect(jsonPath("$[1].amount", is(500.00)))
                .andExpect(jsonPath("$[1].currency", is("EUR")));

        verify(service, times(1)).getAllPayments();
        verify(paymentMapper, times(1)).mapToPaymentDtoList(payments);
    }

    @Test
    public void shouldGetTask() throws Exception {
        //Given
        PaymentDto paymentDto1 = new PaymentDto(1L, "88888888888", 200.00, "PLN");
        PaymentDto paymentDto2 = new PaymentDto(2L, "555555555", 40.0, "PLN");
        List<PaymentDto> paymentList = new ArrayList<>();
        paymentList.add(paymentDto1);
        paymentList.add(paymentDto2);

        Payment payment = new Payment();

        when(paymentMapper.mapToPaymentDto(any())).thenReturn(paymentDto1);
        when(service.getPayment(ArgumentMatchers.anyLong())).thenReturn(java.util.Optional.ofNullable(payment));

        //When & Then
        mockMvc.perform(get("/v1/payment/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].account", is("88888888888")))
                .andExpect(jsonPath("$[0].amount", is(200.00)))
                .andExpect(jsonPath("$[0].currency", is("PLN")));
    }

    @Test
    public void shouldDeleteTask() throws Exception {
        //Given
        Payment payment = new Payment(1L, "77777777", 200.00, "PLN");

        when(service.getPayment(1L)).thenReturn(Optional.of(payment));

        //When & Then
        mockMvc.perform(delete("/v1/payment/deletePayment")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .param("paymentId", "1"));
              //  .andExpect(status().is(200));

        verify(service, times(1)).deletePayment(1L);
    }


    @Test
    public void shouldUpdateTask() throws Exception {
        //Given
        PaymentDto paymentDto = new PaymentDto(5L,"77777777",200.00, "PLN");
        Payment payment = new Payment();

        when(paymentMapper.mapToPayment(any())).thenReturn(payment);
        when(service.savePayment(payment)).thenReturn(any());
        when(paymentMapper.mapToPaymentDto(payment)).thenReturn(paymentDto);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(paymentDto);

        //When & Then
        mockMvc.perform(put("/v1/task").content(jsonContent).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(5)))
                .andExpect(jsonPath("$.title", is("Test_task")))
                .andExpect(jsonPath("$.content", is("Zadanie_1")));
    }

    @Test
    public void shouldCreateTask() throws Exception {
        //Given
        Payment payment = new Payment(1L, "77777777",200.00, "PLN");
        PaymentDto paymentDto = new PaymentDto(1L, "77777777",200.00, "PLN");

        when(paymentMapper.mapToPayment(ArgumentMatchers.any(PaymentDto.class))).thenReturn(payment);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(paymentDto);

        //When & Then
        mockMvc.perform(post("/v1/payment/").content(jsonContent).contentType(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().is(200));

        verify(service, times(1)).savePayment(payment);
    }
}
