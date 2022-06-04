package com.example.domain.driven.skeleton.infrastructure.repo;

import com.example.domain.driven.skeleton.domain.aggregate.Account;
import com.example.domain.driven.skeleton.domain.entity.Customer;
import com.example.domain.driven.skeleton.domain.valueobj.Money;
import com.example.domain.driven.skeleton.domain.valueobj.enums.CurrencyType;
import com.example.domain.driven.skeleton.infrastructure.repo.dataobj.AccountDO;
import com.example.domain.driven.skeleton.infrastructure.repo.dataobj.CustomerDO;
import com.example.domain.driven.skeleton.infrastructure.repo.dataobj.BalanceDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface InfrastructureConverter {
    @Mappings(
            value = {
                    @Mapping(target = "customer", source = "customerDO"),
                    @Mapping(target = "balance", source = "balanceDO")
            }
    )
    Account copy(AccountDO accountDO);

    Customer copy(CustomerDO customerDO);

    @Mappings(
            value = {
                    @Mapping(source = "currencyTypeDenote", target = "currencyType")
            }
    )
    Money copy(BalanceDO balanceDO);

    default CurrencyType customConverter(String denote){
        return CurrencyType.parseDenote(denote);
    }

    @Mappings(
            value = {
                    @Mapping(source = "customer", target = "customerDO"),
                    @Mapping(source = "balance", target = "balanceDO")
            }
    )
    AccountDO copy(Account account);

    CustomerDO copy(Customer customer);

    @Mappings(
            value = {
                    @Mapping(source = "currencyType.denote", target = "currencyTypeDenote")
            }
    )
    BalanceDO copy(Money money);
}
