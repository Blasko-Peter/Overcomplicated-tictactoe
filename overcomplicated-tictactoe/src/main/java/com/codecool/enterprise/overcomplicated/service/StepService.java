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
    private int stepCounter = 0;

    public void addStep(int number, char player){
        char [] charArray = this.machineStep.getGame().toCharArray();
        charArray[number] = player;
        String string = new String(charArray);
        this.machineStep.setGame(string);
        stepCounter++;
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

    public String checkWinner(){
        String isWinner = "";
        char [] charArray = this.machineStep.getGame().toCharArray();
        if(charArray[0] == 'X' && charArray[1] == 'X' && charArray[2] == 'X'){
            isWinner = "Player is the winner!!!";
        } else if(charArray[3] == 'X' && charArray[4] == 'X' && charArray[5] == 'X'){
            isWinner = "Player is the winner!!!";
        } else if(charArray[6] == 'X' && charArray[7] == 'X' && charArray[8] == 'X') {
            isWinner = "Player is the winner!!!";
        } else if(charArray[0] == 'X' && charArray[3] == 'X' && charArray[6] == 'X') {
            isWinner = "Player is the winner!!!";
        } else if(charArray[1] == 'X' && charArray[4] == 'X' && charArray[7] == 'X') {
            isWinner = "Player is the winner!!!";
        } else if(charArray[2] == 'X' && charArray[5] == 'X' && charArray[8] == 'X') {
            isWinner = "Player is the winner!!!";
        } else if(charArray[0] == 'X' && charArray[4] == 'X' && charArray[8] == 'X') {
            isWinner = "Machine is the winner!!!";
        } else if(charArray[2] == 'X' && charArray[4] == 'X' && charArray[6] == 'X') {
            isWinner = "Machine is the winner!!!";
        } else if(charArray[0] == 'O' && charArray[1] == 'O' && charArray[2] == 'O'){
            isWinner = "Machine is the winner!!!";
        } else if(charArray[3] == 'O' && charArray[4] == 'O' && charArray[5] == 'O'){
            isWinner = "Machine is the winner!!!";
        } else if(charArray[6] == 'O' && charArray[7] == 'O' && charArray[8] == 'O') {
            isWinner = "Machine is the winner!!!";
        } else if(charArray[0] == 'O' && charArray[3] == 'O' && charArray[6] == 'O') {
            isWinner = "Machine is the winner!!!";
        } else if(charArray[1] == 'O' && charArray[4] == 'O' && charArray[7] == 'O') {
            isWinner = "Machine is the winner!!!";
        } else if(charArray[2] == 'O' && charArray[5] == 'O' && charArray[8] == 'O') {
            isWinner = "Machine is the winner!!!";
        } else if(charArray[0] == 'O' && charArray[4] == 'O' && charArray[8] == 'O') {
            isWinner = "Machine is the winner!!!";
        } else if(charArray[2] == 'O' && charArray[4] == 'O' && charArray[6] == 'O') {
            isWinner = "Machine is the winner!!!";
        } else if(stepCounter == 9){
            isWinner = "This game is draw!";
        }
        return isWinner;
    }

    public void newGame(){
        this.stepCounter = 0;
        this.machineStep = new MachineStepModel();
    }

}
