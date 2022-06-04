package com.example.domain.driven.skeleton.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoneyVO {
    private String currencyTypeDenote;
    private Float amount;
}
