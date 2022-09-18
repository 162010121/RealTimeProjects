package com.akhm.model;

import java.io.Serializable;

public class JwtResponce  implements Serializable{

	private final String jwtToken;

	public JwtResponce(String jwtToken) {
		super();
		this.jwtToken = jwtToken;
	}

	public String getJwtToken() {
		return jwtToken;
	} 
	
	
}
