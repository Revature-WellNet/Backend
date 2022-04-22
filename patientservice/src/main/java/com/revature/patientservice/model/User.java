package com.revature.patientservice.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

import com.revature.patientservice.model.Role;

import lombok.Data;

@Data
public class User {

	private String userId;
	private String firstname;
	private String lastname;
	private String email;
	private Role role;
}
