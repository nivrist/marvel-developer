package com.marvel.developer.dto;

import java.io.Serializable;
import java.util.List;

public class CharactersSeries implements Serializable {

	private static final long serialVersionUID = 1L;
	private String title;
	private String description;
	private List<Data> charcaters;

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

	public List<Data> getCharcaters() {
		return charcaters;
	}

	public void setCharcaters(List<Data> charcaters) {
		this.charcaters = charcaters;
	}

}
