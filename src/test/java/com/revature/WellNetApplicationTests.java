package com.revature;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
// models
import com.revature.models.Role;


import com.revature.security.services.RoleService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@TestInstance(Lifecycle.PER_CLASS)
@SpringBootTest
class WellNetApplicationTests {

	// @Test
	// void contextLoads() {
	// }
	@Autowired
	FirebaseAuth firebaseAuth;

	@Autowired
	private RoleService roleService;


    private static Logger logger = LoggerFactory.getLogger(WellNetApplicationTests.class);

	Role nurse = new Role("nurse");
	String nurseStr = "ROLE_NURSE";
	Role doctor = new Role("doctor");
	String doctorStr = "ROLE_DOCTOR";

	// User user1 = new User("phil1","w","phil1@email.com",nurse);
	// User user2 = new User("phil2","w","phil2@email.com", nurse);
	// User user3 = new User("phil3","w","phil3@email.com", nurse);
	// User user4 = new User("phil4","w","phil4@email.com", doctor);
	// User user5 = new User("phil5","w","phil5@email.com", doctor);
	// User user6 = new User("phil6","w","phil6@email.com", doctor);
	// User user7 = new User();
	// User user8 = new User();

	String user1_UID = "e3SvcvF5vxMBF7ywnj5eyi7yLOC3";
	String user2_UID = "NKsjOrSUMYZnJVhGUKuvIBhtTVp1";
	String user3_UID = "x6S1Pdfgc7eabppuMzIAwHbVE6m2";
	String user4_UID = "dOCJ8ca7yEQEDONRuaMkq2Meev92";
	String user5_UID = "PFmbjBYKnXSHQHqYDPFgxkoikTm2";
	String user6_UID = "CbY6DVVXM1P6B9wqGXwOqvkx5sm2";

	// Map<String, Object> claims = new HashMap<>();

	// public String generateId(){
	// 	String uuid = UUID.randomUUID().toString();

	// 	return uuid;
	// }
	// @BeforeEach
	// public void getFirebaseUsers() throws FirebaseAuthException{
	// 	UserRecord user1 = firebaseAuth.getUser(user1_UID);
	// 	UserRecord user2 = firebaseAuth.getUser(user2_UID);
	// 	UserRecord user3 = firebaseAuth.getUser(user3_UID);
	// 	UserRecord user4 = firebaseAuth.getUser(user4_UID);
	// 	UserRecord user5 = firebaseAuth.getUser(user5_UID);
	// 	UserRecord user6 = firebaseAuth.getUser(user6_UID);
	// } 

	@Test
	public void addRoleTest() throws FirebaseAuthException{

		// add nurse role to user 1
		try {
			roleService.addRole(user1_UID, nurseStr);
		} catch (Exception e) {
			e.printStackTrace();
		}

		UserRecord user = firebaseAuth.getUser(user1_UID);

		assertTrue(user.getCustomClaims().containsKey(nurseStr));

		// add doctor role to user 2
		try {
			roleService.addRole(user2_UID, doctorStr);
		} catch (Exception e) {
			e.printStackTrace();
		}

		UserRecord user2 = firebaseAuth.getUser(user2_UID);

		assertTrue(user2.getCustomClaims().containsKey(doctorStr));	
	}



	@Test
	public void removeRoleTest() throws FirebaseAuthException{

		// remove nurse role from user 1
		try {
			roleService.removeRole(user1_UID, nurseStr);
		} catch (Exception e) {
			e.printStackTrace();
		}

		UserRecord user = firebaseAuth.getUser(user1_UID);

		assertFalse(user.getCustomClaims().containsKey(nurseStr));

		// remove doctor role from user 2
		try {
			roleService.removeRole(user2_UID, doctorStr);
		} catch (Exception e) {
			e.printStackTrace();
		}

		UserRecord user2 = firebaseAuth.getUser(user2_UID);

		assertFalse(user2.getCustomClaims().containsKey(doctorStr));	
	}
}
