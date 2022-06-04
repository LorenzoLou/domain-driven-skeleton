package com.example.domain.driven.skeleton.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.Entity;

@SpringBootApplication(scanBasePackages = {
        "com.example.domain.driven.skeleton.adapter",
        "com.example.domain.driven.skeleton.biz",
        "com.example.domain.driven.skeleton.domain",
        "com.example.domain.driven.skeleton.infrastructure",
})
@EnableJpaRepositories(basePackages = "com.example.domain.driven.skeleton.infrastructure.repo.dao")
@EntityScan(basePackages = "com.example.domain.driven.skeleton.infrastructure.repo.dataobj")
public class BootstrapApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootstrapApplication.class, args);
    }

}
