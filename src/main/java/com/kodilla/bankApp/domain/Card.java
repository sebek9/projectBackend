package com.kodilla.bankApp.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name="cards")
public class Card {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="card_number") //do weryfikacji
    private String cardNumber;

    @Column(name="card_type")
    private String cardType;

    @Column(name="card_holder")
    private String cardHolder;

    @Column(name="status")
    private String status;

}