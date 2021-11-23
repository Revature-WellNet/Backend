package com.revature.security.models;

import com.google.firebase.auth.FirebaseToken;

import lombok.AllArgsConstructor;
import lombok.Data;


public class Credentials {

	public enum CredentialType {
		ID_TOKEN, SESSION
	}

	CredentialType type;
	FirebaseToken decodedToken;
	String idToken;
	String session;
	
	public Credentials(CredentialType type, FirebaseToken decodedToken, String idToken, String session) {
		super();
		this.type = type;
		this.decodedToken = decodedToken;
		this.idToken = idToken;
		this.session = session;
	}
	public CredentialType getType() {
		return type;
	}
	public void setType(CredentialType type) {
		this.type = type;
	}
	public FirebaseToken getDecodedToken() {
		return decodedToken;
	}
	public void setDecodedToken(FirebaseToken decodedToken) {
		this.decodedToken = decodedToken;
	}
	public String getIdToken() {
		return idToken;
	}
	public void setIdToken(String idToken) {
		this.idToken = idToken;
	}
	public String getSession() {
		return session;
	}
	public void setSession(String session) {
		this.session = session;
	}
	
	
}