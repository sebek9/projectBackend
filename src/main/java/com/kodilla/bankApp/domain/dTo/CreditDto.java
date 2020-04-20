package com.kodilla.bankApp.domain.dTo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreditDto {
    private Long id;
    private String creditName;
    private String creditType;
    private Integer amount;
    private String status;

}
