package com.revature.models;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

@Entity
@Component
public class User {

	@Id
	private String userId;
	private String firstname;
	private String lastname;
	private String email;
	private boolean isDoctor;
	
	public String getId() {
		return userId;
	}
	public void setId(String id) {
		this.userId = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isDoctor() {
		return isDoctor;
	}
	public void setDoctor(boolean isDoctor) {
		this.isDoctor = isDoctor;
	}
	@Override
	public String toString() {
		return "User [id=" + userId + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email + ", isDoctor="
				+ isDoctor + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, firstname, isDoctor, lastname, userId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email) && Objects.equals(firstname, other.firstname)
				&& isDoctor == other.isDoctor && Objects.equals(lastname, other.lastname)
				&& Objects.equals(userId, other.userId);
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(String userId, String firstname, String lastname, String email, boolean isDoctor) {
		super();
		this.userId = userId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.isDoctor = isDoctor;
	}

	
}
