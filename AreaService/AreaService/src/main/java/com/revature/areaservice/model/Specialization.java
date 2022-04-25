package com.revature.areaservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

public enum Specialization {
	General_Practicioner, Primary_Care, Pediatrician, Radiologist, General_Surgeon;
}
