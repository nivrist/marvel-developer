package com.marvel.developer.utils;

import java.util.Base64;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class Utils {

	Logger logger = LoggerFactory.getLogger(Utils.class);


	public String getValuesByToken(String token , String key) {
		byte[] decodedBytes = Base64.getDecoder().decode(token);
		String decodedString = new String(decodedBytes);
		String sub = "";
		try {
			JSONObject obj = new JSONObject(decodedString);
			sub = obj.getString(key);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return sub;
	}

	
}
