package com.revature.integration;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
public class RoomControllerWebMvcIntegrationTest {
	@Autowired
	private WebApplicationContext context;
	
	private MockMvc mvc;
	
	@Before
	public void setup()
	{
		mvc = MockMvcBuilders
			.webAppContextSetup(context)
			.apply(springSecurity())
			.build();
	}
	
	@WithMockUser()
	@Test
	public void givenAuthGetRooms() throws Exception
	{
		ArrayList<Integer> appropriateStatusCodes = new ArrayList<Integer>(Arrays.asList(200, 204));
		MvcResult result = mvc.perform(get("/room")
				.contentType(MediaType.APPLICATION_JSON))
				.andReturn();
		assertTrue(appropriateStatusCodes.contains(result.getResponse().getStatus()));
	}
	
	@Test
	public void noAuthGetRooms() throws Exception
	{
		mvc.perform(get("/room").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isUnauthorized());
	}
	
	@WithMockUser()
	@Test
	public void givenAuthGetRoomById() throws Exception
	{
		ArrayList<Integer> appropriateStatusCodes = new ArrayList<Integer>(Arrays.asList(200, 204));
		MvcResult result = mvc.perform(get("/room/{id}", 1)
				.contentType(MediaType.APPLICATION_JSON))
				.andReturn();
		assertTrue(appropriateStatusCodes.contains(result.getResponse().getStatus()));
	}
	
	@Test
	public void noAuthGetRoomById() throws Exception
	{
		mvc.perform(get("/room/{id}", 1).contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isUnauthorized());
	}
}
