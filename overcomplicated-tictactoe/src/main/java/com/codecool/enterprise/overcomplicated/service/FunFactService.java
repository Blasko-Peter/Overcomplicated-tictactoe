package com.codecool.enterprise.overcomplicated.service;


import com.codecool.enterprise.overcomplicated.model.FunFact;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;

@Service
@Slf4j
public class FunFactService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${funfact.url}")
    private String baseUrl;

    public String addCNFunFact() {
        FunFact body = restTemplate.getForEntity(baseUrl, FunFact.class).getBody();
        return body.getValue();
    }

}
