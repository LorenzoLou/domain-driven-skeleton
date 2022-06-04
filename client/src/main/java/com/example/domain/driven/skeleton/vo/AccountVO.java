package com.example.domain.driven.skeleton.vo;

import lombok.Data;

@Data
public class AccountVO {
    private Long accountNumber;

    private CustomerVO customerVO;

    private MoneyVO balanceVO;
}
