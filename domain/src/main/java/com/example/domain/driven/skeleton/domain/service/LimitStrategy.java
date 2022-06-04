package com.example.domain.driven.skeleton.domain.service;

import com.example.domain.driven.skeleton.domain.aggregate.Account;
import com.example.domain.driven.skeleton.domain.valueobj.Money;

public interface LimitStrategy {
    void allowable(Account source, Account dest, Money transferAmount);
}
