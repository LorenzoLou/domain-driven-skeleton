package com.example.domain.driven.skeleton.infrastructure.repo;

import com.example.domain.driven.skeleton.domain.aggregate.Account;
import com.example.domain.driven.skeleton.domain.entity.Customer;
import com.example.domain.driven.skeleton.domain.facade.CurrencySystem;
import com.example.domain.driven.skeleton.domain.repo.AccountRepository;
import com.example.domain.driven.skeleton.domain.valueobj.Money;
import com.example.domain.driven.skeleton.infrastructure.repo.dao.AccountDao;
import com.example.domain.driven.skeleton.infrastructure.repo.dao.BalanceDao;
import com.example.domain.driven.skeleton.infrastructure.repo.dao.CustomerDao;
import com.example.domain.driven.skeleton.infrastructure.repo.dataobj.AccountDO;
import com.example.domain.driven.skeleton.infrastructure.repo.dataobj.CustomerDO;
import com.example.domain.driven.skeleton.infrastructure.repo.dataobj.BalanceDO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AccountRepositoryImpl implements AccountRepository {
    private final InfrastructureConverter infrastructureConverter;
    private final AccountDao accountDao;
    private final BalanceDao balanceDao;
    private final CustomerDao customerDao;
    private final CurrencySystem currencySystem;

    @Override
    public Long store(Account account) {
        AccountDO accountDO = infrastructureConverter.copy(account);
        CustomerDO customerDO = customerDao.save(accountDO.getCustomerDO());
        BalanceDO balanceDO = balanceDao.save(accountDO.getBalanceDO());
        accountDO.setCustomerDO(customerDO);
        accountDO.setBalanceDO(balanceDO);
        return accountDao.save(accountDO).getAccountNumber();
    }

    @Override
    public Account load(Long id) {
        Optional<AccountDO> accountDOOptional = accountDao.findById(id);
        if (accountDOOptional.isEmpty()) {
            return null;
        }
        AccountDO accountDO = accountDOOptional.get();
        Account account = infrastructureConverter.copy(accountDO);
        Customer customer = infrastructureConverter.copy(accountDO.getCustomerDO());
        Money money = infrastructureConverter.copy(accountDO.getBalanceDO());
        account.setBalance(money);
        account.setCustomer(customer);
        account.setCurrencySystem(currencySystem);
        return account;
    }
}
