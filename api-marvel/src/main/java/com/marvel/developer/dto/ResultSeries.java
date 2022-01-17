package com.marvel.developer.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultSeries implements Serializable{
	private static final long serialVersionUID = 1L;
	@JsonProperty("id")
	private int idSerie;
	@JsonProperty("title")
	private String titleSerie;
	@JsonProperty("description")
	private String desciptionSerie;
	@JsonProperty("resourceURI")
	private String resourceUri;
	@JsonProperty("characters")
	private CharactersSerie charcater;
	public int getIdSerie() {
		return idSerie;
	}
	public void setIdSerie(int idSerie) {
		this.idSerie = idSerie;
	}
	public String getTitleSerie() {
		return titleSerie;
	}
	public void setTitleSerie(String titleSerie) {
		this.titleSerie = titleSerie;
	}
	public String getDesciptionSerie() {
		return desciptionSerie;
	}
	public void setDesciptionSerie(String desciptionSerie) {
		this.desciptionSerie = desciptionSerie;
	}
	public String getResourceUri() {
		return resourceUri;
	}
	public void setResourceUri(String resourceUri) {
		this.resourceUri = resourceUri;
	}
	public CharactersSerie getCharcater() {
		return charcater;
	}
	public void setCharcater(CharactersSerie charcater) {
		this.charcater = charcater;
	}
	
}
