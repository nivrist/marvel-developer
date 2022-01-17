package com.marvel.developer.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PrincipalComics implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int characterId;
	private String characterName;
	private String characterImage;
	@JsonProperty("data")
	private DataComics data;
	public int getCharacterId() {
		return characterId;
	}
	public void setCharacterId(int characterId) {
		this.characterId = characterId;
	}
	public String getCharacterName() {
		return characterName;
	}
	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}
	public String getCharacterImage() {
		return characterImage;
	}
	public void setCharacterImage(String characterImage) {
		this.characterImage = characterImage;
	}
	public DataComics getData() {
		return data;
	}
	public void setData(DataComics data) {
		this.data = data;
	}
	

}
