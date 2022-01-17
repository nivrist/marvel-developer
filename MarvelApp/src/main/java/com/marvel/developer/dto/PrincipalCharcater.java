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
public class PrincipalCharcater implements  Serializable{
    @JsonProperty("code")
    private int code;
    @JsonProperty("status")
    private String status;
    @JsonProperty("data")
    private DataCharcater data;
}
