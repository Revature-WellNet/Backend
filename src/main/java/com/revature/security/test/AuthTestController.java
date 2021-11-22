package com.revature.security.test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.security.models.AuthUserDTO;
import com.revature.security.models.IsNurse;
import com.revature.security.models.RoleConstants;
import com.revature.security.services.RoleService;

@RestController
@RequestMapping("private")
public class AuthTestController {
	
	@Autowired
	RoleService roleService;

    @GetMapping("user-details")
    public ResponseEntity<AuthUserDTO> getUserInfo(@AuthenticationPrincipal AuthUserDTO user) {
    	System.out.println("user: " + user.getEmail()); 	
        return ResponseEntity.ok(user);
    }
    
    @GetMapping("random")
    public ResponseEntity<AuthUserDTO> getRandom(@AuthenticationPrincipal AuthUserDTO user)
    {
    	System.out.println("user: " + user.getUid());
        return ResponseEntity.ok(user);
    }
    
    @PatchMapping("nurse")
    public ResponseEntity<AuthUserDTO> setNurseRole(@AuthenticationPrincipal AuthUserDTO user)
    {
    	try {
        	roleService.addRole(user.getUid(), RoleConstants.ROLE_NURSE);
        	System.out.println("role successfully added!");
        	return ResponseEntity.ok(user);
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    		return ResponseEntity.status(400).build();
    	}
    }
    
    @GetMapping("nurse-details")
    @IsNurse
    public ResponseEntity<AuthUserDTO> getNurseInfo(@AuthenticationPrincipal AuthUserDTO user)
    {
    	System.out.println("is a nurse!");
    	return ResponseEntity.status(200).build();
    }

}
