package com.codecool.enterprise.overcomplicated.service;

import com.codecool.enterprise.overcomplicated.model.ComicsModel;
import com.codecool.enterprise.overcomplicated.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Service
public class PlayerService {

    private Player player = new Player();

    @Autowired
    private RestTemplate restTemplate;

    @Value("${avatarservice.url}")
    private String baseUrl;

    public Player getPlayer() {
        return this.player;
    }

    public void newImage(){
        Player body = restTemplate.getForEntity(baseUrl, Player.class).getBody();
        this.player.setImage(body.getImage());
    }

}
