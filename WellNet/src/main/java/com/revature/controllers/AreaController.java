package com.revature.controllers;

import com.revature.services.AreaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/area")
public class AreaController {
    
    private AreaService areaService;

    @Autowired
    public AreaController(AreaService areaService){
        super();
        this.areaService = areaService;
    }

}
