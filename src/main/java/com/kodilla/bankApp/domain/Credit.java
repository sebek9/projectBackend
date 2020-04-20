package com.kodilla.bankApp.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name="credits")
public class Credit {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="credit_name")
    private String creditName;

    @Column(name="credit_type")
    private String creditType;

    @Column(name="amount")
    private Integer amount;

    @Column(name="status")
    private String status;

}