package com.marvel.developer.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@FeignClient(contextId = "MarvelApiCreators",url="https://gateway.marvel.com:443/v1/public/", name="Api")
public interface MarvelClient {
	
	@GetMapping(path = "/creators?apikey={apikey}&ts={ts}&hash={hash}&firstName={firstName}", consumes = "application/json", produces = "application/json")
	String getCreatorByName(@PathVariable String ts , @PathVariable String apikey , @PathVariable String hash , @PathVariable String firstName );
	
	
	@GetMapping(path = "/creators/{id}/comics?apikey={apikey}&ts={ts}&hash={hash}", consumes = "application/json", produces = "application/json")
	String getComicsByCreatorId(@PathVariable String ts , @PathVariable String apikey , @PathVariable String hash , @PathVariable int id );
	
		
	
	
}
