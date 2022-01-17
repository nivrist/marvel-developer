package com.marvel.developer.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.marvel.developer.client.MarvelClient;
import com.marvel.developer.dto.Characters;
import com.marvel.developer.dto.Comics;
import com.marvel.developer.dto.ComicsAll;
import com.marvel.developer.dto.DataComics;
import com.marvel.developer.dto.PrincipalComics;

@Service
public class MarvelService {

	Logger logger = LoggerFactory.getLogger(MarvelService.class);

	@Autowired
	MarvelClient marvelClient;

	@Value("${marvel-api.ts}")
	private String ts;

	@Value("${marvel-api.key}")
	private String apiKey;

	@Value("${marvel-api-hash}")
	private String hash;

	public Characters getCharacters(String characterJson) {
		ObjectMapper mapper = new ObjectMapper();
		Characters character = new Characters();
		try {
			character = mapper.readValue(characterJson, Characters.class);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return character;

	}

	public Characters characters(String name) {
		String characters = marvelClient.getCharacterByName(ts, apiKey, hash, name);
		Characters character = getCharacters(characters);
		return character;

	}
	
	
	public ComicsAll allComics() {
		String allcomics = marvelClient.getAllComics(ts, apiKey, hash);
		
		ObjectMapper mapper = new ObjectMapper();
		ComicsAll pc = new ComicsAll();
		try {
			 pc = mapper.readValue(allcomics, ComicsAll.class);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pc;
	}
	
	
	public ComicsAll comicById(int id) {
		String allcomics = marvelClient.getComicById(ts, apiKey, hash,id);
		
		ObjectMapper mapper = new ObjectMapper();
		ComicsAll pc = new ComicsAll();
		try {
			 pc = mapper.readValue(allcomics, ComicsAll.class);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pc;
	}

	public Comics comicsByCharcater(String name) {
		String characters = marvelClient.getCharacterByName(ts, apiKey, hash, name);
		Characters character = getCharacters(characters);
		Comics comics = new Comics();
		comics.setCode(character.getCode());
		comics.setStatus(character.getStatus());
		String comicsJson = marvelClient.getComicsByCharcaterId(ts, apiKey, hash,character.getData().getResults().get(0).getId());
		System.out.println(comicsJson);
		ObjectMapper mapper = new ObjectMapper();
		try {
			PrincipalComics pc = mapper.readValue(comicsJson, PrincipalComics.class);
			pc.setCharacterId(character.getData().getResults().get(0).getId());
			pc.setCharacterImage(character.getData().getResults().get(0).getThumbnail().getPath() + "."
					+ character.getData().getResults().get(0).getThumbnail().getExtension());
			pc.setCharacterName(character.getData().getResults().get(0).getName());
			
			comics.setComics(pc);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return comics;
	}

}
