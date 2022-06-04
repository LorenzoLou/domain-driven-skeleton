package com.example.domain.driven.skeleton.domain.aggregate;

import com.example.domain.driven.skeleton.domain.entity.Customer;
import com.example.domain.driven.skeleton.domain.facade.CurrencySystem;
import com.example.domain.driven.skeleton.domain.valueobj.Money;
import lombok.*;

@AllArgsConstructor
public class Account {
    @Getter
    @Setter
    private Long accountNumber;

    @Getter
    @Setter
    private Customer customer;

    // to simplify this scenario, Let's assume that all bank account money is denominated in USD
    @Getter
    @Setter
    private Money balance;

    @Setter
    private CurrencySystem currencySystem;

    @SneakyThrows
    public void withDraw(Money money) {
        Money withDrawMoney = currencySystem.toDollar(money);
        if (balance.getAmount() >= withDrawMoney.getAmount()) {
            balance.setAmount(balance.getAmount() - withDrawMoney.getAmount());
        } else {
            throw new Exception("no enough money");
        }
    }

    public void deposit(Money money) {
        Money depositMoney = currencySystem.toDollar(money);
        balance.setAmount(balance.getAmount() + depositMoney.getAmount());
    }
}
