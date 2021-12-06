package com.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import com.revature.models.BloodType;
//import com.revature.repos.AllergyDAO;
//import com.revature.repos.AreaRepo;
//import com.revature.repos.BloodTypeDAO;
//import com.revature.repos.Covid19VerificationDAO;
//import com.revature.repos.DiagnosisFormDAO;
//import com.revature.repos.PatientDAO;
//import com.revature.repos.RoleDAO;
//import com.revature.repos.RoomRepo;
//import com.revature.repos.SexDAO;
//import com.revature.repos.UserDAO;
//import com.revature.repos.VaccinationDAO;

@SpringBootApplication
public class WellNetApplication {
//	
//
//	private static RoleDAO roleDao;
//	private static SexDAO sexDao;
//	private static BloodTypeDAO bloodTypeDAO;
//	private static VaccinationDAO vaccinationDAO;
//	private static Covid19VerificationDAO covidVerificationDAO;
//	private static AllergyDAO allergyDAO;
//	private static AreaRepo areaDAO;
//	private static RoomRepo roomDAO;
//	private static UserDAO userDAO;
//	private static PatientDAO patientDAO;
//	private static DiagnosisFormDAO diagnosisFormDAO;
//	
//
//
//	@Autowired
//	public WellNetApplication(RoleDAO roleDao, SexDAO sexDao, BloodTypeDAO bloodTypeDAO, 
//			VaccinationDAO vaccinationDAO, Covid19VerificationDAO covidVerificationDAO,
//			AllergyDAO allergyDAO, AreaRepo areaDAO, RoomRepo roomDAO, UserDAO userDAO,
//			PatientDAO patientDAO, DiagnosisFormDAO diagnosisFormDAO) {
//		
//		super();
//		
//		WellNetApplication.roleDao = roleDao;
//		WellNetApplication.sexDao = sexDao;
//		WellNetApplication.bloodTypeDAO = bloodTypeDAO;
//		WellNetApplication.vaccinationDAO = vaccinationDAO;
//		WellNetApplication.covidVerificationDAO = covidVerificationDAO;
//		WellNetApplication.allergyDAO = allergyDAO;
//		WellNetApplication.areaDAO = areaDAO;
//		WellNetApplication.roomDAO = roomDAO;
//		WellNetApplication.userDAO = userDAO;
//		WellNetApplication.patientDAO = patientDAO;
//		WellNetApplication.diagnosisFormDAO = diagnosisFormDAO;
//	}
	
//	@Autowired
//	private static BootstrapDB dbLoader;
//	
//	@Autowired
//	public WellNetApplication(BootstrapDB dbLoader){
//		super();
//		
//		WellNetApplication.dbLoader = dbLoader;
//		
//	}
	
	public static void main(String[] args) {
		
//		dbLoader.run();
		
//		addBloodType();
		
		SpringApplication.run(WellNetApplication.class, args);
		
		System.err.println("=== Application Started ===");
	}
	
//
//	
//
//	private static BloodType bloodType1 = new BloodType(1,"A"); 
//	private static BloodType bloodType2 = new BloodType(2,"B"); 
//	private static BloodType bloodType3 = new BloodType(3,"AB"); 
//	private static BloodType bloodType4 = new BloodType(4,"O"); 
//	
//	private static void addBloodType() {
//		
//		bloodTypeDAO.save(bloodType1);
//		bloodTypeDAO.save(bloodType2);
//		bloodTypeDAO.save(bloodType3);
//		bloodTypeDAO.save(bloodType4);
//	}

}
