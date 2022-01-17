/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marvel.developer.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author irvin_monterroza
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Comics implements  Serializable{
    @JsonProperty("characterId")  
    private int characterId;
    @JsonProperty("characterName")
    private String characterName;
    @JsonProperty("characterImage")
    private String image;
    @JsonProperty("data")
    private DataComics comicsData;
    
}
