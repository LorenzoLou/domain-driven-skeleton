package com.example.domain.driven.skeleton.command;

import lombok.Data;

@Data
public class TransferMoneyCommand {
    private Long sourceAccountNumber;
    private Long destAccountNumber;
    private float amount;
}
