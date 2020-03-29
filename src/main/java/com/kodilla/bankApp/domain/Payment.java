package com.kodilla.bankApp.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name="payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name="accountNumber") //do weryfikacji
    private String accountNumber;
    @Column(name="amount")
    private double amount;//change to bigDecimal
    @Column(name="currency")
    private String currency;

}
