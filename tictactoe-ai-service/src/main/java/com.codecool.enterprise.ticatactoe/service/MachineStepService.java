package com.codecool.enterprise.ticatactoe.service;

import com.codecool.enterprise.ticatactoe.model.MachineStepModel;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MachineStepService {

    private String baseurl1 = "http://tttapi.herokuapp.com/api/v1/";
    private String baseurl2 = "http://localhost:8081/game-move-player";

    public MachineStepModel getMachineStep() {
        CloseableHttpClient httpClient = HttpClients.custom()
                .setSSLHostnameVerifier(new NoopHostnameVerifier())
                .build();
        HttpComponentsClientHttpRequestFactory requestFactory;
        requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setHttpClient(httpClient);
        RestTemplate restTemplate = new RestTemplate(requestFactory);

        MachineStepModel body1 = restTemplate.getForObject(this.baseurl2, MachineStepModel.class);

        MachineStepModel body2 = restTemplate.getForObject(this.baseurl1 + body1.getGame() + "/O", MachineStepModel.class);

        return body2;
    }

}
