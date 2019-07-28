package com.codecool.enterprise.overcomplicated.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Player {

    private String userName = "Anonymous";
    private String image = "https://robohash.org/set_set4/bgset_bg3/2";

}
