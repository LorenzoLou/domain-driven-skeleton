package com.example.domain.driven.skeleton.adapter.rest;

import com.example.domain.driven.skeleton.adapter.AdapterConverter;
import com.example.domain.driven.skeleton.biz.dto.AccountDTO;
import com.example.domain.driven.skeleton.biz.dto.CustomerDTO;
import com.example.domain.driven.skeleton.biz.dto.MoneyDTO;
import com.example.domain.driven.skeleton.biz.query.AccountQueryService;
import com.example.domain.driven.skeleton.biz.service.AccountApplicationService;
import com.example.domain.driven.skeleton.command.CreateAccountCommand;
import com.example.domain.driven.skeleton.command.TransferMoneyCommand;
import com.example.domain.driven.skeleton.domain.valueobj.Money;
import com.example.domain.driven.skeleton.domain.valueobj.enums.CurrencyType;
import com.example.domain.driven.skeleton.vo.AccountVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RestAPIAdaptor {
    private final AdapterConverter adapterConverter;
    private final AccountApplicationService accountApplicationService;
    private final AccountQueryService accountQueryService;

    public void createAccount(CreateAccountCommand command) {
        AccountDTO accountDTO = adapterConverter.convert(command);
        accountApplicationService.createAccount(accountDTO);
    }

    public void transfer(TransferMoneyCommand command) {
        accountApplicationService.transferMoney(
                command.getSourceAccountNumber(),
                command.getDestAccountNumber(),
                new Money(CurrencyType.USD, command.getAmount()));
    }

    public AccountVO getAccount(Long accountNumber) {
        AccountDTO accountDTO = accountQueryService.getAccountByAccountNumber(accountNumber);
        if (accountDTO == null) {
            return null;
        }
        return adapterConverter.convert(accountDTO);
    }
}
