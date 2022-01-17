package com.marvel.developer.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreatorComics implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@JsonProperty("status")
	private String status;
	@JsonProperty("code")
	private int code;
	@JsonProperty("data")
	private DataComics data;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public DataComics getData() {
		return data;
	}
	public void setData(DataComics data) {
		this.data = data;
	}
}
