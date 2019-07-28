package com.codecool.enterprise.overcomplicated.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ComicsModel {

    private int month;
    private int num;
    private String link;
    private int year;
    private String news;
    private String safe_title;
    private String transcript;
    private String alt;
    private String img;
    private String title;
    private int day;

}
