package com.akhm.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class JwtRequest implements Serializable {

	private String useName;
	private String password;
}
