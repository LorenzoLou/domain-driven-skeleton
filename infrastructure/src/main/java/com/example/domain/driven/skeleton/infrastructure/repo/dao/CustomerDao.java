package com.example.domain.driven.skeleton.infrastructure.repo.dao;

import com.example.domain.driven.skeleton.infrastructure.repo.dataobj.AccountDO;
import com.example.domain.driven.skeleton.infrastructure.repo.dataobj.CustomerDO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<CustomerDO, Long> {
}
