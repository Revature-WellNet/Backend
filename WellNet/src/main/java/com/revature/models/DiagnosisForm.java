package com.revature.models;

import javax.persistence.*;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Entity
@Component
public class DiagnosisForm {
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int diagId; 
	private String diagnosis;
	private boolean resolutionStatus;
	private Timestamp checkIn;
	private Timestamp checkOut;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "patient_id")
	private Patient patient;
	private Room room;
	private User nurse;
	private User doctor;
	
	public DiagnosisForm() {
		super();
	}
	
	public DiagnosisForm(int diagId, String diagnosis, boolean resolutionStatus, Timestamp checkIn,
			Timestamp checkOut) {
		super();
		this.diagId = diagId;
		this.diagnosis = diagnosis;
		this.resolutionStatus = resolutionStatus;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
//	public DiagnosisForm(int diagId, String diagnosis, boolean resolutionStatus, Timestamp checkIn, Timestamp checkOut,
//	Patient patient, Room room, User nurse, User doctor) {
//		super();
//		this.diagId = diagId;
//		this.diagnosis = diagnosis;
//		this.resolutionStatus = resolutionStatus;
//		this.checkIn = checkIn;
//		this.checkOut = checkOut;
//		this.patient = patient;
//		this.room = room;
//		this.nurse = nurse;
//		this.doctor = doctor; 
//	}

	public int getDiagId() {
		return diagId;
	}

	public void setDiagId(int diagId) {
		this.diagId = diagId;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public boolean isResolutionStatus() {
		return resolutionStatus;
	}

	public void setResolutionStatus(boolean resolutionStatus) {
		this.resolutionStatus = resolutionStatus;
	}

	public Timestamp getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(Timestamp checkIn) {
		this.checkIn = checkIn;
	}

	public Timestamp getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(Timestamp checkOut) {
		this.checkOut = checkOut;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
//
//	public Room getRoom() {
//		return room;
//	}
//
//	public void setRoom(Room room) {
//		this.room = room;
//	}
//
//	public User getNurse() {
//		return nurse;
//	}
//
//	public void setNurse(User nurse) {
//		this.nurse = nurse;
//	}
//
//	public User getDoctor() {
//		return doctor;
//	}
//
//	public void setDoctor(User doctor) {
//		this.doctor = doctor;
//	}
	
	
	
	
	
		
}
