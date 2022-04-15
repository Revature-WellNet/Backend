package com.revature.security.test;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.security.models.AuthUserDTO;

@RestController
@RequestMapping("public") //if you want a controller to be publicly accessible, the request mapping MUST start with 'public/{label_here}'
public class TestController {

    @GetMapping("test")
    ResponseEntity<String> getPublic(@AuthenticationPrincipal AuthUserDTO user) {
        return ResponseEntity.ok("OK");
    }
}