package com.marvel.developer.model;

import java.io.Serializable;

public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	private final String bearer;
	private final String user;
	private final String exp;
	public JwtResponse( String user,String exp,String bearer) {
		super();
		this.bearer = bearer;
		this.user = user;
		this.exp = exp;
		
	}
	public String getBearer() {
		return bearer;
	}
	public String getUser() {
		return user;
	}
	public String getExp() {
		return exp;
	}
	

		
}