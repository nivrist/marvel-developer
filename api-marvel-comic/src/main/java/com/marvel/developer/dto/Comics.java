package com.marvel.developer.dto;

import java.io.Serializable;

public class Comics implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int code;
	private String status;
	private PrincipalComics comics;
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
	public PrincipalComics getComics() {
		return comics;
	}
	public void setComics(PrincipalComics comics) {
		this.comics = comics;
	}

}
