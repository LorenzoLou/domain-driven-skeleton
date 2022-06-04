package com.example.domain.driven.skeleton.biz.factory;

import com.example.domain.driven.skeleton.biz.dto.AccountDTO;
import com.example.domain.driven.skeleton.biz.dto.BizConverter;
import com.example.domain.driven.skeleton.domain.aggregate.Account;
import com.example.domain.driven.skeleton.domain.entity.Customer;
import com.example.domain.driven.skeleton.domain.facade.CurrencySystem;
import com.example.domain.driven.skeleton.domain.valueobj.Money;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountFactory {

    private final BizConverter bizConverter;
    private final CurrencySystem currencySystem;

    public Account newAccount(AccountDTO accountDTO) {
        Account account = bizConverter.copy(accountDTO);
        Customer customer = bizConverter.copy(accountDTO.getCustomerDTO());
        Money balance = bizConverter.copy(accountDTO.getBalanceDTO());
        account.setCustomer(customer);
        account.setBalance(balance);
        account.setCurrencySystem(currencySystem);
        return account;
    }
}
