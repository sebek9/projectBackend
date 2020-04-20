package com.kodilla.bankApp.domain.dTo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReceiverDto {
    private Long id;
    private String name;
    private String surname;
    private String address;
}
