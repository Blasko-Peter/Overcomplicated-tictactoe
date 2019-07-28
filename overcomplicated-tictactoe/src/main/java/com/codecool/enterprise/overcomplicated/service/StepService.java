package com.codecool.enterprise.overcomplicated.service;

import com.codecool.enterprise.overcomplicated.model.MachineStepModel;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class StepService {

    private MachineStepModel machineStep = new MachineStepModel();
    private List<String> steps;

    public void addStep(int number, char player){
        char [] charArray = this.machineStep.getGame().toCharArray();
        charArray[number] = player;
        String string = new String(charArray);
        this.machineStep.setGame(string);
    }

    public MachineStepModel addPlayerActualStep(){
        return this.machineStep;
    }

    public MachineStepModel addMachineStep(){
        CloseableHttpClient httpClient = HttpClients.custom()
                .setSSLHostnameVerifier(new NoopHostnameVerifier())
                .build();
        HttpComponentsClientHttpRequestFactory requestFactory;
        requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setHttpClient(httpClient);
        RestTemplate restTemplate = new RestTemplate(requestFactory);

        MachineStepModel body = restTemplate.getForObject("http://localhost:8094", MachineStepModel.class);
        addStep(body.getRecommendation(), 'O');
        return body;
    }

    public List<String> getStepVisual() {
        steps = new ArrayList<>();
        char [] charArray = this.machineStep.getGame().toCharArray();
        for(int i = 0; i < charArray.length; i++){
            if(charArray[i]=='O'){
                steps.add("fa-circle-o");
            } else if(charArray[i]=='X'){
                steps.add("fa-times");
            } else {
                steps.add("");
            }
        }
        return steps;
    }
}
