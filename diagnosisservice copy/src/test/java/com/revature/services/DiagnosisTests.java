package com.revature.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.revature.diagnosisservice.model.Allergy;
import com.revature.diagnosisservice.model.Area;
import com.revature.diagnosisservice.model.BloodType;
import com.revature.diagnosisservice.model.DiagnosisForm;
import com.revature.diagnosisservice.model.Patient;
import com.revature.diagnosisservice.model.Role;
import com.revature.diagnosisservice.model.Room;
import com.revature.diagnosisservice.model.Sex;
import com.revature.diagnosisservice.model.User;
import com.revature.diagnosisservice.model.Vaccination;
import com.revature.diagnosisservice.repo.DiagnosisFormRepo;
import com.revature.diagnosisservice.service.DiagnosisFormService;

@ExtendWith({MockitoExtension.class})
public class DiagnosisTests {

	public static Patient patient;
	public static User nurse;
	public static User doctor;
	public static User user1;
	public static DiagnosisForm d1;
	public static Room room;
	public static Area area;
	public static Allergy allergy;
	public static Vaccination vaccination;

	@InjectMocks
	DiagnosisFormService diagnosisFormService;
	@Mock
	private DiagnosisFormRepo diagnosisFormRepo;

	@Before
	public void beforeAll() throws Exception {
		MockitoAnnotations.openMocks(this);

		allergy = new Allergy(1, "drug allergy", null);
		vaccination = new Vaccination(1, "covid-19", null);
		ArrayList<DiagnosisForm> diagnosisForms = new ArrayList<DiagnosisForm>();

		nurse = new User("1", "nursefirst", "nurselast", "nurse@em.com", new Role(1, "nurse"));
		doctor = new User("2", "doctorfirst", "doctorlast", "doctor@em.com", new Role(2, "doctor"));
		patient = new Patient(1, "patientfirst", "patientlast", new Date(900), 72, 170, new BloodType(1, "O+"),
				new Sex(1, "M"), new ArrayList<Allergy>(Arrays.asList(allergy)),
				new ArrayList<Vaccination>(Arrays.asList(vaccination)), diagnosisForms);
		area = new Area(1, "roomy");
		room = new Room(1, 102, area);
	}

	@Test
	void testSaveDiagnosisForm() {

		DiagnosisForm d1 = new DiagnosisForm(1, "sick", "coughing", "rest", false, new Timestamp(System.currentTimeMillis()), null, patient, room, nurse, doctor);

		diagnosisFormService.saveDiagnosisForm(d1);
		verify(diagnosisFormRepo, times(1)).save(d1);
	}
	
	@Test
	void testUpdateDiag() {
		
		DiagnosisForm d1 = new DiagnosisForm(1, "sick", "coughing", "rest", false, new Timestamp(System.currentTimeMillis()), null, patient, room, nurse, doctor);

		diagnosisFormService.updateDiagnosisForm(d1);
		verify(diagnosisFormRepo, times(1)).save(d1);
	}
	
	@Test
	public void testFindByDiagnosisId() {
		
		DiagnosisForm d1 = new DiagnosisForm(1, "sick", "coughing", "rest", false, new Timestamp(System.currentTimeMillis()), null, patient, room, nurse, doctor);
        when(diagnosisFormRepo.findById(1)).thenReturn(java.util.Optional.of(d1));

        DiagnosisForm check = diagnosisFormService.findDiagnosisFormById(1).get();
		
        assertTrue(check.getDiagId()==1);
        verify(diagnosisFormRepo, times(1)).findById(d1.getDiagId());
	}
	
	@Test
	void testFindAllDiagnosisForms() {
	    List<DiagnosisForm> listForms = new ArrayList<DiagnosisForm>();
		DiagnosisForm d1 = new DiagnosisForm(1, "sick", "coughing", "rest", false, new Timestamp(System.currentTimeMillis()), null, patient, room, nurse, doctor);

		listForms.add(d1);
		when(diagnosisFormRepo.findAll()).thenReturn(listForms);
		List<DiagnosisForm> checkForms = diagnosisFormService.findAllDiagnosisForms();

		assertEquals(1, checkForms.size());
		verify(diagnosisFormRepo, times(1)).findAll();
	}

	@Test
	void testFindByDoctor() {
		List<DiagnosisForm> listForms = new ArrayList<DiagnosisForm>();
		DiagnosisForm d1 = new DiagnosisForm(1, "sick", "coughing", "rest", false, new Timestamp(System.currentTimeMillis()), null, patient, room, nurse, doctor);

		listForms.add(d1);
        when(diagnosisFormRepo.findByDoctor(doctor)).thenReturn(java.util.Optional.of(listForms));
        Optional<List<DiagnosisForm>> checkForms = diagnosisFormService.findDiagnosisFormByDoctor(doctor);

        assertEquals(1, checkForms.get().size());
		verify(diagnosisFormRepo, times(1)).findByDoctor(doctor);
	}
	
	@Test
	void testFindByNurse() {
		List<DiagnosisForm> listForms = new ArrayList<DiagnosisForm>();
		DiagnosisForm d1 = new DiagnosisForm(1, "sick", "coughing", "rest", false, new Timestamp(System.currentTimeMillis()), null, patient, room, nurse, doctor);

		listForms.add(d1);
        when(diagnosisFormRepo.findByNurse(nurse)).thenReturn(java.util.Optional.of(listForms));
        Optional<List<DiagnosisForm>> checkForms = diagnosisFormService.findDiagnosisFormByNurse(nurse);

        assertEquals(1, checkForms.get().size());
        verify(diagnosisFormRepo, times(1)).findByNurse(nurse);
	}
	
	@Test
	void testFindByPatient() {
		List<DiagnosisForm> listForms = new ArrayList<DiagnosisForm>();
		DiagnosisForm d1 = new DiagnosisForm(1, "sick", "coughing", "rest", false, new Timestamp(System.currentTimeMillis()), null, patient, room, nurse, doctor);

		listForms.add(d1);
        when(diagnosisFormRepo.findByPatient(patient)).thenReturn(java.util.Optional.of(listForms));
        Optional<List<DiagnosisForm>> checkForms = diagnosisFormService.findDiagnosisFormByPatient(patient);

        assertEquals(1, checkForms.get().size());
        verify(diagnosisFormRepo, times(1)).findByPatient(patient);
	}

	@Test
	void deleteDiagnosisForm() {
		DiagnosisForm d1 = new DiagnosisForm(1, "sick", "coughing", "rest", false, new Timestamp(System.currentTimeMillis()), null, patient, room, nurse, doctor);

		diagnosisFormService.deleteDiagnosisForm(d1);
		verify(diagnosisFormRepo, times(1)).delete(d1);
	}
}