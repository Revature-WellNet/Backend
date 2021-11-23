package com.revature.security.models;

public class TokenHolder {
	
	private String token;
	private String role;
	public TokenHolder(String token, String role) {
		super();
		this.token = token;
		this.role = role;
	}
	
	
	public TokenHolder() {
		super();
	}


	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	

}
