package com.example.domain.driven.skeleton.biz.dto;

import com.example.domain.driven.skeleton.domain.aggregate.Account;
import com.example.domain.driven.skeleton.domain.entity.Customer;
import com.example.domain.driven.skeleton.domain.valueobj.Money;
import com.example.domain.driven.skeleton.infrastructure.repo.dataobj.AccountDO;
import com.example.domain.driven.skeleton.infrastructure.repo.dataobj.BalanceDO;
import com.example.domain.driven.skeleton.infrastructure.repo.dataobj.CustomerDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface BizConverter {
    @Mappings(
            value = {
                    @Mapping(source = "customerDO", target = "customerDTO"),
                    @Mapping(source = "balanceDO", target = "balanceDTO")
            }
    )
    AccountDTO copy(AccountDO accountDO);

    CustomerDTO copy(CustomerDO customerDO);

    @Mappings(
            value = {
                    @Mapping(source = "currencyTypeDenote", target = "currencyType")
            }
    )
    MoneyDTO copy(BalanceDO balanceDO);

    @Mappings(
            value = {
                    @Mapping(source = "customerDTO", target = "customer"),
                    @Mapping(source = "balanceDTO", target = "balance")
            }
    )
    Account copy(AccountDTO accountDTO);


    Customer copy(CustomerDTO customerDTO);


    Money copy(MoneyDTO moneyDTO);
}
