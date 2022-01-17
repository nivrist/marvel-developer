/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marvel.developer.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.marvel.developer.dto.Authenticate;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 *
 * @author irvin_monterroza
 */
public class main {

    public static void main(String[] arg) {
        try {
            Client client = Client.create();
            WebResource webResource = client.resource("http://localhost:9000");

            String input = "{\"username\":\"LOKI\",\n" +
"    \"password\":\"M4RV3L\"}";

            // POST method
            ClientResponse response = webResource.path("/api/authenticate").accept("application/json").type("application/json").post(ClientResponse.class, input);
            

            // check response status code
            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "+ response.getStatus());
            }

            // display response
            String output = response.getEntity(String.class);
           
            
            ObjectMapper mapper = new ObjectMapper();
            Authenticate auth = mapper.readValue(output, Authenticate.class);
            ClientResponse Comics = webResource.path("/marvel-comics/AllComics").header("Authorization", "Bearer  "+auth.getBarear()).accept("application/json").type("application/json").get(ClientResponse.class);
            String allComics = Comics.getEntity(String.class);
            System.out.println(allComics + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
