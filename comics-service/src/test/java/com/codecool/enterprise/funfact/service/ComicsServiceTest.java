package com.codecool.enterprise.funfact.service;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ComicsServiceTest {

    @Autowired
    private ComicsService comicsService;

    @RepeatedTest(50)
    void generateRandomComicUrl(){
        String[] str = comicsService.generateRandomComicUrl().split("/");
        assertThat(Integer.parseInt(str[3])).isBetween(1,1929);
    }

}