package com.example.domain.driven.skeleton.domain.entity;

import lombok.Data;

@Data
public class Customer {
    private Long id;
    private String name;
    private String identityNumber;
    private Integer age;
}
