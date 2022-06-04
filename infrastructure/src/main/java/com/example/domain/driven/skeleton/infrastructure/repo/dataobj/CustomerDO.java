package com.example.domain.driven.skeleton.infrastructure.repo.dataobj;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "customer")
public class CustomerDO {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String identityNumber;
    private Integer age;
}
