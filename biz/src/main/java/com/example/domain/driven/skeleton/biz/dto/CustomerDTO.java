package com.example.domain.driven.skeleton.biz.dto;

import com.example.domain.driven.skeleton.domain.entity.Customer;
import com.example.domain.driven.skeleton.domain.valueobj.Money;
import lombok.Data;

@Data
public class CustomerDTO {
    private long id;
    private String name;
    private String identityNumber;
    private Integer age;
}
