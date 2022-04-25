package com.revature.areaservice.test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

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
import org.mockito.stubbing.OngoingStubbing;

import com.revature.areaservice.model.Area;
import com.revature.areaservice.model.Role;
import com.revature.areaservice.model.User;
import com.revature.areaservice.repo.AreaRepo;
import com.revature.areaservice.service.AreaService;

@ExtendWith({ MockitoExtension.class })
public class AreaServiceTest {

	@InjectMocks
	AreaService areaService;
	
	@Mock
	private AreaRepo areaRepo;
	
	@Mock
	private User user;
	
	@Mock
	private Role role;
	
	@Before
	public void beforeAll() throws Exception {
		
		MockitoAnnotations.openMocks(this);
		
	}
	
	@Test
	void testFindAll() {
		
		List<Area> areas = new ArrayList<Area>();
		
		Role role1 = new Role(1, "Doctor");
		Role role2 = new Role(2, "Nurse");
		
		User user1 = new User("1", "Doctor", "DoctorLast", "doctor@email.com", role1);
		User user2 = new User("2", "Nurse", "NurseLast", "nurse@email.com", role2);
		
		Area area1 = new Area(1, "Trauma", user1);
		Area area2 = new Area(2, "General Care", user1);
		Area area3 = new Area(3, "Surgery", user2);
		Area area4= new Area(4,"Pediatrics", user2);
		areas.add(area1);
		areas.add(area2);
		areas.add(area3);
		areas.add(area4);
		
		when(areaRepo.findAll()).thenReturn(areas);
		
		List<Area> gotAreas = areaService.findAll();
		
		Assertions.assertEquals(4, gotAreas.size());
		
		verify(areaRepo, times(1)).findAll();
		
	}
	
	@Test
	void testFindById() {
		
		List<Area> areas = new ArrayList<Area>();
		
		Role role1 = new Role(1, "Doctor");
		Role role2 = new Role(2, "Nurse");
		
		User user1 = new User("1", "Doctor", "DoctorLast", "doctor@email.com", role1);
		User user2 = new User("2", "Nurse", "NurseLast", "nurse@email.com", role2);
		
		Area area1 = new Area(1, "Trauma", user1);
		Area area2 = new Area(2, "General Care", user1);
		Area area3 = new Area(3, "Surgery", user2);
		Area area4= new Area(4,"Pediatrics", user2);
		areas.add(area1);
		areas.add(area2);
		areas.add(area3);
		areas.add(area4);
		
		when(areaRepo.findById(3)).thenReturn(java.util.Optional.of(area3));
		
		Area gotArea = areaService.findById(3);
		assertTrue(gotArea.equals(area3));
		
	}
	
	@Test
	void testFindByName() {
		
		List<Area> areas = new ArrayList<Area>();
		
		Role role1 = new Role(1, "Doctor");
		Role role2 = new Role(2, "Nurse");
		
		User user1 = new User("1", "Doctor", "DoctorLast", "doctor@email.com", role1);
		User user2 = new User("2", "Nurse", "NurseLast", "nurse@email.com", role2);
		
		Area area1 = new Area(1, "Trauma", user1);
		Area area2 = new Area(2, "General Care", user1);
		Area area3 = new Area(3, "Surgery", user2);
		Area area4= new Area(4,"Pediatrics", user2);
		areas.add(area1);
		areas.add(area2);
		areas.add(area3);
		areas.add(area4);
		
		when(areaRepo.findByName("General Care")).thenReturn(java.util.Optional.of(area2));
		
		Area gotArea = areaService.findByName("General Care");
		assertTrue(gotArea.equals(area2));
		
	}
	
	
}
