package com.marvel.developer.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultsComics implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty("id")
	private int id;
	@JsonProperty("digitalId")
	private int digitalId;
	@JsonProperty("title")
	private String title;
	@JsonProperty("description")
	private String description;
	@JsonProperty("thumbnail")
	private ThumbnailComics thumbnailComics;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDigitalId() {
		return digitalId;
	}
	public void setDigitalId(int digitalId) {
		this.digitalId = digitalId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ThumbnailComics getThumbnailComics() {
		return thumbnailComics;
	}
	public void setThumbnailComics(ThumbnailComics thumbnailComics) {
		this.thumbnailComics = thumbnailComics;
	}
	
	
	
}
