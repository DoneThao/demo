package com.example.elearningdemoservice.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
public class JwtRequest implements Serializable {

	private static final long serialVersionUID = 5926468583005150707L;
	
	private String username;
	private String password;
	private String email;
	private Set<String> role;

	public JwtRequest() {
	}
}