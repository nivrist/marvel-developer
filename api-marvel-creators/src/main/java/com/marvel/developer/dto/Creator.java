package com.marvel.developer.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Creator implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty("data")
    private Data data;
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}
}
