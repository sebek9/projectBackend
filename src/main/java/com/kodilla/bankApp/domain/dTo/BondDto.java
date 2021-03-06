package com.kodilla.bankApp.domain.dTo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BondDto {
    private Long id;
    private String issuer;
    private Integer units;
    private String unitValue;

}


