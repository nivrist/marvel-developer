package com.marvel.developer.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@FeignClient(contextId = "MarvelApi",url="https://gateway.marvel.com:443/v1/public/", name="Api")
public interface MarvelClient {
	
	@GetMapping(path = "/characters?apikey={apikey}&ts={ts}&hash={hash}&name={name}", consumes = "application/json", produces = "application/json")
	String getCharacterByName(@PathVariable String ts , @PathVariable String apikey , @PathVariable String hash , @PathVariable String name );
	
	
	@GetMapping(path = "/series?apikey={apikey}&ts={ts}&hash={hash}&title={title}", consumes = "application/json", produces = "application/json")
	String getCharacterBySeries(@PathVariable String ts , @PathVariable String apikey , @PathVariable String hash , @PathVariable String title );
	
	
	@GetMapping(path = "/characters/{id}?apikey={apikey}&ts={ts}&hash={hash}", consumes = "application/json", produces = "application/json")
	String getCharacterById(@PathVariable String ts , @PathVariable String apikey , @PathVariable String hash , @PathVariable String id );
	
	
	
	
}
