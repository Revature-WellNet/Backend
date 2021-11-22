package com.revature.security.models;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("private")
public class AuthTestController {
	
	@Autowired
	RoleService roleService;

    @GetMapping("user-details")
    public ResponseEntity<AuthUser> getUserInfo(@AuthenticationPrincipal AuthUser user) {
    	System.out.println("user: " + user.getEmail());
        return ResponseEntity.ok(user);
    }
    
    @GetMapping("random")
    public ResponseEntity<AuthUser> getRandom(@AuthenticationPrincipal AuthUser user)
    {
    	System.out.println("user: " + user.getUid());
        return ResponseEntity.ok(user);
    }
    
    @PatchMapping("nurse")
    public ResponseEntity<AuthUser> setNurseRole(@AuthenticationPrincipal AuthUser user)
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
    public ResponseEntity<AuthUser> getNurseInfo(@AuthenticationPrincipal AuthUser user)
    {
    	System.out.println("is a nurse!");
    	return ResponseEntity.status(200).build();
    }

}
