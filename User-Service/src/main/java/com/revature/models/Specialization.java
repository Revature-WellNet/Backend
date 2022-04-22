package com.revature.models;

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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((specialization == null) ? 0 : specialization.hashCode());
		result = prime * result + specialization_Id;
		return result;

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
		if (specialization == null) {
			if (other.specialization != null)
				return false;
		} else if (!specialization.equals(other.specialization))
			return false;
		if (specialization_Id != other.specialization_Id)
			return false;
		return true;
	}
	
	public Specialization(String specialization) {
		super();
		this.specialization = specialization;
	}

	public Specialization(int specialization_Id, String specialization) {
		super();
		this.specialization_Id = specialization_Id;
		this.specialization = specialization;
	}
	
	public Specialization() {
		super();
	}
	
	@Override
	public String toString() {
		return "Specialization [specialization_Id=" + specialization_Id + ", specialization=" + specialization + "]";
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

	
	
}
