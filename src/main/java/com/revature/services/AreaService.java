package com.revature.services;

import java.util.List;
import java.util.NoSuchElementException;

import com.revature.models.Area;
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
    
    public List<Area> findAll(){
        return this.areaRepo.findAll();
    }

    public Area findById(int id){
        try{
            return areaRepo.findById(id).get();
        } catch (NoSuchElementException e){
            e.printStackTrace();
            return null;
        }
    }
}
