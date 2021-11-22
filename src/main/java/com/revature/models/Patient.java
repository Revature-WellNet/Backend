package com.revature.models;

import javax.persistence.*;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.sql.Date;
import java.util.List;

@Entity
@Component
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int patientId;
    private String firstName;
    private String lastName;
    private Date dob;
    private double height;
    private double weight;
    @ManyToOne
    @JoinColumn(name = "type_id")
    private BloodType bloodType;
    @ManyToOne
    @JoinColumn(name = "sex_id")
    private Sex sex;
    
    @ManyToMany
    @JoinTable(
            name = "patient_allergies",
            joinColumns = @JoinColumn(name = "patient_id"),
            inverseJoinColumns = @JoinColumn(name = "allergy_id")
    )
    @JsonIgnoreProperties("patients")
    private List<Allergy> patientAllergies;
    
    @ManyToMany
    @JoinTable(
            name = "patient_vaccinations",
            joinColumns = @JoinColumn(name = "patient_id"),
            inverseJoinColumns = @JoinColumn(name = "vaccination_id")
    )
    @JsonIgnoreProperties("patients")
    private List<Vaccination> patientVaccinations;
    
	@JsonIgnoreProperties("patient")
	@OneToMany(mappedBy="patient", fetch=FetchType.LAZY)
    private List<DiagnosisForm> diagnosisForms;

	public Patient(int patientId, String firstName, String lastName, Date dob, double height, double weight,
			BloodType bloodType, Sex sex, List<Allergy> patientAllergies, List<Vaccination> patientVaccinations,
			List<DiagnosisForm> diagnosisForms) {
		super();
		this.patientId = patientId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.height = height;
		this.weight = weight;
		this.bloodType = bloodType;
		this.sex = sex;
		this.patientAllergies = patientAllergies;
		this.patientVaccinations = patientVaccinations;
		this.diagnosisForms = diagnosisForms;
	}

	public Patient(String firstName, String lastName, Date dob, double height, double weight, BloodType bloodType,
			Sex sex, List<Allergy> patientAllergies, List<Vaccination> patientVaccinations,
			List<DiagnosisForm> diagnosisForms) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.height = height;
		this.weight = weight;
		this.bloodType = bloodType;
		this.sex = sex;
		this.patientAllergies = patientAllergies;
		this.patientVaccinations = patientVaccinations;
		this.diagnosisForms = diagnosisForms;
	}

	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public BloodType getBloodType() {
		return bloodType;
	}

	public void setBloodType(BloodType bloodType) {
		this.bloodType = bloodType;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public List<Allergy> getPatientAllergies() {
		return patientAllergies;
	}

	public void setPatientAllergies(List<Allergy> patientAllergies) {
		this.patientAllergies = patientAllergies;
	}

	public List<Vaccination> getPatientVaccinations() {
		return patientVaccinations;
	}

	public void setPatientVaccinations(List<Vaccination> patientVaccinations) {
		this.patientVaccinations = patientVaccinations;
	}

	public List<DiagnosisForm> getDiagnosisForms() {
		return diagnosisForms;
	}

	public void setDiagnosisForms(List<DiagnosisForm> diagnosisForms) {
		this.diagnosisForms = diagnosisForms;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bloodType == null) ? 0 : bloodType.hashCode());
		result = prime * result + ((diagnosisForms == null) ? 0 : diagnosisForms.hashCode());
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(height);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((patientAllergies == null) ? 0 : patientAllergies.hashCode());
		result = prime * result + patientId;
		result = prime * result + ((patientVaccinations == null) ? 0 : patientVaccinations.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		temp = Double.doubleToLongBits(weight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Patient other = (Patient) obj;
		if (bloodType == null) {
			if (other.bloodType != null)
				return false;
		} else if (!bloodType.equals(other.bloodType))
			return false;
		if (diagnosisForms == null) {
			if (other.diagnosisForms != null)
				return false;
		} else if (!diagnosisForms.equals(other.diagnosisForms))
			return false;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (Double.doubleToLongBits(height) != Double.doubleToLongBits(other.height))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (patientAllergies == null) {
			if (other.patientAllergies != null)
				return false;
		} else if (!patientAllergies.equals(other.patientAllergies))
			return false;
		if (patientId != other.patientId)
			return false;
		if (patientVaccinations == null) {
			if (other.patientVaccinations != null)
				return false;
		} else if (!patientVaccinations.equals(other.patientVaccinations))
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", firstName=" + firstName + ", lastName=" + lastName + ", dob="
				+ dob + ", height=" + height + ", weight=" + weight + ", bloodType=" + bloodType + ", sex=" + sex
				+ "]";
	}

	
	
}
