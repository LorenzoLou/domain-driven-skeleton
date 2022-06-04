package com.example.domain.driven.skeleton.biz.dto;

import com.example.domain.driven.skeleton.domain.valueobj.enums.CurrencyType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MoneyDTO {
    private CurrencyType currencyType;
    private Float amount;
}
