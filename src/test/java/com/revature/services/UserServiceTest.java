package com.revature.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.nio.file.attribute.FileAttributeView;
import java.util.ArrayList;
import java.util.List;

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

import com.revature.models.Role;
import com.revature.models.User;
import com.revature.repos.UserDAO;
import com.revature.services.UserService;

@ExtendWith({MockitoExtension.class})
class UserServiceTest {

	@InjectMocks
	UserService userService;
	
	@Mock
	private UserDAO userDAO;
	
	@Before
	public void beforeAll() throws Exception {
		MockitoAnnotations.openMocks(this);
	}

	

	

	@Test
	void testUserService() {
//		fail("Not yet implemented");
	}

	@Test
	void testAddOrUpdateUser() {
//		fail("Not yet implemented");
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
//		fail("Not yet implemented");
	}

	@Test
	void testDeleteUser() {
//		fail("Not yet implemented");
	}

	@Test
	void testFindAllPatients() {
//		fail("Not yet implemented");
	}

	@Test
	void testAddOrUpdateRole() {
//		fail("Not yet implemented");
	}

	@Test
	void testGetDoctorPatientData() {
//		fail("Not yet implemented");
	}

}
