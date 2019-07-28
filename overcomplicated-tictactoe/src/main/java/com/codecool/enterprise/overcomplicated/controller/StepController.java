package com.codecool.enterprise.overcomplicated.controller;

import com.codecool.enterprise.overcomplicated.model.MachineStepModel;
import com.codecool.enterprise.overcomplicated.service.StepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StepController {

    @Autowired
    private StepService stepService;

    @GetMapping("/game-move-player")
    public MachineStepModel machineStepModel(){
        return stepService.addPlayerActualStep();
    }

}
