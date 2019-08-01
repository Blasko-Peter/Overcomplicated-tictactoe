package com.codecool.enterprise.funfact.service;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class CNFunfactCallerTest {

    @Autowired
    private CNFunfactCaller cnFunfactCaller;

    @RepeatedTest(25)
    void cnfunfact() {
        assertThat(cnFunfactCaller.cnfunfact().getUrl()).isNotEmpty();
    }

}