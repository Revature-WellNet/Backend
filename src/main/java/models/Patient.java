package models;

import java.sql.Date;

import javax.persistence.*;

@Entity
public class Patient {
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int patientId;
	private String firstName;
	private String lastName;
	private Date dob;
	private double height;
	private double weight;
//	private BloodType bloodType;
//	private Gender gender;
//	private List<Allergy> allergies;
//	private List<Vaccination> vaccinations;
	
	public Patient() {
		super();
	}
	
	public Patient(int patientId, String firstName, String lastName, Date dob, double height, double weight) {
		super();
		this.patientId = patientId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.height = height;
		this.weight = weight;
	}
	
//	public Patient(int patientId, String firstName, String lastName, Date dob, double height, double weight,
//			BloodType bloodType, Gender gender, List<Allergy> allergies, List<Vaccination> vaccinations) {
//		super();
//		this.patientId = patientId;
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.dob = dob;
//		this.height = height;
//		this.weight = weight;
//		this.bloodType = bloodType;
//		this.gender = gender;
//		this.allergies = allergies;
//		this.vaccinations = vaccinations;
//	}
	
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
//	public BloodType getBloodType() {
//		return bloodType;
//	}
//	public void setBloodType(BloodType bloodType) {
//		this.bloodType = bloodType;
//	}
//	public Gender getGender() {
//		return gender;
//	}
//	public void setGender(Gender gender) {
//		this.gender = gender;
//	}
//	public List<Allergy> getAllergies() {
//		return allergies;
//	}
//	public void setAllergies(List<Allergy> allergies) {
//		this.allergies = allergies;
//	}
//	public List<Vaccination> getVaccinations() {
//		return vaccinations;
//	}
//	public void setVaccinations(List<Vaccination> vaccinations) {
//		this.vaccinations = vaccinations;
//	}
	
	
}
