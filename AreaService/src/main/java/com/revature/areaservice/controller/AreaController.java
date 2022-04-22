package com.revature.areaservice.controller;

import java.util.List;
import java.util.Objects;

import com.revature.areaservice.model.*;
import com.revature.areaservice.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/area")
public class AreaController {
    
    private AreaService areaService;
    private RestTemplate restTemplate;

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
    
    @GetMapping("/name/{name}")
    public Area findbyName(@PathVariable String name) {
    	
    	return areaService.findByName(name);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Area> updateDoctor(@PathVariable("id") int areaId, @RequestBody User doctor) {

    	Area area = areaService.updateDoctor(areaId, doctor);
    	
    	if (Objects.isNull(area)) {
    		
    		return ResponseEntity.noContent().build();
    		
    	}
    	
    	return ResponseEntity.ok(area);
    	
//    	return areaService.updateDoctor(areaId, doctor);
    	
    }
    
}
