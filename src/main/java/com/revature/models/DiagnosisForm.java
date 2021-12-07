package com.revature.models;

import javax.persistence.*;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Component
public class DiagnosisForm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int diagId;
    private String diagnosis;
    private String symptoms;
    private String treatment;
    private boolean resolutionStatus;
    private Timestamp checkIn;
    private Timestamp checkOut;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "patient_id")
    @JsonIgnoreProperties("diagnosisForms")
    private Patient patient;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "nurse_id")
    private User nurse;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "doctor_id")
    private User doctor;

    public DiagnosisForm() {
        super();
    }
    
    
    
    public DiagnosisForm(String diagnosis, String symptoms, boolean resolutionStatus, Timestamp checkIn,
			Patient patient, Room room, User nurse) {
		super();
		this.diagnosis = diagnosis;
		this.symptoms = symptoms;
		this.resolutionStatus = resolutionStatus;
		this.checkIn = checkIn;
		this.patient = patient;
		this.room = room;
		this.nurse = nurse;
	}



	public DiagnosisForm(int diagId, String diagnosis, String symptoms, String treatment, boolean resolutionStatus, Timestamp checkIn,
                         Timestamp checkOut) {
        super();
        this.diagId = diagId;
        this.diagnosis = diagnosis;
        this.symptoms = symptoms;
        this.treatment = treatment;
        this.resolutionStatus = resolutionStatus;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public DiagnosisForm(int diagId, String diagnosis, String symptoms, String treatment, boolean resolutionStatus, Timestamp checkIn, Timestamp checkOut,
                         Patient patient, Room room, User nurse, User doctor) {
        super();
        this.diagId = diagId;
        this.diagnosis = diagnosis;
        this.symptoms = symptoms;
        this.treatment = treatment;
        this.resolutionStatus = resolutionStatus;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.patient = patient;
        this.room = room;
        this.nurse = nurse;
        this.doctor = doctor;
    }


    public DiagnosisForm(String diagnosis, String symptoms, String treatment, boolean resolutionStatus, Timestamp checkIn, Timestamp checkOut, Patient patient,
                         Room room, User nurse, User doctor) {
        super();
        this.diagnosis = diagnosis;
        this.symptoms = symptoms;
        this.treatment = treatment;
        this.resolutionStatus = resolutionStatus;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.patient = patient;
        this.room = room;
        this.nurse = nurse;
        this.doctor = doctor;
    }

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

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
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

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public User getNurse() {
        return nurse;
    }

    public void setNurse(User nurse) {
        this.nurse = nurse;
    }

    public User getDoctor() {
        return doctor;
    }

    public void setDoctor(User doctor) {
        this.doctor = doctor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiagnosisForm that = (DiagnosisForm) o;
        return diagId == that.diagId && resolutionStatus == that.resolutionStatus && Objects.equals(diagnosis, that.diagnosis) && Objects.equals(symptoms, that.symptoms) && Objects.equals(treatment, that.treatment) && Objects.equals(checkIn, that.checkIn) && Objects.equals(checkOut, that.checkOut) && Objects.equals(patient, that.patient) && Objects.equals(room, that.room) && Objects.equals(nurse, that.nurse) && Objects.equals(doctor, that.doctor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(diagId, diagnosis, symptoms, treatment, resolutionStatus, checkIn, checkOut, patient, room, nurse, doctor);
    }

    @Override
    public String toString() {
        return "DiagnosisForm{" +
                "diagId=" + diagId +
                ", diagnosis='" + diagnosis + '\'' +
                ", symptoms='" + symptoms + '\'' +
                ", treatment='" + treatment + '\'' +
                ", resolutionStatus=" + resolutionStatus +
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                ", patient=" + patient +
                ", room=" + room +
                ", nurse=" + nurse +
                ", doctor=" + doctor +
                '}';
    }
}
