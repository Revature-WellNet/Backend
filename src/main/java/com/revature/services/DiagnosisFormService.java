package com.revature.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.DiagnosisForm;
import com.revature.models.Patient;
import com.revature.models.Room;
import com.revature.models.User;
import com.revature.repos.AreaRepo;
import com.revature.repos.DiagnosisFormDAO;
import com.revature.repos.PatientDAO;
import com.revature.repos.UserDAO;

@Service
public class DiagnosisFormService {

	@Autowired
	private DiagnosisFormDAO diagnosisFormDAO;
	@Autowired
	private PatientDAO patientDAO;
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private RoomService roomService;
	@Autowired
	private AreaRepo areaRepo;
	
	
	public Optional<DiagnosisForm> findDiagnosisFormById(int id) {
		return diagnosisFormDAO.findById(id);
	}
	
	public Optional<List<DiagnosisForm>> findDiagnosisFormByPatient(int patientId) {
		Optional<Patient> patient = patientDAO.findById(patientId);
		if(patient.isPresent()) {
			Optional<List<DiagnosisForm>> list = diagnosisFormDAO.findByPatient(patient.get());
			return list;
			}
		return null;
		
	}
	
	public Optional<List<DiagnosisForm>> findDiagnosisFormByNurse(String nurseId) {
		Optional<User> nurse = userDAO.findByUserId(nurseId);
		if(nurse.isPresent()) {
			Optional<List<DiagnosisForm>> list = diagnosisFormDAO.findByNurse(nurse.get());
			return list;
		}
		return null;
	}
	
	public Optional<List<DiagnosisForm>> findDiagnosisFormByDoctor(String doctorId) {
		Optional<User> doctor = userDAO.findByUserId(doctorId);
		if(doctor.isPresent()) {
			Optional<List<DiagnosisForm>> list = diagnosisFormDAO.findByDoctor(doctor.get());
			return list;
		}
		return null;
	}


	public Boolean addDiagnosisForm (DiagnosisForm diagnosisForm) {
		System.out.println(diagnosisForm.getRoom());
		try {
			System.out.println(diagnosisForm.getRoom().getId());
			diagnosisForm.getRoom().setId(diagnosisForm.getRoom().getRoomNumber());
			diagnosisForm.getRoom().setArea(areaRepo.findByName(diagnosisForm.getRoom().getArea().getName()).get());
			System.out.println(diagnosisForm);
			Room room = roomService.findById(diagnosisForm.getRoom().getId());
			System.out.println("---------------" + room.toString());
			diagnosisForm.setRoom(room);
			System.out.println("test addDiagnosis");
			diagnosisFormDAO.save(diagnosisForm);
			return true;
		} catch (Exception e) {
//			System.out.println(e.getMessage());
			return false;
		}
	}
	public Boolean updateDiagnosisForm (DiagnosisForm diagnosisForm) {
		System.out.println(diagnosisForm);
		try {
			Room room = roomService.findById(diagnosisForm.getRoom().getId());
			diagnosisForm.setRoom(room);
			diagnosisFormDAO.save(diagnosisForm);
			return true;
		} catch (Exception e) {
//			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public Boolean deleteDiagnosisForm (int  diagnosisFormId) {
		try {
			DiagnosisForm diagnosisForm = findDiagnosisFormById(diagnosisFormId).get();
			if(diagnosisForm == null) return false;
			diagnosisFormDAO.delete(diagnosisForm);
			return true;
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			return false;
		}
	}

	public List<DiagnosisForm> findAllDiagnosis() {
		return  diagnosisFormDAO.findAll();
	}
	
	
}
