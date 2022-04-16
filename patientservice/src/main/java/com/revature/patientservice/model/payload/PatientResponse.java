package com.revature.patientservice.model.payload;

import java.sql.Date;
import java.util.List;

import com.revature.patientservice.model.Allergy;
import com.revature.patientservice.model.BloodType;
import com.revature.patientservice.model.DiagnosisForm;
import com.revature.patientservice.model.Sex;
import com.revature.patientservice.model.Vaccination;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientResponse {
	private int patientId;
    private String firstName;
    private String lastName;
    private Date dob;
    private double height;
    private double weight;
    private BloodType bloodType;
    private Sex sex;
    private List<Allergy> patientAllergies;
    private List<Vaccination> patientVaccinations;
    private List<DiagnosisForm> diagnosisForms;
    
}
