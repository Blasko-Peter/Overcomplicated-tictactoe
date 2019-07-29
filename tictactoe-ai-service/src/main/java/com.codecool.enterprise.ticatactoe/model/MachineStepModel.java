package com.codecool.enterprise.ticatactoe.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MachineStepModel {

    private String game = "---------";
    private String player;
    private int recommendation;
    private int strength;

}
