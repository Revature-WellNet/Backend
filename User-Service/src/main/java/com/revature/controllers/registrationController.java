package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.User;
import com.revature.security.models.RoleConstants;
import com.revature.security.services.RoleService;
import com.revature.services.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/public")
public class registrationController {

	@Autowired
	private UserService userService;

	@Autowired
	public registrationController(UserService userService) {
		super();
		this.userService = userService;
	}

	@PostMapping("/registration")
	public ResponseEntity<User> insert(@RequestBody User user) {

		String id = user.getId();

		System.out.println("ID : " + id);
		System.out.println("User : " + user);

		if (id == null) {
			System.out.println("Bad Request");
			return ResponseEntity.badRequest().build();
		}
		System.out.println("Good Request");
		userService.addOrUpdateUser(user);
		return ResponseEntity.status(201).body(user);
	}
}
