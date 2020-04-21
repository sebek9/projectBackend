package com.kodilla.bankApp.domain.dTo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CardDto {
    private Long id;
    private String cardNumber;
    private String cardType;
    private String cardHolder;
    private String status;

}


