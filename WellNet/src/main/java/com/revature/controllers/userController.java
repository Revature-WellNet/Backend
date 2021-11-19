package com.revature.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.User;
import com.revature.services.UserService;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class userController {
	
	@Autowired
	private UserService userService;

	@Autowired
	public userController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	


	@GetMapping
	public ResponseEntity<List<User>> findAllUsers(){
		List<User> all = userService.findAllUsers();
		
		if(all.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(all);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable("id") int id ){
		Optional<User> optional = userService.findById(id);
		
		if(optional.isPresent())
		{
			return ResponseEntity.ok(optional.get());
		}
		
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User user){

		String id = user.getId();
		
		if(id != null) {

			return ResponseEntity.badRequest().build();
		}
		
		userService.addOrUpdateUser(user);
		return ResponseEntity.status(201).body(user);
	}
	
	
	
}
