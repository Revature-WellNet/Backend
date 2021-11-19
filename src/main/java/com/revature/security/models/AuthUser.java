package com.revature.security.models;

import java.io.Serializable;

import lombok.Data;

@Data
public class AuthUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4408418647685225829L;
	String uid;
	String name;
	String email;
	boolean isEmailVerified;
	String issuer;
	String picture;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isEmailVerified() {
		return isEmailVerified;
	}
	public void setEmailVerified(boolean isEmailVerified) {
		this.isEmailVerified = isEmailVerified;
	}
	public String getIssuer() {
		return issuer;
	}
	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
