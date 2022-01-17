package com.marvel.developer.dto;

import java.util.List;

public class CharactersObj {
	private int code;
	private String status;
	private List<CharactersSeries> charcaters;
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
	public List<CharactersSeries> getCharcaters() {
		return charcaters;
	}
	public void setCharcaters(List<CharactersSeries> charcaters) {
		this.charcaters = charcaters;
	}
	

}
