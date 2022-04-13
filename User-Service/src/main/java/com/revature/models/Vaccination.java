package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
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
public class Vaccination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vaccinationId;
    @Column(unique = true)
    private String vaccination;
    
    @ManyToMany(mappedBy = "patientVaccinations")
    @JsonIgnoreProperties("patientVaccinations")
    List<Patient> patients;

	public Vaccination(int vaccinationId, String vaccination, List<Patient> patients) {
		super();
		this.vaccinationId = vaccinationId;
		this.vaccination = vaccination;
		this.patients = patients;
	}

	public Vaccination(String vaccination, List<Patient> patients) {
		super();
		this.vaccination = vaccination;
		this.patients = patients;
	}

	public Vaccination() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getVaccinationId() {
		return vaccinationId;
	}

	public void setVaccinationId(int vaccinationId) {
		this.vaccinationId = vaccinationId;
	}

	public String getVaccination() {
		return vaccination;
	}

	public void setVaccination(String vaccination) {
		this.vaccination = vaccination;
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
		result = prime * result + ((patients == null) ? 0 : patients.hashCode());
		result = prime * result + ((vaccination == null) ? 0 : vaccination.hashCode());
		result = prime * result + vaccinationId;
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
		Vaccination other = (Vaccination) obj;
		if (patients == null) {
			if (other.patients != null)
				return false;
		} else if (!patients.equals(other.patients))
			return false;
		if (vaccination == null) {
			if (other.vaccination != null)
				return false;
		} else if (!vaccination.equals(other.vaccination))
			return false;
		if (vaccinationId != other.vaccinationId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vaccination [vaccinationId=" + vaccinationId + ", vaccination=" + vaccination + "]";
	}

    
    
    
}
