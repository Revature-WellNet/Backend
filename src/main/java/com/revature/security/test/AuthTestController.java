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
@RequestMapping("private") //name of mapping must not be "public" in order to be flagged for authentication
public class AuthTestController {
	
	@Autowired
	RoleService roleService;

	@GetMapping("test")
    ResponseEntity<String> getPublic(@AuthenticationPrincipal AuthUserDTO user) {
        return ResponseEntity.ok("OK");
    }
	
    @GetMapping("nurse-details")
    @IsNurse //Add this annotation if you want to lock controller functions to particular roles
             //not hooked up with registration yet so (don't do it yet)
    public ResponseEntity<AuthUserDTO> getNurseInfo(@AuthenticationPrincipal AuthUserDTO user) //Add in your @RequestBody (i.e, @RequestBody Nurse nurse) as needed
    {
    	System.out.println("is a nurse!");
    	return ResponseEntity.status(200).build();
    }
    
    //@GetMapping("nurse")
    //public ResponseEntity<Nurse> getLoggedInNurseInfo(@AuthenticationPrincipal AuthUserDTO user)
    //{
    //  Nurse nurse = userService.findNurseByUid(user.getUid()); 
	//  if(nurse != null)
	//     return ResponseEntity.ok(nurse);
	//  else
	//     return ResponseEntity.status(404).build();
    //{
    
    //@PostMapping("nurse")
    //public ResponseEntity<Nurse> addNurse(@AuthenticationPrincipal AuthUserDTO user, @RequestBody UserAccount account)
    //{ 
    //  if(!user.getUid().equals(account.getUid())) return ResponseEntity.status(403).build(); <- checks and makes sure that user is going to update themselves and not another nurse 
    //  if(account.getRole() != NURSE) return ResponseEntity.status(403).build();
    //  userService.addAccount(account);
    //  roleService.addRole(account.getUid(), RoleConstants.ROLE_NURSE);
	//  return ResponseEntity.status(200).build();
    //{
    
    //@PutMapping("nurse")
    //public ResponseEntity<Nurse> updateLoggedInNurseInfo(@AuthenticationPrincipal AuthUserDTO user, @RequestBody Nurse updatedNurse)
    //{
    //  Nurse nurse = userService.findNurseByUid(user.getUid()); 
	//  if(nurse == null) return ResponseEntity.status(404).build();  
    //  if(nurse.getUid().equals(updatedNurse.getUid())) <- checks and makes sure that user is going to update themselves and not another nurse 
    //     userService.updateNurse(updatedNurse);
	//     return ResponseEntity.status(200).build();
	//  else
	//     return ResponseEntity.status(403).build();
    //{
	
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
  
}
