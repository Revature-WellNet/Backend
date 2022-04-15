package com.revature.controllers;

import java.util.List;

import com.revature.models.Area;
import com.revature.services.AreaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping
    public List<Area> allAreas(){
        return areaService.findAll();
    }

    @GetMapping("/{id}")
    public Area findById(@PathVariable("id") int id){
        return areaService.findById(id);
    }

}
