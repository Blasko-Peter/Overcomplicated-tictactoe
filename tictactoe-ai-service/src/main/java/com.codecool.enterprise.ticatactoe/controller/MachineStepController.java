package com.codecool.enterprise.ticatactoe.controller;

import com.codecool.enterprise.ticatactoe.model.MachineStepModel;
import com.codecool.enterprise.ticatactoe.service.MachineStepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MachineStepController {

    @Autowired
    private MachineStepService machineStepService;

    @GetMapping("/")
    public MachineStepModel machinStep(){
        return machineStepService.getMachineStep();
    }

}
