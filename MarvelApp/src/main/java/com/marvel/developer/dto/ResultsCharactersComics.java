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
public class ResultsCharactersComics implements  Serializable{    
    @JsonProperty("name")
    private String name;
    @JsonProperty("id")
    private int id;
    @JsonProperty("description")
    private String description;
    @JsonProperty("thumbnail")
    private Thumbnail thumbnail;
    
}
