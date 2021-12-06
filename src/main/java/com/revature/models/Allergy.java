package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.Objects;

@Entity
@Component
public class Allergy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int allergyId;
    @Column(unique = true)
    private String allergy;
    
    @ManyToMany(mappedBy = "patientAllergies")
    @JsonIgnoreProperties("patientAllergies")
    List<Patient> patients;

	public Allergy(int allergyId, String allergy, List<Patient> patients) {
		super();
		this.allergyId = allergyId;
		this.allergy = allergy;
		this.patients = patients;
	}

	public Allergy(String allergy, List<Patient> patients) {
		super();
		this.allergy = allergy;
		this.patients = patients;
	}

	public Allergy() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getAllergyId() {
		return allergyId;
	}

	public void setAllergyId(int allergyId) {
		this.allergyId = allergyId;
	}

	public String getAllergy() {
		return allergy;
	}

	public void setAllergy(String allergy) {
		this.allergy = allergy;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((allergy == null) ? 0 : allergy.hashCode());
		result = prime * result + allergyId;
		result = prime * result + ((patients == null) ? 0 : patients.hashCode());
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
		Allergy other = (Allergy) obj;
		if (allergy == null) {
			if (other.allergy != null)
				return false;
		} else if (!allergy.equals(other.allergy))
			return false;
		if (allergyId != other.allergyId)
			return false;
		if (patients == null) {
			if (other.patients != null)
				return false;
		} else if (!patients.equals(other.patients))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Allergy [allergyId=" + allergyId + ", allergy=" + allergy + "]";
	}
    
    

}
