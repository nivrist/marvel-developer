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
	private List<ResultsComics> resultsComics;

	public List<ResultsComics> getResultsComics() {
		return resultsComics;
	}

	public void setResultsComics(List<ResultsComics> resultsComics) {
		this.resultsComics = resultsComics;
	}
}
