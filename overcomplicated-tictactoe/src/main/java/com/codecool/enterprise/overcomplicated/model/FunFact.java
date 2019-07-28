package com.codecool.enterprise.overcomplicated.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FunFact {

    private String category;
    private String icon_url;
    private String id;
    private String url;
    private String value;

}
