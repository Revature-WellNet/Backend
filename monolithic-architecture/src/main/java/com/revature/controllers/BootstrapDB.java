package com.revature.controllers;

import com.revature.models.*;
import com.revature.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


@CrossOrigin(origins="*", allowedHeaders="*")
@RestController
@RequestMapping(value="/public/bootstrapDB")
public class BootstrapDB {

	private  RoleDAO roleDao;
	private  SexDAO sexDao;
	private BloodTypeDAO bloodTypeDAO;
	private VaccinationDAO vaccinationDAO;
	private Covid19VerificationDAO covidVerificationDAO;
	private AllergyDAO allergyDAO;
	private AreaRepo areaDAO;
	private RoomRepo roomDAO;
	private UserDAO userDAO;
	private PatientDAO patientDAO;
	private DiagnosisFormDAO diagnosisFormDAO;
	
	@Autowired
	public BootstrapDB(RoleDAO roleDao, SexDAO sexDao, BloodTypeDAO bloodTypeDAO, 
			VaccinationDAO vaccinationDAO, Covid19VerificationDAO covidVerificationDAO,
			AllergyDAO allergyDAO, AreaRepo areaDAO, RoomRepo roomDAO, UserDAO userDAO,
			PatientDAO patientDAO, DiagnosisFormDAO diagnosisFormDAO) {
		
		this.roleDao = roleDao;
		this.sexDao = sexDao;
		this.bloodTypeDAO = bloodTypeDAO;
		this.vaccinationDAO = vaccinationDAO;
		this.covidVerificationDAO = covidVerificationDAO;
		this.allergyDAO = allergyDAO;
		this.areaDAO = areaDAO;
		this.roomDAO = roomDAO;
		this.userDAO = userDAO;
		this.patientDAO = patientDAO;
		this.diagnosisFormDAO = diagnosisFormDAO;
	}
	


	private Role role1 = new Role(1,"Nurse");
	private Role role2 = new Role(2,"Doctor");
	
	private Sex sex1 = new Sex(1,"M");
	private Sex sex2 = new Sex(2,"F");
	private Sex sex3 = new Sex(3,"NB");
	
	private BloodType bloodType1 = new BloodType(1,"O-"); 
	private BloodType bloodType2 = new BloodType(2,"O+"); 
	private BloodType bloodType3 = new BloodType(3,"B-"); 
	private BloodType bloodType4 = new BloodType(4,"B+");
	private BloodType bloodType5 = new BloodType(5,"A-"); 
	private BloodType bloodType6 = new BloodType(6,"A+"); 
	private BloodType bloodType7 = new BloodType(7,"AB-"); 
	private BloodType bloodType8 = new BloodType(8,"AB+");
	
	private User nurse = new User("1","Alice", "Foo", "alice@foo.com",role1);
	private User doctor = new User("2","Bob", "Bar", "bob@bar.com",role2);
	
	private Vaccination vaccination1 = new Vaccination(1,"Covid-19",null);
	
	private Covid19Verification covid19Verification  = new Covid19Verification(1,
									"abc", new Timestamp(System.currentTimeMillis()),false);
	
	private Allergy allergy1 = new Allergy(1,"Drug Allergy",null);
	private Allergy allergy2 = new Allergy(2,"Food Allergy",null);
	private Allergy allergy3 = new Allergy(3,"Insect Allergy",null);
	private Allergy allergy4 = new Allergy(4,"Latex Allergy",null);
	private Allergy allergy5 = new Allergy(5,"Pollen Allergy",null);
	
	private Area area1 = new Area(1,"Emergency");
	private Area area2 = new Area(2,"Dispensary");
	private Area area3 = new Area(3,"Consulting");
	
	private Room room1 = new Room(1,1,area1);
	private Room room2 = new Room(2,2,area2);
	private Room room3 = new Room(3,3,area3);
	
	private List<Allergy> allergys = new ArrayList<Allergy>();
	private ArrayList<Vaccination> vaccinations = new ArrayList<Vaccination>();
	private ArrayList<DiagnosisForm> diagnosisForms = new ArrayList<DiagnosisForm>();
	private Date dob = Date.valueOf("1920-03-31");
	

	
	public void addRole(){
		roleDao.save(role1);
		roleDao.save(role2);
	}
	
	public void addUser(){
		userDAO.save(nurse);
		userDAO.save(doctor);
	}

	
	public void addSex(){
		sexDao.save(sex1);
		sexDao.save(sex2);
		sexDao.save(sex3);
	}

	private void addArea() {
		areaDAO.save(area1);
		areaDAO.save(area2);
		areaDAO.save(area3);
	}

	private void addRoom() {
		roomDAO.save(room1);
		roomDAO.save(room2);
		roomDAO.save(room3);
	}

	private void addAllergy() {
		allergyDAO.save(allergy1);
		allergyDAO.save(allergy2);
		allergyDAO.save(allergy3);
		allergyDAO.save(allergy4);
		allergyDAO.save(allergy5);
	}

	private void addCovidVerification() {
		covidVerificationDAO.save(covid19Verification);
	}

	private void addBloodType() {
		
		bloodTypeDAO.save(bloodType1);
		bloodTypeDAO.save(bloodType2);
		bloodTypeDAO.save(bloodType3);
		bloodTypeDAO.save(bloodType4);
		bloodTypeDAO.save(bloodType5);
		bloodTypeDAO.save(bloodType6);
		bloodTypeDAO.save(bloodType7);
		bloodTypeDAO.save(bloodType8);
	}

	private void addVaccination() {
		vaccinationDAO.save(vaccination1);
	}


	private void addPatientAndDiag() {
		
		allergys.add(allergy1);
		vaccinations.add(vaccination1);
		Patient patient1 = new Patient("Captain","America", 
				dob, 6.0, 200.0, bloodType1, sex1, allergys, vaccinations, diagnosisForms);
		patientDAO.save(patient1);
		
		DiagnosisForm diagnosisForm = new DiagnosisForm("Septicemia", "mental instability, high respiratory rate, high blood pressure", "antibiotics", false,
				new Timestamp(System.currentTimeMillis()), null, 
				patient1, room1,nurse,doctor);
		
		diagnosisFormDAO.save(diagnosisForm);
	}
	
	public void run() {
		
		addRole();
		addUser();
		addSex();
		addVaccination();
		addBloodType();
		addCovidVerification();
		addAllergy();
		addRoom();
		addArea();
		addPatientAndDiag();
	
	}
	
	@GetMapping(value="/filler/one")
	public ResponseEntity<List<Patient>> setAllDB(){
		
		System.err.println("Populating H2 Database");
		
		this.run();
		
		return ResponseEntity.noContent().build();
		
	}
	
	@GetMapping(value="/allergy")
	public ResponseEntity<List<Allergy>> getAllergies(){
		List<Allergy> all = allergyDAO.findAll();
		
		if(all.isEmpty()) {
			return ResponseEntity.noContent().build();
		}	
		return ResponseEntity.ok(all);
	}

}
