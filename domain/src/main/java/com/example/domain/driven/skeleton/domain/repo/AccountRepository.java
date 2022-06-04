package com.example.domain.driven.skeleton.domain.repo;

import com.example.domain.driven.skeleton.domain.aggregate.Account;

public interface AccountRepository {
    Long store(Account account);
    Account load(Long id);
}
