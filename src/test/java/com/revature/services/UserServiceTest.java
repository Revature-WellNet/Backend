package com.revature.services;

import static org.junit.Assert.assertEquals;
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


import com.revature.models.Role;
import com.revature.models.User;

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

//	@Test
//	void testFindAllPatients() {
////		fail("Not yet implemented");
//		// already in PatientService. 
//	}

	



}
