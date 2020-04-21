package com.kodilla.bankApp.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name="payments")
public class Payment {

    //TODO need to be extended

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="account")
    private String account;

    //TODO need to be changed to BigDecimal
    @Column(name="amount")
    private Double amount;

    @Column(name="currency")
    private String currency;

}
