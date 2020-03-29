package com.kodilla.bankApp.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto {
    private Long id;
    private String account;
    private Double amount; //change to bigDecimal
    private String currency;

}
