package com.revature.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.nio.file.attribute.FileAttributeView;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

/*import com.revature.models.Allergy;
import com.revature.models.BloodType;
import com.revature.models.DiagnosisForm;
import com.revature.models.Patient;*/
import com.revature.models.Role;
import com.revature.models.Specialization;
/*import com.revature.models.Sex;*/
import com.revature.models.User;
/*import com.revature.models.Vaccination;
import com.revature.repos.PatientDAO;*/
import com.revature.repos.RoleDAO;
import com.revature.repos.UserDAO;
import com.revature.services.UserService;

@ExtendWith({MockitoExtension.class})
class UserServiceTest {

	@InjectMocks
	UserService userService;
	
	@Mock
	private UserDAO userDAO;
	
	@Mock
	private RoleDAO roleDAO;
	
	/*
	 * @Mock private PatientDAO patientDAO;
	 */
	
	@Before
	public void beforeAll() throws Exception {
		MockitoAnnotations.openMocks(this);
	}


	@Test
	void testAddOrUpdateUser() {
        User user1 = new User("1", "firstname", "lastname", "email@em.com", new Role(1, "nurse"));

        userService.addOrUpdateUser(user1);

        verify(userDAO, times(1)).save(user1);
	}

	@Test
	void testFindAllUsers() {
	    List<User> list = new ArrayList<User>();
        User user1 = new User("1", "firstname", "lastname", "email@em.com", new Role(1, "nurse"));
        list.add(user1);
        assertEquals(1, 1);
        when(userDAO.findAll()).thenReturn(list);

        //test
        List<User> favList = userService.findAllUsers();
        Assertions.assertEquals(1, favList.size());

        verify(userDAO, times(1)).findAll();
	}
	
	@Test
	void testFindByUserId() {
        User user1 = new User("1", "firstname", "lastname", "email@em.com", new Role(1, "nurse"));
        when(userDAO.findByUserId("1")).thenReturn(java.util.Optional.of(user1));

        User returnedUser = userService.findByUserId("1").get();
        assertTrue(returnedUser.getFirstname().equals("firstname"));
	}

	@Test
	void testDeleteUser() {
        User user1 = new User("1", "firstname", "lastname", "email@em.com", new Role(1, "nurse"));
        when(userDAO.findByUserId("1")).thenReturn(java.util.Optional.of(user1));

        userService.addOrUpdateUser(user1);
        userService.deleteUser("1");
        
        verify(userDAO, times(1)).delete(user1);
	}
	
	@Test
	void testAddOrUpdateRole() {
		Role role = new Role(1, "nurse");

        userService.addOrUpdateRole(role);;

        verify(roleDAO, times(1)).save(role);
	}

	@Test
	void testEqualsTrue() {
		User sixConstructor = new User("abc","Bob","Jones","BobJones@gmail.com", new Role(1, "nurse"), Specialization.Radiologist);
		User sixConstructorCopy = new User("abc","Bob","Jones","BobJones@gmail.com", new Role(1, "nurse"), Specialization.Radiologist);
		assertTrue(sixConstructor.equals(sixConstructorCopy));
	}
	
	@Test
	void testEqualsFalse() {
		User sixConstructor = new User("abc","Bob","Jones","BobJones@gmail.com", new Role(1, "nurse"), Specialization.Radiologist);
		User sixConstructorBadCopy = new User("abcd","Bob","Jones","BobJones@gmail.com", new Role(1, "nurse"), Specialization.Radiologist);
		assertFalse(sixConstructor.equals(sixConstructorBadCopy));
	}
	@Test
	void testId()
	{
		User myUser = new User();
		myUser.setId("Hi");
		assertTrue("Hi" == myUser.getId());
	}
	@Test
	void testFirstname()
	{
		User myUser = new User();
		myUser.setFirstname("Hi");
		assertTrue("Hi" == myUser.getFirstname());
	}
	@Test
	void testLastname()
	{
		User myUser = new User();
		myUser.setLastname("Hi");
		assertSame("Hi",myUser.getLastname());
	}
	@Test
	void testEmail()
	{
		User myUser = new User();
		myUser.setEmail("Hi");
		assertSame("Hi", myUser.getEmail());
	}
	@Test
	void testRole()
	{
		User myUser = new User();
		myUser.setRole(new Role(1, "nurse"));
		assertSame(new Role(1, "nurse"), myUser.getRole());
	}
	@Test
	void testSpecialization()
	{
		User myUser = new User();
		myUser.setSpecialization(Specialization.General_Practicioner);
		assertSame(myUser.getSpecialization(), Specialization.General_Practicioner);
	}
	@Test
	void testtoString()
	{
		User fourArgUser = new User("Bob", "Jones", "BobJones@gmail.com", new Role(1, "nurse"));
		fourArgUser.setId("abc");
		fourArgUser.setSpecialization(Specialization.Pediatrician);
		assertSame(fourArgUser.toString(), "User [userId=" + "abc" + ", firstname=" + "Bob" + ", lastname=" + "Jones" + ", email=" + "BobJones@gmail.com"
				+ ", role=" + new Role(1,"nurse") + ", specialization=" + Specialization.Pediatrician + "]");
	}
//	@Test
//	void testFindAllPatients() {
////		fail("Not yet implemented");
//		// already in PatientService. 
//	}

	

	/*
	 * @Test void testGetDoctorPatientData() { // User user1 = new User("1",
	 * "firstname", "lastname", "email@em.com", new Role(2, "doctor"));
	 * 
	 * // SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	 * Date date = null; Patient patient = new Patient(1, "patientName",
	 * "PatientLastname", date, 6.0, 150.0, new BloodType(), new Sex(), new
	 * ArrayList<Allergy>(), new ArrayList<Vaccination>(),new
	 * ArrayList<DiagnosisForm>()); List<Patient> list = new ArrayList<>();
	 * list.add(patient); Optional<List<Patient>> optionalList = Optional.of(list);
	 * when(patientDAO.matchDoctorToUser("firstName",
	 * "lastName")).thenReturn(optionalList);
	 * assertTrue(userService.getDoctorPatientData("firstName",
	 * "lastName").get().get(0).getFirstName().equals("patientName")); }
	 */

}
