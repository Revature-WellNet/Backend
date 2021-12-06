package com.revature.services;


import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.revature.models.Allergy;
import com.revature.models.Area;
import com.revature.models.BloodType;
import com.revature.models.DiagnosisForm;
import com.revature.models.Patient;
import com.revature.models.Role;
import com.revature.models.Room;
import com.revature.models.Sex;
import com.revature.models.User;
import com.revature.models.Vaccination;
import com.revature.repos.DiagnosisFormDAO;
import com.revature.repos.PatientDAO;
import com.revature.repos.UserDAO;

@ExtendWith({MockitoExtension.class})
public class DiagnosisFormTest {
	public static Patient patient; 
	public static User nurse; 
	public static User doctor;
	


	@InjectMocks
	DiagnosisFormService diagFormService;
	@Mock
	private DiagnosisFormDAO diagnosisFormDAO;
	@Mock
	private PatientDAO patientDAO;
	@Mock
	private UserDAO userDAO;
	
	@Before
	public  void beforeAll() throws Exception {
		MockitoAnnotations.openMocks(this);
		Allergy allergy = new Allergy(1,"drug allergy",null);
		Vaccination vaccination = new Vaccination(1,"covid-19",null);
		ArrayList<DiagnosisForm> diagnosisForms = new ArrayList<DiagnosisForm>();

         nurse = new User("1", "nursefirst", "nurselast", "nurse@em.com", new Role(1, "nurse"));
         doctor = new User("2", "doctorfirst", "doctorlast", "doctor@em.com", new Role(2, "doctor"));
         patient = new Patient(1,"patientfirst", "patientlast",new Date(900),72,170,new BloodType(1,"O+"),new Sex(1,"M"),
        		new ArrayList<Allergy>(Arrays.asList(allergy)),new ArrayList<Vaccination>(Arrays.asList(vaccination)),
        		diagnosisForms);
		
	}
	

	
	
	@Test
	public void testFindById() {
		DiagnosisForm df = new DiagnosisForm(1,"diagnosis string","symptoms string","treatment string",false,
				new Timestamp(System.currentTimeMillis()),null,patient,new Room(1,1,new Area (1,"areaone")),
				nurse,doctor);
        when(diagnosisFormDAO.findById(1)).thenReturn(java.util.Optional.of(df));
        DiagnosisForm diagnosisFormTestReturn = diagFormService.findDiagnosisFormById(1).get();
        assertTrue(diagnosisFormTestReturn.getDiagId()==1);

	}
	@Test
	void testFindAllDiagnosisForms() {
	    List<DiagnosisForm> list = new ArrayList<DiagnosisForm>();
	    DiagnosisForm df = new DiagnosisForm(1,"diagnosis string","symptoms string","treatment string",false,
				new Timestamp(System.currentTimeMillis()),null,patient,new Room(1,1,new Area (1,"areaone")),
				nurse,doctor);
        list.add(df);
        assertEquals(1, 1);
        when(diagnosisFormDAO.findAll()).thenReturn(list);

        //test
        List<DiagnosisForm> favList = diagFormService.findAllDiagnosis();
        Assertions.assertEquals(1, favList.size());

        verify(diagnosisFormDAO, times(1)).findAll();
	}
	
	@Test
	void testFindByDoctor() {
	    List<DiagnosisForm> list = new ArrayList<DiagnosisForm>();
		 DiagnosisForm df = new DiagnosisForm(1,"diagnosis string","symptoms string","treatment string",false,
					new Timestamp(System.currentTimeMillis()),null,patient,new Room(1,1,new Area (1,"areaone")),
					nurse,doctor);
		    list.add(df);
	        when(diagnosisFormDAO.findByDoctor(doctor)).thenReturn(java.util.Optional.of(list));
	        Optional<List<DiagnosisForm>> dfReturnList = diagFormService.findDiagnosisFormByDoctor("1");
	        Assertions.assertEquals(1, dfReturnList.get().size());
	        verify(diagnosisFormDAO, times(1)).findByDoctor(doctor);

	}
	
}

