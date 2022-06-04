package com.example.domain.driven.skeleton.vo;

import lombok.Data;

@Data
public class CustomerVO {
    private long id;
    private String name;
    private String identityNumber;
    private Integer age;
}
