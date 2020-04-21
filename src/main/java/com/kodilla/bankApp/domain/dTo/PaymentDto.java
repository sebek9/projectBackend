package com.kodilla.bankApp.domain.dTo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto {
    private Long id;
    private String account;
    private Double amount;
    private String currency;

}
