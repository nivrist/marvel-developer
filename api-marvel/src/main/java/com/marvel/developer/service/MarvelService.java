package com.marvel.developer.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.marvel.developer.client.MarvelClient;
import com.marvel.developer.dto.Characters;
import com.marvel.developer.dto.CharactersObj;
import com.marvel.developer.dto.CharactersSeries;
import com.marvel.developer.dto.Data;
import com.marvel.developer.dto.Items;
import com.marvel.developer.dto.ResultSeries;
import com.marvel.developer.dto.Series;
import com.marvel.developer.dto.SpecificCharacter;

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

	public CharactersObj title(String title) {
		String series = marvelClient.getCharacterBySeries(ts, apiKey, hash, title);
		ObjectMapper mapper = new ObjectMapper();
		CharactersObj chl =  new CharactersObj();
		Series serie = new Series();	
		List<CharactersSeries> chlist = new ArrayList<CharactersSeries>();
		try {
			serie = mapper.readValue(series, Series.class);
			chl.setCode(serie.getCode());
			chl.setStatus(serie.getStatus());
			
			for (ResultSeries rs : serie.getData().getResults()) {
				List<Data> listCharacter = new ArrayList<>();
				CharactersSeries obj = new CharactersSeries();
				obj.setTitle(rs.getTitleSerie());
				obj.setDescription(rs.getDesciptionSerie());
				for (Items it : rs.getCharcater().getItems()) {
					String characterJson = marvelClient.getCharacterById(ts,apiKey,hash, it.getResourceUri().substring(47));
					Characters character =  new Characters();
					character = getCharacters(characterJson);
					listCharacter.add(character.getData());
				 }
				obj.setCharcaters(listCharacter);
				chlist.add(obj);
			}
			
			chl.setCharcaters(chlist);
			
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return chl;

	}
	
	public SpecificCharacter specificCharacter(String name) {
		String characters = marvelClient.getCharacterByName(ts, apiKey, hash, name);
		SpecificCharacter spc =  new SpecificCharacter();
		Characters character = getCharacters(characters);
		spc.setCode(character.getCode());
		spc.setStatus(character.getStatus());
		spc.setDescription(character.getData().getResults().get(0).getDescription());
		spc.setId(character.getData().getResults().get(0).getId());
		spc.setImage(character.getData().getResults().get(0).getThumbnail().getPath()+"."+character.getData().getResults().get(0).getThumbnail().getExtension());
		spc.setName(character.getData().getResults().get(0).getName());
		return spc;
	}

}
