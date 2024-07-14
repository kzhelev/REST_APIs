package com.example.springdataapi.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RequestDTO {

    private String customerNo;
    private String currency;
    private double amount;
}
