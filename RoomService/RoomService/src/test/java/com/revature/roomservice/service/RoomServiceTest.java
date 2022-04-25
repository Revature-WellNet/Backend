package com.revature.roomservice.service;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

import com.revature.roomservice.model.Area;
import com.revature.roomservice.model.Patient;
import com.revature.roomservice.model.Role;
import com.revature.roomservice.model.Room;
import com.revature.roomservice.model.User;
import com.revature.roomservice.repo.RoomRepo;

@ExtendWith({ MockitoExtension.class })
public class RoomServiceTest {

	@InjectMocks
	RoomService roomService;

	@Mock
	private RoomRepo roomRepo;

	@Mock
	private Area area;

	@Mock
	private User user;

	@Mock
	private Role role;

	@Mock
	private Patient patient;

	@Before
	public void beforeAll() throws Exception {

		MockitoAnnotations.openMocks(this);

	}

	@Test
	void testFindAll() {

		List<Room> rooms = new ArrayList<Room>();

		Role role1 = new Role();
		role1.setRoleId(1);
		role1.setRole("Doctor");

		Role role2 = new Role();
		role2.setRoleId(2);
		role2.setRole("Nurse");

		User user1 = new User();
		user1.setEmail("gmail.com");
		user1.setFirstname("TestUser1");
		user1.setLastname("TestUser1Last");
		user1.setRole(role1);
		user1.setId("1");

		Patient patient1 = new Patient();
		patient1.setPatientId(1);
		patient1.setFirstName("PatientTest1");
		patient1.setLastName("PatientTest1Last");

		Area area1 = new Area();
		area1.setId(1);
		area1.setName("Trauma");
		area1.setDoctor(user1);

		Room room1 = new Room();
		room1.setArea(area1);
		room1.setDoctor(area1.getDoctor());
		room1.setId(1);
		room1.setRoomNumber(101);
		room1.setPatient(patient1);

		rooms.add(room1);

		Patient patient2 = new Patient();
		patient2.setPatientId(2);
		patient2.setFirstName("TestUser2");
		patient2.setLastName("TestUser2Last");

		Room room2 = new Room();
		room2.setArea(area1);
		room2.setDoctor(area1.getDoctor());
		room2.setRoomNumber(102);
		room2.setId(2);
		room2.setPatient(patient2);

		rooms.add(room2);

		when(roomRepo.findAll()).thenReturn(rooms);

		List<Room> gotRooms = roomService.findAll();

		Assertions.assertEquals(2, gotRooms.size());

		verify(roomRepo, times(1)).findAll();

	}

	@Test
	void testFindById() {

		List<Room> rooms = new ArrayList<Room>();

		Role role1 = new Role();
		role1.setRoleId(1);
		role1.setRole("Doctor");

		Role role2 = new Role();
		role2.setRoleId(2);
		role2.setRole("Nurse");

		User user1 = new User();
		user1.setEmail("gmail.com");
		user1.setFirstname("TestUser1");
		user1.setLastname("TestUser1Last");
		user1.setRole(role1);
		user1.setId("1");

		Patient patient1 = new Patient();
		patient1.setPatientId(1);
		patient1.setFirstName("PatientTest1");
		patient1.setLastName("PatientTest1Last");

		Area area1 = new Area();
		area1.setId(1);
		area1.setName("Trauma");
		area1.setDoctor(user1);

		Room room1 = new Room();
		room1.setArea(area1);
		room1.setDoctor(area1.getDoctor());
		room1.setId(1);
		room1.setRoomNumber(101);
		room1.setPatient(patient1);

		rooms.add(room1);

		when(roomRepo.findById(1)).thenReturn(java.util.Optional.of(room1));

		Room gotRoom = roomService.findById(1);
		assertTrue(gotRoom.getPatient().getFirstName().equals("PatientTest1"));

	}

	@Test
	void testFindByName() {

		List<Room> rooms = new ArrayList<Room>();

		Role role1 = new Role();
		role1.setRoleId(1);
		role1.setRole("Doctor");

		Role role2 = new Role();
		role2.setRoleId(2);
		role2.setRole("Nurse");

		User user1 = new User();
		user1.setEmail("gmail.com");
		user1.setFirstname("TestUser1");
		user1.setLastname("TestUser1Last");
		user1.setRole(role1);
		user1.setId("1");

		Patient patient1 = new Patient();
		patient1.setPatientId(1);
		patient1.setFirstName("PatientTest1");
		patient1.setLastName("PatientTest1Last");

		Area area1 = new Area();
		area1.setId(1);
		area1.setName("Trauma");
		area1.setDoctor(user1);

		Room room1 = new Room();
		room1.setArea(area1);
		room1.setDoctor(area1.getDoctor());
		room1.setId(1);
		room1.setRoomNumber(101);
		room1.setPatient(patient1);

		rooms.add(room1);
		
		Patient patient2 = new Patient();
		patient2.setPatientId(2);
		patient2.setFirstName("TestUser2");
		patient2.setLastName("TestUser2Last");

		Room room2 = new Room();
		room2.setArea(area1);
		room2.setDoctor(area1.getDoctor());
		room2.setRoomNumber(102);
		room2.setId(2);
		room2.setPatient(patient2);

		rooms.add(room2);

		when(roomRepo.findByArea(area1)).thenReturn(rooms);
		
		List<Room> gotRooms = roomService.findByAreaName(area1);
		
		assertTrue(gotRooms.contains(room1));
		
	}
	
	@Test 
	void testFindByDoctor() {
		
		List<Room> rooms = new ArrayList<Room>();

		Role role1 = new Role();
		role1.setRoleId(1);
		role1.setRole("Doctor");

		Role role2 = new Role();
		role2.setRoleId(2);
		role2.setRole("Nurse");

		User user1 = new User();
		user1.setEmail("gmail.com");
		user1.setFirstname("TestUser1");
		user1.setLastname("TestUser1Last");
		user1.setRole(role1);
		user1.setId("1");

		Patient patient1 = new Patient();
		patient1.setPatientId(1);
		patient1.setFirstName("PatientTest1");
		patient1.setLastName("PatientTest1Last");

		Area area1 = new Area();
		area1.setId(1);
		area1.setName("Trauma");
		area1.setDoctor(user1);

		Room room1 = new Room();
		room1.setArea(area1);
		room1.setDoctor(area1.getDoctor());
		room1.setId(1);
		room1.setRoomNumber(101);
		room1.setPatient(patient1);

		rooms.add(room1);
		
		Patient patient2 = new Patient();
		patient2.setPatientId(2);
		patient2.setFirstName("TestUser2");
		patient2.setLastName("TestUser2Last");

		Room room2 = new Room();
		room2.setArea(area1);
		room2.setDoctor(area1.getDoctor());
		room2.setRoomNumber(102);
		room2.setId(2);
		room2.setPatient(patient2);

		rooms.add(room2);

		when(roomRepo.findByDoctor(user1)).thenReturn((rooms));
		
		List<Room> gotRooms = roomService.findByDoctor(user1);
		
		assertTrue(gotRooms.contains(room1));
		
	}
}
