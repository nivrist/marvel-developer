package com.marvel.developer.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.marvel.developer.dto.Characters;
import com.marvel.developer.dto.CharactersObj;
import com.marvel.developer.dto.CharactersSeries;
import com.marvel.developer.dto.Series;
import com.marvel.developer.dto.SpecificCharacter;
import com.marvel.developer.service.MarvelService;



@RestController
@CrossOrigin()
@RequestMapping("/marvel-characters")
public class MarvelController {
	
	Logger logger = LoggerFactory.getLogger(MarvelController.class);
	
	@Autowired
	MarvelService marvelService;

	
	@GetMapping(path ="/byName" ,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?>  byName(@RequestParam String name){			
		Characters  obj = marvelService.characters(name);		
		return ResponseEntity.status(obj.getCode()).body(obj);
	}
	
	
	@GetMapping(path ="/byComic" ,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?>  byComics(@RequestParam String title){			
		CharactersObj series = marvelService.title(title);
		return ResponseEntity.status(series.getCode()).body(series);
	}
	
	
	@GetMapping(path ="/specificChcracter" ,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?>  characterName(@RequestParam String name){			
		SpecificCharacter series = marvelService.specificCharacter(name);
		return ResponseEntity.status(series.getCode()).body(series);
	}
	
	
	
	
}
