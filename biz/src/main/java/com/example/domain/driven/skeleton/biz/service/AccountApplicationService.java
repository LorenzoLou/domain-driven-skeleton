package com.example.domain.driven.skeleton.biz.service;

import com.example.domain.driven.skeleton.biz.dto.AccountDTO;
import com.example.domain.driven.skeleton.biz.factory.AccountFactory;
import com.example.domain.driven.skeleton.domain.aggregate.Account;
import com.example.domain.driven.skeleton.domain.repo.AccountRepository;
import com.example.domain.driven.skeleton.domain.service.AccountDomainService;
import com.example.domain.driven.skeleton.domain.valueobj.Money;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountApplicationService {
    private final AccountDomainService accountDomainService;
    private final AccountRepository accountRepository;
    private final AccountFactory accountFactory;

    @SneakyThrows
    @Transactional
    public void transferMoney(Long sourceAccountNumber, Long destAccountNumber, Money amount) {
        Account source = accountRepository.load(sourceAccountNumber);
        Account dest = accountRepository.load(destAccountNumber);
        if (source == null || dest == null) {
            log.error("error account number: source {}, dest: {}, amount {}",
                    sourceAccountNumber, destAccountNumber, amount);
            throw new Exception("invalid account number");
        }
        accountDomainService.transferMoney(source, dest, amount);
        accountRepository.store(source);
        accountRepository.store(dest);
    }

    public void createAccount(AccountDTO accountDTO) {
        Account account = accountFactory.newAccount(accountDTO);
        accountRepository.store(account);
    }
}
