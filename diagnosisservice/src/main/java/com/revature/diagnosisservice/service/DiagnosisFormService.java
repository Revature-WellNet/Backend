package com.revature.diagnosisservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.diagnosisservice.model.DiagnosisForm;
import com.revature.diagnosisservice.model.Patient;
import com.revature.diagnosisservice.model.Room;
import com.revature.diagnosisservice.model.User;
//import com.revature.diagnosisservice.repo.AreaRepo;
//import com.revature.diagnosisservice.repo.DiagnosisFormDAO;
//import com.revature.diagnosisservice.repo.PatientDAO;
//import com.revature.diagnosisservice.repo.UserDAO;
import com.revature.diagnosisservice.repo.DiagnosisFormRepo;

@Service
public class DiagnosisFormService {

	@Autowired
	private DiagnosisFormRepo diagnosisFormRepo;
	@Autowired
//	private PatientDAO patientDAO;
//	@Autowired
//	private UserDAO userDAO;
//	@Autowired
//	private RoomService roomService;
//	@Autowired
//	private AreaRepo areaRepo;
	
	

	
	public Optional<DiagnosisForm> findDiagnosisFormById(int id) {
		return diagnosisFormRepo.findById(id);
	}
	
//	//Added
//	public void saveDiagnosisForm(DiagnosisForm diagnosisForm) {
//		diagnosisFormRepo.save(diagnosisForm);
//	}
//	
//	//Added
//	public List<DiagnosisForm> findAllDiagnosisForms() {
//		return diagnosisFormRepo.findAll();
//	}
//	
//	//Added
//	public void updateDiagnosisForm(DiagnosisForm diagnosisForm) {
//		diagnosisFormRepo.save(diagnosisForm);
//	}
//	//Added
//	//May need try catch
//	public boolean deleteDiagnosisForm(int id) {
//		diagnosisFormRepo.delete(findDiagnosisFormById(id));
//		return !diagnosisFormRepo.existsById(id);
//	}
	
	public Optional<List<DiagnosisForm>> findDiagnosisFormByPatient(int patientId) {
		Optional<Patient> patient = patientDAO.findById(patientId);
		if(patient.isPresent()) {
			Optional<List<DiagnosisForm>> list = diagnosisFormRepo.findByPatient(patient.get());
			return list;
			}
		return null;
		
	}
	

	public Optional<List<DiagnosisForm>> findDiagnosisFormByNurse(String nurseId) {
		Optional<User> nurse = userDAO.findByUserId(nurseId);
		if(nurse.isPresent()) {
			Optional<List<DiagnosisForm>> list = diagnosisFormRepo.findByNurse(nurse.get());
			return list;
		}
		return null;
	}
	
	public Optional<List<DiagnosisForm>> findDiagnosisFormByDoctor(String doctorId) {
		Optional<User> doctor = userDAO.findByUserId(doctorId);
		if(doctor.isPresent()) {
			Optional<List<DiagnosisForm>> list = diagnosisFormRepo.findByDoctor(doctor.get());
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
			diagnosisFormRepo.save(diagnosisForm);
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
			diagnosisFormRepo.save(diagnosisForm);
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
			diagnosisFormRepo.delete(diagnosisForm);
			return true;
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			return false;
		}
	}

	public List<DiagnosisForm> findAllDiagnosis() {
		return  diagnosisFormRepo.findAll();
	}
	
	
}
