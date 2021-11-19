package com.revature.security.models;


import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("private")
public class AuthTestController {

    @GetMapping("user-details")
    public ResponseEntity<AuthUser> getUserInfo(@AuthenticationPrincipal AuthUser user) {
    	System.out.println("user: " + user.getEmail());
        return ResponseEntity.ok(user);
    }

}
