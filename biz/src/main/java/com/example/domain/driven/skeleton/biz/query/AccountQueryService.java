package com.example.domain.driven.skeleton.biz.query;

import com.example.domain.driven.skeleton.biz.dto.AccountDTO;
import com.example.domain.driven.skeleton.biz.dto.CustomerDTO;
import com.example.domain.driven.skeleton.biz.dto.BizConverter;
import com.example.domain.driven.skeleton.biz.dto.MoneyDTO;
import com.example.domain.driven.skeleton.infrastructure.repo.dao.AccountDao;
import com.example.domain.driven.skeleton.infrastructure.repo.dataobj.AccountDO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountQueryService {
    private final AccountDao accountDao;
    private final BizConverter bizConverter;

    public AccountDTO getAccountByAccountNumber(Long accountNumber) {
        Optional<AccountDO> accountDOOptional = accountDao.findById(accountNumber);
        if (accountDOOptional.isEmpty()) {
            return null;
        }
        AccountDO accountDO = accountDOOptional.get();
        AccountDTO accountDTO = bizConverter.copy(accountDO);
        CustomerDTO customerDTO = bizConverter.copy(accountDO.getCustomerDO());
        MoneyDTO moneyDTO = bizConverter.copy(accountDO.getBalanceDO());
        accountDTO.setCustomerDTO(customerDTO);
        accountDTO.setBalanceDTO(moneyDTO);
        return accountDTO;
    }
}
