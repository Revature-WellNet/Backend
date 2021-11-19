package com.revature.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Role;
import com.revature.models.User;
import com.revature.repos.RoleDAO;
import com.revature.repos.UserDAO;

@Service
public class UserService {
	
	private UserDAO userDAO;
	private RoleDAO roleDAO;
	
	@Autowired
	public UserService(UserDAO userDAO, RoleDAO roleDAO){
		super();
		this.userDAO = userDAO;
		this.roleDAO = roleDAO;
	}
	
	public void addOrUpdateUser(User user) {
		
		System.out.println("Adding User : " + user);
		
		roleDAO.save(user.getRole());
		userDAO.save(user);
	}
	
	public List<User> findAllUsers(){
		return userDAO.findAll();
	}
	
	public Optional<User> findById(int id) {
		return userDAO.findById(id);
	}
	
	
	public void deleteUser(int id) {
		User user = findById(id).get();
		if(user!=null) {
			userDAO.delete(user);
//			return true;		
		}else {
//			return false;
		}
	}
	
	public void addOrUpdateRole(Role role) {
		roleDAO.save(role);
	}
	
}
