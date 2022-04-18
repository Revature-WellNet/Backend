package com.revature.models;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Specialization {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int specialization_Id;
	
	private String specialization;

	public Specialization(int specialization_Id, String specialization) {
		super();
		this.specialization_Id = specialization_Id;
		this.specialization = specialization;
	}

	public Specialization() {
		super();
	}

	public int getSpecId() {
		return specialization_Id;
	}

	public void setSpecId(int specialization_Id) {
		this.specialization_Id = specialization_Id;
	}

	public String getSpec() {
		return specialization;
	}

	public void setSpec(String specialization) {
		this.specialization = specialization;
	}

	@Override
	public String toString() {
		return "Specialization [specialization_Id=" + specialization_Id + ", specialization=" + specialization + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(specialization, specialization_Id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Specialization other = (Specialization) obj;
		return specialization == other.specialization && specialization_Id == other.specialization_Id;
	}
	
	
}
