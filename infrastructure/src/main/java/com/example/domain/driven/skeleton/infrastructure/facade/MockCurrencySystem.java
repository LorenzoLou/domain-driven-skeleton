package com.example.domain.driven.skeleton.infrastructure.facade;

import com.example.domain.driven.skeleton.domain.facade.CurrencySystem;
import com.example.domain.driven.skeleton.domain.valueobj.Money;
import com.example.domain.driven.skeleton.domain.valueobj.enums.CurrencyType;
import org.springframework.stereotype.Component;

@Component
public class MockCurrencySystem implements CurrencySystem {
    @Override
    public Money toDollar(Money money) {
        Float convertedAmount;
        switch (money.getCurrencyType()) {
            case RMB: convertedAmount = money.getAmount() * 7.8F; break;
            case USD: convertedAmount = money.getAmount(); break;
            default: throw new RuntimeException("unrecognised currency");
        }
        return new Money(CurrencyType.USD, convertedAmount);
    }
}
