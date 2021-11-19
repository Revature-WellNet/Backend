package com.revature.controllers;

import com.revature.services.RoomService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/room")
public class RoomController {
    
    private RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService){
        super();
        this.roomService = roomService;
    }

}
