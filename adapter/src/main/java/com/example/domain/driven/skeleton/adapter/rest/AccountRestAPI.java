package com.example.domain.driven.skeleton.adapter.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1")
@RequiredArgsConstructor
public class AccountRestAPI {

    @GetMapping(value = "/hello-world")
    public String helloWorld() {
        return "hello world";
    }
}
