package com.example.domain.driven.skeleton.domain.service;

import com.example.domain.driven.skeleton.domain.aggregate.Account;
import com.example.domain.driven.skeleton.domain.repo.AccountRepository;
import com.example.domain.driven.skeleton.domain.valueobj.Money;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountDomainService {
    private final List<LimitStrategy> limitStrategyList;

    public void transferMoney(Account source, Account dest, Money money) {
        for (LimitStrategy limitStrategy : limitStrategyList) {
            limitStrategy.allowable(source, dest, money);
        }
        source.withDraw(money);
        dest.deposit(money);
    }
}
