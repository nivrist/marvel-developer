package com.marvel.developer.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Series implements Serializable{

	private static final long serialVersionUID = 1L;
	@JsonProperty("code")
	private int code;
	@JsonProperty("status")
	private String status;
	@JsonProperty("data")
	private DataSeries data;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public DataSeries getData() {
		return data;
	}
	public void setData(DataSeries data) {
		this.data = data;
	}
	
	
}
