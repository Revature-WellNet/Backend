package com.revature.security.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.revature.security.models.SecurityProperties;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RoleService {
	@Autowired
	FirebaseAuth firebaseAuth;
	
	@Autowired
	private SecurityProperties securityProps;
	
	public void addRole(String uid, String role) throws Exception {
		try {
			UserRecord user = firebaseAuth.getUser(uid);

			Map<String, Object> claims = new HashMap<>();
			user.getCustomClaims().forEach((k, v) -> claims.put(k, v));
			if (securityProps.getValidApplicationRoles().contains(role)) {
				if (!claims.containsKey(role)) {
					claims.put(role, true);
				}
				firebaseAuth.setCustomUserClaims(uid, claims);
			} else {
				throw new Exception("Invalid Application role, Allowed roles => "
						+ securityProps.getValidApplicationRoles().toString());
			}

		} catch (IllegalArgumentException | FirebaseAuthException e) {
			throw new Exception("Invalid UID");
		}
	}

	/**
	 * This method is only used for testing
	 * @param uid
	 * @param role
	 */
	public void removeRole(String uid, String role) throws Exception{
		try {
			UserRecord user = firebaseAuth.getUser(uid);
			Map<String, Object> claims = new HashMap<>();
			user.getCustomClaims().forEach((k, v) -> claims.put(k, v));	
			if (securityProps.getValidApplicationRoles().contains(role)) {
				if (claims.containsKey(role)) {
					claims.remove(role);
				}
				firebaseAuth.setCustomUserClaims(uid, claims);
			} else {
				throw new Exception("Invalid Application role, Allowed roles => "
						+ securityProps.getValidApplicationRoles().toString());
			}		
		} catch (IllegalArgumentException | FirebaseAuthException e) {
			throw new Exception("Invalid UID");
		}

	}
}
