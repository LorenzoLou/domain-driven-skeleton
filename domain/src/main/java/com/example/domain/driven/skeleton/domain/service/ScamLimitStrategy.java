package com.example.domain.driven.skeleton.domain.service;

import com.example.domain.driven.skeleton.domain.aggregate.Account;
import com.example.domain.driven.skeleton.domain.facade.CurrencySystem;
import com.example.domain.driven.skeleton.domain.valueobj.Money;
import com.example.domain.driven.skeleton.domain.valueobj.enums.CurrencyType;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScamLimitStrategy implements LimitStrategy{

    private final Money TRANSFER_AMOUNT = new Money(CurrencyType.USD, 1000F);


    private final CurrencySystem currencySystem;

    @Override
    @SneakyThrows
    public void allowable(Account source, Account dest, Money transferAmount) {
        Money sourceMoney = currencySystem.toDollar(transferAmount);
        Integer THRESHOLD = 80;
        if (source.getCustomer().getAge() <= THRESHOLD || sourceMoney.getAmount() <= TRANSFER_AMOUNT.getAmount()) {
            throw new Exception("scam alarm");
        }
    }
}
