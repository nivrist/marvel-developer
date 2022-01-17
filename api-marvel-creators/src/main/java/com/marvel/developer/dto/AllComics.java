package com.marvel.developer.dto;

import java.io.Serializable;

public class AllComics implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int code;
	private String status;
	private String creatorName;
	private String imageCreator;
	private DataComics comics;
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
	public String getCreatorName() {
		return creatorName;
	}
	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}
	public String getImageCreator() {
		return imageCreator;
	}
	public void setImageCreator(String imageCreator) {
		this.imageCreator = imageCreator;
	}
	public DataComics getComics() {
		return comics;
	}
	public void setComics(DataComics comics) {
		this.comics = comics;
	}
	
	
}
