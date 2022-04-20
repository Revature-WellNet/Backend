package com.revature.service;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import com.revature.patientservice.model.Allergy;
import com.revature.patientservice.model.BloodType;
import com.revature.patientservice.model.DiagnosisForm;
import com.revature.patientservice.model.Patient;
import com.revature.patientservice.model.Role;
import com.revature.patientservice.model.Sex;
import com.revature.patientservice.model.User;
import com.revature.patientservice.model.Vaccination;
import com.revature.patientservice.repo.AllergyDAO;
import com.revature.patientservice.repo.BloodTypeDAO;
import com.revature.patientservice.repo.PatientDAO;
import com.revature.patientservice.repo.SexDAO;
import com.revature.patientservice.repo.VaccinationDAO;
import com.revature.patientservice.service.PatientService;

@ExtendWith({MockitoExtension.class})
public class PatientServiceTest {
	
	@InjectMocks
	PatientService patientService;
	
	@Mock
	private PatientDAO patientDAO;
	
	@Mock
	private AllergyDAO allergyDAO;
	
	@Mock
	private VaccinationDAO vaccinationDAO;
	
	@Mock
	private BloodTypeDAO bloodtypeDAO;
	
	@Mock
	private SexDAO sexDAO;
	
	 Patient patient1 = new Patient();
	 List<Patient> list = new ArrayList<Patient>();
	
	 Allergy allergy1 = new Allergy();
	 List<Allergy> allergyList = new ArrayList<Allergy>();
	
	 Vaccination vaccination1 = new Vaccination();
	 List<Vaccination> vaccinationList = new ArrayList<Vaccination>();
	
	@Before
	public void beforeAll() throws Exception {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	void testFindAllPatients() {
		Date date = new Date(500);
		List<Allergy> allergyList = new ArrayList<Allergy>();
		List<Vaccination> vaccinationList = new ArrayList<Vaccination>();
		List<DiagnosisForm> diagnosisList = new ArrayList<DiagnosisForm>();	
        this.patient1 = new Patient(1, "firstname", "lastname", date,
        		77.0, 200.0, new BloodType(1, "O-"), new Sex(1, "M"), allergyList, vaccinationList);
        list.add(this.patient1);
        
        this.allergy1 = new Allergy(1, "Pain", list);
        allergyList.add(this.allergy1);
        
        this.vaccination1 = new Vaccination(1, "Covid", list);
        vaccinationList.add(this.vaccination1);
        
        when(patientDAO.findAll()).thenReturn(list);

        //test
        List<Patient> favList = patientService.findAllPatients();
        Assertions.assertEquals(1, favList.size());

        verify(patientDAO, times(1)).findAll();
	}
	
	@Test
	void testPatientById() {
		Date date = new Date(500);
		List<Allergy> allergyList = new ArrayList<Allergy>();
		List<Vaccination> vaccinationList = new ArrayList<Vaccination>();
		List<DiagnosisForm> diagnosisList = new ArrayList<DiagnosisForm>();	
        this.patient1 = new Patient(1, "firstname", "lastname", (java.sql.Date) date,
        		77.0, 200.0, new BloodType(1, "O-"), new Sex(1, "M"), allergyList, vaccinationList);
        list.add(this.patient1);
        
        this.allergy1 = new Allergy(1, "Pain", list);
        allergyList.add(this.allergy1);
        
        this.vaccination1 = new Vaccination(1, "Covid", list);
        vaccinationList.add(this.vaccination1);
        
        when(patientDAO.findById(1)).thenReturn(java.util.Optional.of(this.patient1));

        Patient returnedPatient = patientService.findPatientById(1).get();
        assertTrue(returnedPatient.getFirstName().equals("firstname"));
	}
	
	@Test
	void testPatientByName() {	
		Date date = new Date(500);
		List<Allergy> allergyList = new ArrayList<Allergy>();
		List<Vaccination> vaccinationList = new ArrayList<Vaccination>();
		List<DiagnosisForm> diagnosisList = new ArrayList<DiagnosisForm>();	
        this.patient1 = new Patient(1, "firstname", "lastname", (java.sql.Date) date,
        		77.0, 200.0, new BloodType(1, "O-"), new Sex(1, "M"), allergyList, vaccinationList);
        list.add(this.patient1);
        
        this.allergy1 = new Allergy(1, "Pain", list);
        allergyList.add(this.allergy1);
        
        this.vaccination1 = new Vaccination(1, "Covid", list);
        vaccinationList.add(this.vaccination1);
        
        when(patientDAO.findByName("firstname")).thenReturn(java.util.Optional.of(list));

        Patient returnedPatient = patientService.findPatientByName("firstname").get().get(0);
        assertTrue(returnedPatient.getFirstName().equals("firstname"));
        
        
        when(patientDAO.findByName("firstname", "lastname")).thenReturn(java.util.Optional.of(list));

        returnedPatient = patientService.findPatientByName("firstname", "lastname").get().get(0);
        assertTrue(returnedPatient.getFirstName().equals("firstname"));
        
        
        when(patientDAO.findByName("firstname", "lastname", this.patient1.getDob())).thenReturn(java.util.Optional.of(list));

        returnedPatient = patientService.findPatientByName("firstname", "lastname", this.patient1.getDob()).get().get(0);
        assertTrue(returnedPatient.getFirstName().equals("firstname"));
	}
	
	@Test
	void testAddPatient() {
		
		
        patientService.addPatient(this.patient1);
        verify(patientDAO, times(1)).save(this.patient1);
	}
	
	@Test
	void testFindAllAllergies() {
		
		Date date = new Date(500);
		List<Allergy> allergyList = new ArrayList<Allergy>();
		List<Vaccination> vaccinationList = new ArrayList<Vaccination>();
		List<DiagnosisForm> diagnosisList = new ArrayList<DiagnosisForm>();	
        this.patient1 = new Patient(1, "firstname", "lastname", (java.sql.Date) date,
        		77.0, 200.0, new BloodType(1, "O-"), new Sex(1, "M"), allergyList, vaccinationList);
        list.add(this.patient1);
        
        this.allergy1 = new Allergy(1, "Pain", list);
        allergyList.add(this.allergy1);
        
        this.vaccination1 = new Vaccination(1, "Covid", list);
        vaccinationList.add(this.vaccination1);
        
        when(allergyDAO.findAll()).thenReturn(allergyList);

        //test
        List<Allergy> favList = patientService.findAllAllergies();
        Assertions.assertEquals(1, favList.size());

        verify(allergyDAO, times(1)).findAll();
	}
	
	@Test
	void testFindAllVaccinations() {
		Date date = new Date(500);
		List<Allergy> allergyList = new ArrayList<Allergy>();
		List<Vaccination> vaccinationList = new ArrayList<Vaccination>();
		List<DiagnosisForm> diagnosisList = new ArrayList<DiagnosisForm>();	
        this.patient1 = new Patient(1, "firstname", "lastname", (java.sql.Date) date,
        		77.0, 200.0, new BloodType(1, "O-"), new Sex(1, "M"), allergyList, vaccinationList);
        list.add(this.patient1);
        
        this.allergy1 = new Allergy(1, "Pain", list);
        allergyList.add(this.allergy1);
        
        this.vaccination1 = new Vaccination(1, "Covid", list);
        vaccinationList.add(this.vaccination1);
        
        when(vaccinationDAO.findAll()).thenReturn(vaccinationList);

        //test
        List<Vaccination> favList = patientService.findAllVaccinations();
        Assertions.assertEquals(1, favList.size());

        verify(vaccinationDAO, times(1)).findAll();
	}
	
	@Test
	void testAddAllergy() {

        patientService.addAllergy(this.allergy1);
        verify(allergyDAO, times(1)).save(this.allergy1);
	}
	
	@Test
	void testAddVaccination() {

        patientService.addVaccine(this.vaccination1);
        verify(vaccinationDAO, times(1)).save(this.vaccination1);
	}
	
	@Test
	void testDeleteAllergy() {
		Date date = new Date(500);
		List<Allergy> allergyList = new ArrayList<Allergy>();
		List<Vaccination> vaccinationList = new ArrayList<Vaccination>();
		List<DiagnosisForm> diagnosisList = new ArrayList<DiagnosisForm>();	
        this.patient1 = new Patient(1, "firstname", "lastname", (java.sql.Date) date,
        		77.0, 200.0, new BloodType(1, "O-"), new Sex(1, "M"), allergyList, vaccinationList);
        list.add(this.patient1);
        
        this.allergy1 = new Allergy(1, "Pain", list);
        allergyList.add(this.allergy1);
        
        this.vaccination1 = new Vaccination(1, "Covid", list);
        vaccinationList.add(this.vaccination1);
        
        when(allergyDAO.findByAllergy("Pain")).thenReturn(java.util.Optional.of(allergy1));

        patientService.addAllergy(allergy1);
        patientService.deleteAllergy(allergy1.getAllergy());
        
        verify(allergyDAO, times(1)).delete(allergy1);
	}
	
	@Test
	void testDeleteVaccination() {
		Date date = new Date(500);
		List<Allergy> allergyList = new ArrayList<Allergy>();
		List<Vaccination> vaccinationList = new ArrayList<Vaccination>();
		List<DiagnosisForm> diagnosisList = new ArrayList<DiagnosisForm>();	
        this.patient1 = new Patient(1, "firstname", "lastname", (java.sql.Date) date,
        		77.0, 200.0, new BloodType(1, "O-"), new Sex(1, "M"), allergyList, vaccinationList);
        list.add(this.patient1);
        
        this.allergy1 = new Allergy(1, "Pain", list);
        allergyList.add(this.allergy1);
        
        this.vaccination1 = new Vaccination(1, "Covid", list);
        vaccinationList.add(this.vaccination1);
        
        when(vaccinationDAO.findByVaccination("Covid")).thenReturn(java.util.Optional.of(vaccination1));

        patientService.addVaccine(vaccination1);
        patientService.deleteVaccine(vaccination1.getVaccination());
        
        verify(vaccinationDAO, times(1)).delete(vaccination1);
	}
	
	@Test
	void testFindBloodType() {	
		BloodType bloodtype = new BloodType(1, "O+");
        when(bloodtypeDAO.findByType("O+")).thenReturn(java.util.Optional.of(bloodtype));
        
        BloodType returnedbloodtype = patientService.findBloodType("O+").get();
        assertTrue(returnedbloodtype.getType().equals("O+"));
        
	}
	
	@Test
	void testFindSex() {	
		Sex sex = new Sex(1, "E");
        when(sexDAO.findBySex("E")).thenReturn(java.util.Optional.of(sex));
        
        Sex returnedSex = patientService.findSex("E").get();
        assertTrue(returnedSex.getSex().equals("E"));
        
	}
	
	@Test
	void testFindPatientByResoved() {
		
		Date date = new Date(500);
		List<Allergy> allergyList = new ArrayList<Allergy>();
		List<Vaccination> vaccinationList = new ArrayList<Vaccination>();
		List<DiagnosisForm> diagnosisList = new ArrayList<DiagnosisForm>();	
	
        this.patient1 = new Patient(1, "firstname", "lastname", date,
        		77.0, 200.0, new BloodType(1, "O-"), new Sex(1, "M"), allergyList, vaccinationList);
        list.add(this.patient1);
        
        this.allergy1 = new Allergy(1, "Pain", list);
        allergyList.add(this.allergy1);
        
        this.vaccination1 = new Vaccination(1, "Covid", list);
        vaccinationList.add(this.vaccination1);
        
    	DiagnosisForm daignosisForm = new DiagnosisForm();
        
        when(patientDAO.findAll()).thenReturn(list);

        //test
        List<Patient> favList = patientService.findPatientByResoved();
        Assertions.assertEquals(1, favList.size());

        verify(patientDAO, times(1)).findAll();
		
		
	}
	
	
	@After
	public void afterEach() {
		
	}

}