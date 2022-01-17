/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marvel.developer.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 *
 * @author irvin_monterroza
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CharcatersP implements  Serializable{
    @JsonProperty("title")
    private String title;
    @JsonProperty("description")
    private String description;
    @JsonProperty("charcaters")
    private List<Charactersresults> chresult;
    
    
}
