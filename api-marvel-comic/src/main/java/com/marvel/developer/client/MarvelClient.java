package com.marvel.developer.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@FeignClient(contextId = "MarvelApiComics",url="https://gateway.marvel.com:443/v1/public/", name="Api")
public interface MarvelClient {
	
	@GetMapping(path = "/characters?apikey={apikey}&ts={ts}&hash={hash}&name={name}", consumes = "application/json", produces = "application/json")
	String getCharacterByName(@PathVariable String ts , @PathVariable String apikey , @PathVariable String hash , @PathVariable String name );
	
		
	@GetMapping(path = "/characters/{id}/comics?apikey={apikey}&ts={ts}&hash={hash}", consumes = "application/json", produces = "application/json")
	String getComicsByCharcaterId(@PathVariable String ts , @PathVariable String apikey , @PathVariable String hash , @PathVariable int id );
	
	
	@GetMapping(path = "/comics?apikey={apikey}&ts={ts}&hash={hash}", consumes = "application/json", produces = "application/json")
	String getAllComics(@PathVariable String ts , @PathVariable String apikey , @PathVariable String hash);
	
	
	@GetMapping(path = "/comics/{id}?apikey={apikey}&ts={ts}&hash={hash}", consumes = "application/json", produces = "application/json")
	String getComicById(@PathVariable String ts , @PathVariable String apikey , @PathVariable String hash , @PathVariable int id);
	
	
	
	
}
