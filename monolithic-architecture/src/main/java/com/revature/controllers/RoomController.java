package com.revature.controllers;

import java.util.List;
import java.util.Objects;

import com.revature.models.Room;
import com.revature.services.RoomService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping
    public ResponseEntity<List<Room>> allRooms(){
        List<Room> rooms = roomService.findAll();
        if(rooms.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(rooms);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Room> findById(@PathVariable("id") int id){
        Room room = roomService.findById(id);
        if(Objects.isNull(room)){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(room);
    }

}
