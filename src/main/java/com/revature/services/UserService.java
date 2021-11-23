package com.revature.services;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import com.revature.models.Patient;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.repos.PatientDAO;
import com.revature.repos.RoleDAO;
import com.revature.repos.UserDAO;
import com.revature.security.models.AuthUserDTO;
import com.revature.security.models.TokenHolder;

@Service
public class UserService {
	
	private UserDAO userDAO;
	private RoleDAO roleDAO;
	private PatientDAO patientDAO;
	
	@Autowired
	public UserService(UserDAO userDAO, RoleDAO roleDAO, PatientDAO patientDAO){
		super();
		this.userDAO = userDAO;
		this.roleDAO = roleDAO;
		this.patientDAO = patientDAO;
	}
	
	public void addOrUpdateUser(User user) {
		
		
		
		
		//roleDAO.save(user.getRole());
		userDAO.save(user);
	}
	
	public List<User> findAllUsers(){
		return userDAO.findAll();
	}
	
	public Optional<User> findByUserId(String id) {
		
		return userDAO.findByUserId(id);
	}
	
	
	public void deleteUser(String id) {
		User user = findByUserId(id).get();
		if(user!=null) {
			userDAO.delete(user);
//			return true;		
		}else {
//			return false;
		}
	}
	
	public List<Patient> findAllPatients() {
		
		return patientDAO.findAll();
		
	}
	
	public void addOrUpdateRole(Role role) {
		roleDAO.save(role);
	}

	public void addUsr(TokenHolder tkn) throws FirebaseAuthException {

	AuthUserDTO user= new AuthUserDTO();
		    	FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(tkn.getToken());
		        if (decodedToken != null) {
		            user = new AuthUserDTO();
		            user.setUid(decodedToken.getUid());
		            user.setName(decodedToken.getName());
		            user.setEmail(decodedToken.getEmail());
		            user.setPicture(decodedToken.getPicture());
		            user.setIssuer(decodedToken.getIssuer());
		            user.setEmailVerified(decodedToken.isEmailVerified());
		           
		            
		        }
		       
		    }
		
		
	}
	

