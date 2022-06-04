package com.example.domain.driven.skeleton.adapter;

import com.example.domain.driven.skeleton.biz.dto.AccountDTO;
import com.example.domain.driven.skeleton.biz.dto.CustomerDTO;
import com.example.domain.driven.skeleton.biz.dto.MoneyDTO;
import com.example.domain.driven.skeleton.command.CreateAccountCommand;
import com.example.domain.driven.skeleton.domain.valueobj.enums.CurrencyType;
import com.example.domain.driven.skeleton.vo.AccountVO;
import com.example.domain.driven.skeleton.vo.CustomerVO;
import com.example.domain.driven.skeleton.vo.MoneyVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface AdapterConverter {
    @Mappings(
            value = {
                    @Mapping(source = "initBalance", target = "balanceDTO.amount"),
                    @Mapping(source = "name", target = "customerDTO.name"),
                    @Mapping(source = "identityNumber", target = "customerDTO.identityNumber"),
                    @Mapping(source = "age", target = "customerDTO.age"),
                    @Mapping(source = "denote", target = "balanceDTO.currencyType")
            }
    )
    AccountDTO convert(CreateAccountCommand createAccountCommand);

    default CurrencyType customConverter(String denote){
        return CurrencyType.parseDenote(denote);
    }

    @Mappings(
            value = {
                    @Mapping(source = "customerDTO", target = "customerVO"),
                    @Mapping(source = "balanceDTO", target = "balanceVO")
            }
    )
    AccountVO convert(AccountDTO accountDTO);

    CustomerVO convert(CustomerDTO customerDTO);

    @Mappings(
            value = {
                    @Mapping(source = "currencyType.denote", target = "currencyTypeDenote")
            }
    )
    MoneyVO convert(MoneyDTO moneyDTO);
}
