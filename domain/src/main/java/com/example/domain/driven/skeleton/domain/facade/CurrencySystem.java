package com.example.domain.driven.skeleton.domain.facade;

import com.example.domain.driven.skeleton.domain.valueobj.Money;

public interface CurrencySystem {
    Money toDollar(Money money);
}
