package com.revature.roomservice.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.revature.roomservice.model.User;
import org.springframework.stereotype.Component;

@Entity
@Component
public class Room {

	@Id
//    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int roomId;
	@Column(unique = true, nullable = false)
	private int roomNumber;
	@JoinColumn(name = "areaId", referencedColumnName = "areaId", nullable = false)
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	private Area area;
	@OneToOne
	@JoinColumn(name = "userId")
	private User doctor;
//	@OneToOne
//	@JoinColumn(name = "userId")
//	private User nurse;
	@OneToOne
	@JoinColumn(name = "patientId")
	private Patient patient;

	public Room(int id, int roomNumber, Area area, User doctor, Patient patient) {
		this.roomId = id;
		this.roomNumber = roomNumber;
		this.area = area;
		this.doctor = doctor;
		this.patient = patient;
	}

	public Room() {
	}

	public int getId() {
		return this.roomId;
	}

	public void setId(int id) {
		this.roomId = id;
	}

	public int getRoomNumber() {
		return this.roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Area getArea() {
		return this.area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public User getDoctor() {
		return this.doctor;
	}

	public void setDoctor(User doctor) {
		this.doctor = doctor;
	}


	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", roomNumber=" + roomNumber + ", area=" + area + ", doctor=" + doctor
				 + ", patient=" + patient + "]";
	}

}
