/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marvel.developer.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.marvel.developer.dto.Charcaters;
import com.marvel.developer.dto.DetailCharacter;
import com.marvel.developer.dto.PrincipalCharcater;
import com.marvel.developer.dto.PrincipalComics;
import com.marvel.developer.utils.Utils;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.session.SessionRegistry;

/**
 *
 * @author irvin_monterroza
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Named(value = "loginSecurity")
@SessionScoped
public class LoginSecurity extends Utils implements Serializable {

    /**
     * Creates a new instance of LoginSecurity
     */
    private String formUser;
    private String formPassword;

    private String comicName;
    public LoginSecurity() {
    }

    public String ingresar() {

        try {

            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            HttpServletRequest request = (HttpServletRequest) context.getRequest();
            HttpServletResponse response = (HttpServletResponse) context.getResponse();
            RequestDispatcher dispatcher = request.getRequestDispatcher("/j_spring_security_check");
            dispatcher.forward(request, response);
            FacesContext.getCurrentInstance().responseComplete();

        } catch (IOException | ServletException e) {

        }
        return null;
    }
    private SessionRegistry sessionRegistry;

    public void logOut() {
        try {

            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            HttpServletRequest request = (HttpServletRequest) context.getRequest();
            HttpServletResponse response = (HttpServletResponse) context.getResponse();
            RequestDispatcher dispatcher = request.getRequestDispatcher("/logout");
            dispatcher.forward(request, response);
            FacesContext.getCurrentInstance().responseComplete();

        } catch (ServletException | IOException ex) {
        }

    }

    private String nameCharacter;
    
    
    private String name;
    private String image;
    private PrincipalCharcater character;
    public void buscarPersonaje() {
        try {
            String charcater = requestJson("/marvel-characters/byName", "name", nameCharacter);
            ObjectMapper mapper = new ObjectMapper();
            PrincipalCharcater auth = mapper.readValue(charcater, PrincipalCharcater.class);
           
            image =auth.getData().getResults().get(0).getThumbnail().getPath()+"."+auth.getData().getResults().get(0).getThumbnail().getExtension();
        } catch (JsonProcessingException ex) {
            image="http://i.annihil.us/u/prod/marvel/i/mg/b/40/image_not_available.jpg";
            ex.printStackTrace();

        }
        
    }
    private String nameDetailCha;
    private DetailCharacter detailCharacter;
    public void detailCharcater(){
    try {
            String charcater = requestJson("/marvel-characters/specificChcracter", "name", nameDetailCha);
            ObjectMapper mapper = new ObjectMapper();
            detailCharacter = mapper.readValue(charcater, DetailCharacter.class);         
            
        } catch (JsonProcessingException ex) {
            image="http://i.annihil.us/u/prod/marvel/i/mg/b/40/image_not_available.jpg";
            ex.printStackTrace();

        }
    }
    
    private Charcaters charcatersBySerie;
    private String jsonFormart;
    public void findCharcatersByComics(){
    try {
            String charcater = requestJson("/marvel-characters/byComic", "title", comicName);
            ObjectMapper mapper = new ObjectMapper();
            Charcaters auth = mapper.readValue(charcater, Charcaters.class);
            jsonFormart = charcater;
            charcatersBySerie = auth;            
        } catch (JsonProcessingException ex) {
            image="http://i.annihil.us/u/prod/marvel/i/mg/b/40/image_not_available.jpg";
            ex.printStackTrace();

        }
    
    }
    
    private String charcater2;
    private PrincipalComics principalComics;
    public void comicsByCharcater(){
     try {
            String charcater = requestJson("/marvel-comics/ComicsByCharacter", "name", charcater2);
            ObjectMapper mapper = new ObjectMapper();
            principalComics = mapper.readValue(charcater, PrincipalComics.class);           ;
                      
        } catch (JsonProcessingException ex) {
            image="http://i.annihil.us/u/prod/marvel/i/mg/b/40/image_not_available.jpg";
            ex.printStackTrace();

        }
    
    }

}
