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

import com.marvel.developer.dto.AllComics;
import com.marvel.developer.dto.CreatorComics;
import com.marvel.developer.service.MarvelService;



@RestController
@CrossOrigin()
@RequestMapping("/marvel-creators")
public class MarvelController {
	
	Logger logger = LoggerFactory.getLogger(MarvelController.class);
	
	@Autowired
	MarvelService marvelService;

	
	@GetMapping(path ="/comicsByCreator" ,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?>  byName(@RequestParam String name){			
		AllComics  obj = marvelService.comicsByCreatorId(name);	
		return ResponseEntity.status(obj.getCode()).body(obj);
	}
	
	
	
	
	
	
}
