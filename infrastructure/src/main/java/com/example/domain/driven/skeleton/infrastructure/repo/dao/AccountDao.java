package com.example.domain.driven.skeleton.infrastructure.repo.dao;

import com.example.domain.driven.skeleton.infrastructure.repo.dataobj.AccountDO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountDao extends JpaRepository<AccountDO, Long> {
}
