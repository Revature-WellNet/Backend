package com.revature;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;

// models
import com.revature.models.Role;
import com.revature.security.models.Credentials;
import com.revature.security.services.RoleService;
import com.revature.security.services.SecurityService;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

import com.revature.security.models.AuthUserDTO;
import com.revature.security.models.SecurityProperties;

@TestInstance(Lifecycle.PER_CLASS)
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class SecurityTests {

	@Autowired
	FirebaseAuth firebaseAuth;

	@Autowired
	private RoleService roleService;

	@Autowired
	private SecurityProperties securityProps;

	@Autowired
	private SecurityService securityService;               
                                                                                            
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

	// not a valid user id
	String user7_UID = "7777777777777777777777777777";

	/**
	 * Testing RoleService
	 */

	@Test
	@Order(1)
	public void addNurseRolePositiveTest() throws Exception {
		// add nurse role to user 1
		roleService.addRole(user1_UID, nurseStr);

		UserRecord user = firebaseAuth.getUser(user1_UID);

        // positive test
		assertTrue(user.getCustomClaims().containsKey(nurseStr));
	}

	@Test
	@Order(1)
	public void addDoctorRolePositiveTest() throws Exception {
		// add doctor role to user 2
		roleService.addRole(user2_UID, doctorStr);
	
		UserRecord user2 = firebaseAuth.getUser(user2_UID);

        // positive test
		assertTrue(user2.getCustomClaims().containsKey(doctorStr));	
	}


	@Test
	@Order(1)
	public void addInvalidRoleNegativeTest() {
        try {
			roleService.addRole(user3_UID, "invalid-id");
		} catch (Exception e) {
            // negative test
            assertEquals(e.getMessage(), "Invalid Application role, Allowed roles => "
			+ securityProps.getValidApplicationRoles().toString());
		}
	}

	@Test
	@Order(1)
	public void addInvalidUserIDNegativeTest() throws FirebaseAuthException{
        try {
			roleService.addRole(user7_UID, nurseStr);
		} catch (Exception e) {
            // negative test
            assertEquals(e.getMessage(), "Invalid UID");
		}
	}

	@Test
	@Order(2)
	public void removeNurseRolePositiveTest() throws Exception{
		// remove nurse role from user 1
		roleService.removeRole(user1_UID, nurseStr);

		UserRecord user = firebaseAuth.getUser(user1_UID);

		assertFalse(user.getCustomClaims().containsKey(nurseStr));
	}

	@Test
	@Order(2)
	public void removeDoctorRolePositiveTest() throws Exception{
		// remove doctor role from user 2
		roleService.removeRole(user2_UID, doctorStr);

		UserRecord user2 = firebaseAuth.getUser(user2_UID);
		// positive test
		assertFalse(user2.getCustomClaims().containsKey(doctorStr));
	}
        
	@Test
	@Order(2)
	public void removeInvalidRoleNegativeTest() throws FirebaseAuthException{
        try {
			roleService.removeRole(user2_UID, "invalid-input");
			
		} catch (Exception e) {
            // negative test
            assertEquals(e.getMessage(), "Invalid Application role, Allowed roles => "
			+ securityProps.getValidApplicationRoles().toString());
		}
	}

	@Test
	@Order(2)
	public void removeInvalidUserIDNegativeTest() throws FirebaseAuthException{
        try {
			roleService.removeRole(user7_UID, nurseStr);
		} catch (Exception e) {
            // negative test
            assertEquals(e.getMessage(), "Invalid UID");
		}
	}


	/**
	 * Testing SecurityService
	 */

	 @Test
	 @Order(3)
	 public void getAuthenticatedUserPositiveTest() {
		AuthUserDTO authUser = new AuthUserDTO();
		authUser.setUid(user1_UID);
		Credentials credentials = new Credentials(
			Credentials.CredentialType.SESSION,
			null,
			null,
			null
		);
		UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
			authUser, credentials, null
		);
		SecurityContextHolder.getContext().setAuthentication(auth);
	
		assertEquals(securityService.getUser(), authUser);
	}

	@Test
	@Order(3)
	public void getAuthenticatedUserNegativeTest(){
		assertEquals(securityService.getUser(), null);
	}

	@Test
	@Order(3)
	public void getCredentialsPositiveTest() {
	   AuthUserDTO authUser = new AuthUserDTO();
	   authUser.setUid(user1_UID);
	   Credentials credentials = new Credentials(
		   Credentials.CredentialType.SESSION,
		   null,
		   null,
		   null
	   );
	   UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
		   authUser, credentials, null
	   );
	   SecurityContextHolder.getContext().setAuthentication(auth);
   
	   assertEquals(securityService.getCredentials(), credentials);
   }

   @Test
   @Order(3)
   public void getCredentialsNegativeTest(){
	   assertEquals(securityService.getCredentials(), null);
   }


   @Test
   @Order(3)
   public void getBearerTokenPositiveTest(){
		MockHttpServletRequest mockRequest = new MockHttpServletRequest();
		mockRequest.addHeader("Authorization", "Bearer jnOINOINoIICN3eno6ciN#()#(NF)");

	   assertEquals(securityService.getBearerToken(mockRequest), "jnOINOINoIICN3eno6ciN#()#(NF)");
   }

   @Test
   @Order(3)
   public void getBearerTokenNullNegativeTest(){
		MockHttpServletRequest mockRequest = new MockHttpServletRequest();

	   assertEquals(securityService.getBearerToken(mockRequest), null);
   }


}
