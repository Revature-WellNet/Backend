package com.revature.patientservice.model;

import javax.persistence.*;

import org.springframework.stereotype.Component;

import com.revature.patientservice.model.Room;
import com.revature.patientservice.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiagnosisForm {
	
    private int diagId;
    private String diagnosis;
    private String symptoms;
    private String treatment;
    private boolean resolutionStatus;
    private Timestamp checkIn;
    private Timestamp checkOut;
    private Patient patient;
    private Room room;
    private User nurse;
    private User doctor;
    
	public boolean isResolutionStatus() {
		return resolutionStatus;
	}
	public void setResolutionStatus(boolean resolutionStatus) {
		this.resolutionStatus = resolutionStatus;
	}
    
    
 

}
