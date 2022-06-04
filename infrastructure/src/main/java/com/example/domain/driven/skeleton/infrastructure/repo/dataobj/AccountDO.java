package com.example.domain.driven.skeleton.infrastructure.repo.dataobj;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "account")
public class AccountDO {
    @Id
    @GeneratedValue
    private Long accountNumber;
    @OneToOne
    private CustomerDO customerDO;
    @OneToOne
    private BalanceDO balanceDO;
}
