package com.example.domain.driven.skeleton.infrastructure.repo.dataobj;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "balance")
public class BalanceDO {
    @Id
    @GeneratedValue
    private long id;
    private String currencyTypeDenote;
    private float amount;
}
