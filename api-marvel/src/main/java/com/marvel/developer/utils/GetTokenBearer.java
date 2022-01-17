package com.marvel.developer.utils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;



public class GetTokenBearer {

	
	
	public static void main(String arg[])  {
		long t = new Date().getTime();
		System.out.println("Tiempo Actual:"+ t);// agregar 3 ceros a la derecha
		String jwtExpirationInMs="1631300233";// como lo regresa el servicio
		String jwtExpirationInMsValidar="1631300233000"; // agregar 3 ceros a la derecha
		String convertTimeNow = "1631303302000";//String.valueOf(t);
		Date expirationTimeNow = new Date(Long.parseLong(convertTimeNow));
		Date expirationTime = new Date(Long.parseLong(jwtExpirationInMs));
	    Date expirationTimeValidar = new Date(Long.parseLong(jwtExpirationInMsValidar)); 	  
	    System.out.println("Expira :"+ expirationTime); //como lo regresa el servicio
	    System.out.println("Expira Validar:"+ expirationTimeValidar);// agregar 3 ceros a la derecha
	    System.out.println("expirationTimeNow:"+ expirationTimeNow);// agregar 3 ceros a la derecha
	    
	  
		
		

	}
}
