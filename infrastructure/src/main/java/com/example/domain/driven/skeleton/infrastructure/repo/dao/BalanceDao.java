package com.example.domain.driven.skeleton.infrastructure.repo.dao;

import com.example.domain.driven.skeleton.infrastructure.repo.dataobj.BalanceDO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BalanceDao extends JpaRepository<BalanceDO, Long> {
}
