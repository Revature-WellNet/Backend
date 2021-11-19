package com.revature.services;

import com.revature.repositories.RoomRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

    private RoomRepo RoomRepo;

    @Autowired
    public RoomService(RoomRepo RoomRepo){
        super();
        this.RoomRepo = RoomRepo;
    }
    
}
