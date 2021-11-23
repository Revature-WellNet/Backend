package com.revature.security.models;

import java.io.Serializable;
import java.util.Map;


public class AuthUserDTO implements Serializable {
	private static final long serialVersionUID = 4408418647685225829L;
	String uid;
	String name;
	String email;
	boolean isEmailVerified;
	String issuer;
	String picture; //for future use, does not need to implemented
	Map role;
	
	public String getUid() {
		return uid;
	}
	public Map getRole() {
		return role;
	}
	public void setRole(Map role) {
		this.role = role;
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
	@Override
	public String toString() {
		return "AuthUserDTO [uid=" + uid + ", name=" + name + ", email=" + email + ", isEmailVerified="
				+ isEmailVerified + ", issuer=" + issuer + ", picture=" + picture + "]";
	}
	
	
}
