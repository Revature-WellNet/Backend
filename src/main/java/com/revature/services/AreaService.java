package com.revature.services;

import com.revature.repos.AreaRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AreaService {

    private AreaRepo areaRepo;

    @Autowired
    public AreaService(AreaRepo areaRepo){
        super();
        this.areaRepo = areaRepo;
    }
    
}
