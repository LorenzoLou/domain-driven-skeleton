package com.example.domain.driven.skeleton.biz.dto;

import lombok.Data;

@Data
public class AccountDTO {
    private Long accountNumber;

    private CustomerDTO customerDTO;

    private MoneyDTO balanceDTO;
}
