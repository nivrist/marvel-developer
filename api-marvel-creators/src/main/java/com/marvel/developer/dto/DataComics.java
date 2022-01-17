package com.marvel.developer.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class DataComics implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty("results")
	private List<ResultsComics> results;
	public List<ResultsComics> getResults() {
		return results;
	}
	public void setResults(List<ResultsComics> results) {
		this.results = results;
	}
	
}
