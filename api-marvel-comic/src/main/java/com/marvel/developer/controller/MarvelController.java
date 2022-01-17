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
import com.marvel.developer.dto.Comics;
import com.marvel.developer.dto.ComicsAll;
import com.marvel.developer.service.MarvelService;



@RestController
@CrossOrigin()
@RequestMapping("/marvel-comics")
public class MarvelController {
	
	Logger logger = LoggerFactory.getLogger(MarvelController.class);
	
	@Autowired
	MarvelService marvelService;

	
	@GetMapping(path ="/byName" ,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?>  byName(@RequestParam String name){			
		Characters  obj = marvelService.characters(name);		
		return ResponseEntity.status(obj.getCode()).body(obj);
	}
	
	
	@GetMapping(path ="/ComicsByCharacter" ,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?>  Comics(@RequestParam String name){			
		Comics comics = marvelService.comicsByCharcater(name);
		return ResponseEntity.status(comics.getCode()).body(comics);
	}
	

	@GetMapping(path ="/AllComics" ,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?>  allComics(){			
		ComicsAll comics = marvelService.allComics();
		return ResponseEntity.status(comics.getCode()).body(comics);
	}
	
	
	@GetMapping(path ="/ComicById" ,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?>  comicById(@RequestParam int id){			
		ComicsAll comics = marvelService.comicById(id);
		return ResponseEntity.status(comics.getCode()).body(comics);
	}
	
	
	
	
}
