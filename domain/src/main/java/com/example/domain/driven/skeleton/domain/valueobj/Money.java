package com.example.domain.driven.skeleton.domain.valueobj;

import com.example.domain.driven.skeleton.domain.valueobj.enums.CurrencyType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Money {
    private CurrencyType currencyType;
    private Float amount;
}
