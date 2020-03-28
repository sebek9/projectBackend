package com.kodilla.bankApp.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class Payment {
    private long id;
    private String accountNumber;
    private double amount;//change to bigDecimal
    private String currency;

}
