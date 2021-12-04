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
class SecurityTests {

	@Autowired
	FirebaseAuth firebaseAuth;

	@Autowired
	private RoleService roleService;

    private static Logger logger = LoggerFactory.getLogger(SecurityTests.class);

	Role nurse = new Role("nurse");
	String nurseStr = "ROLE_NURSE";
	Role doctor = new Role("doctor");
	String doctorStr = "ROLE_DOCTOR";

	String user1_UID = "e3SvcvF5vxMBF7ywnj5eyi7yLOC3";
	String user2_UID = "NKsjOrSUMYZnJVhGUKuvIBhtTVp1";
	String user3_UID = "x6S1Pdfgc7eabppuMzIAwHbVE6m2";
	String user4_UID = "dOCJ8ca7yEQEDONRuaMkq2Meev92";
	String user5_UID = "PFmbjBYKnXSHQHqYDPFgxkoikTm2";
	String user6_UID = "CbY6DVVXM1P6B9wqGXwOqvkx5sm2";

	@Test
	public void addRoleTest() throws FirebaseAuthException{

		// add nurse role to user 1
		try {
			roleService.addRole(user1_UID, nurseStr);
		} catch (Exception e) {
			e.printStackTrace();
		}

		UserRecord user = firebaseAuth.getUser(user1_UID);

        // positive test
		assertTrue(user.getCustomClaims().containsKey(nurseStr));

		// add doctor role to user 2
		try {
			roleService.addRole(user2_UID, doctorStr);
		} catch (Exception e) {
			e.printStackTrace();
		}

		UserRecord user2 = firebaseAuth.getUser(user2_UID);

        // positive test
		assertTrue(user2.getCustomClaims().containsKey(doctorStr));	


        try {
			roleService.addRole(user3_UID, "not-a-valid-input");
		} catch (Exception e) {
			e.printStackTrace();
            // negative test
            assertTrue(e != null);
		}
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
        

        try {
			roleService.removeRole(user2_UID, "not-a-valid-input");
		} catch (Exception e) {
			e.printStackTrace();
            // negative test
            assertTrue(e != null);
		}
	}
}
