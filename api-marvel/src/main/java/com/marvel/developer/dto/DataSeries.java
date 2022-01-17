package com.marvel.developer.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DataSeries implements Serializable{
	private static final long serialVersionUID = 1L;
	@JsonProperty("total")
	private int total;
	@JsonProperty("results")
	private List<ResultSeries> results;
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<ResultSeries> getResults() {
		return results;
	}
	public void setResults(List<ResultSeries> results) {
		this.results = results;
	}
	
}
