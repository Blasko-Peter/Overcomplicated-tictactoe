package com.codecool.enterprise.avatar.service;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class AvatarServiceTest {

    @Autowired
    private AvatarService avatarService;

    @RepeatedTest(50)
    void getNewPlayer() {
        assertThat(Integer.parseInt(avatarService.getNewPlayer().getUserName())).isBetween(1,100);
    }
}