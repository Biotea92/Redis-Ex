package com.example.RedisCasching.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserProfile {

    @JsonProperty
    private String name;

    @JsonProperty
    private int age;


}
