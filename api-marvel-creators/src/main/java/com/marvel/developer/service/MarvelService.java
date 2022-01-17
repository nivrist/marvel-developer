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
import com.marvel.developer.dto.AllComics;
import com.marvel.developer.dto.Creator;
import com.marvel.developer.dto.CreatorComics;

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

	public Creator getCreators(String creatorJson) {
		ObjectMapper mapper = new ObjectMapper();
		Creator creator = new Creator();
		try {
			creator = mapper.readValue(creatorJson, Creator.class);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return creator;

	}

	public AllComics comicsByCreatorId(String name) {
		CreatorComics creatorComics = new CreatorComics();
		String creatorJson = marvelClient.getCreatorByName(ts, apiKey, hash, name);
		Creator creator = getCreators(creatorJson);
		String comics = marvelClient.getComicsByCreatorId(ts, apiKey, hash,creator.getData().getResults().get(0).getId());
		ObjectMapper mapper = new ObjectMapper();
		CreatorComics cComics = new CreatorComics();
		AllComics obj = new AllComics();
		try {
			cComics = mapper.readValue(comics, CreatorComics.class);			
			obj.setCode(cComics.getCode());
			obj.setStatus(cComics.getStatus());
			obj.setCreatorName(creator.getData().getResults().get(0).getFullName());
			obj.setImageCreator(creator.getData().getResults().get(0).getThumbnail().getPath() + "."+ creator.getData().getResults().get(0).getThumbnail().getExtension());
			obj.setComics(cComics.getData());
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;

	}

}
