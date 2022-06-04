package com.example.domain.driven.skeleton.adapter.rest;

import com.example.domain.driven.skeleton.biz.service.AccountApplicationService;
import com.example.domain.driven.skeleton.command.CreateAccountCommand;
import com.example.domain.driven.skeleton.command.TransferMoneyCommand;
import com.example.domain.driven.skeleton.vo.AccountVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1")
@RequiredArgsConstructor
public class AccountRestAPI {

    private  final RestAPIAdaptor restAPIAdaptor;

    @GetMapping(value = "/account")
    public AccountVO getAccount(@RequestParam Long accountNumber) {
        return restAPIAdaptor.getAccount(accountNumber);
    }

    @PostMapping(value = "/account")
    public void createAccount(@RequestBody CreateAccountCommand command) {
        restAPIAdaptor.createAccount(command);
    }

    @PostMapping(value = "/account/transfer")
    public void transfer(@RequestBody TransferMoneyCommand command) {
        restAPIAdaptor.transfer(command);
    }
}
