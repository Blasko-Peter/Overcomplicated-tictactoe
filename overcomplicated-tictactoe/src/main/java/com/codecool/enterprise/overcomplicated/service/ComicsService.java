package com.codecool.enterprise.overcomplicated.service;

import com.codecool.enterprise.overcomplicated.model.ComicsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ComicsService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${comicsservice.url}")
    private String baseUrl;

    public String addComic() {
        ComicsModel body = restTemplate.getForEntity(baseUrl, ComicsModel.class).getBody();
        return body.getImg();
    }

}
