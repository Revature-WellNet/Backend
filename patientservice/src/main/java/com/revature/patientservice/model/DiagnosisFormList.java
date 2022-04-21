package com.revature.patientservice.model;

import java.util.ArrayList;
import java.util.List;

public class DiagnosisFormList {
	private List<DiagnosisForm> diagnosisForms;
	
	public DiagnosisFormList() {
		this.diagnosisForms = new ArrayList<>();
	}

	public List<DiagnosisForm> getDiagnosisForms() {
		return diagnosisForms;
	}

	public void setDiagnosisForms(List<DiagnosisForm> diagnosisForms) {
		this.diagnosisForms = diagnosisForms;
	}
}
