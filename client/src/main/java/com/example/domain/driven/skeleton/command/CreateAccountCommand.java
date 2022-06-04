package com.example.domain.driven.skeleton.command;

import lombok.Data;

@Data
public class CreateAccountCommand {
    private float initBalance;
    private final String denote = "USD";
    private String name;
    private String identityNumber;
    private Integer age;
}
