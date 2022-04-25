package com.revature.roomservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Area {
    
    @Id
//    @GeneratedValue(strategy=GenerationType.IDENTITY)
//    @Column(name = "area_id")
    private int areaId;
    @Column(unique = true, nullable = false)
    private String name;
    @OneToOne
    private User doctor;

    public Area(int id, String name, User doctor){
        this.areaId = id;
        this.name = name;
        this.doctor = doctor;
    }

    public Area(){}

    public int getId(){
        return this.areaId;
    }

    public void setId(int id){
        this.areaId = id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public User getDoctor(){
        return this.doctor;
    }

    public void setDoctor(User doctor){
        this.doctor = doctor;
    }
    
    public String toString(){
        return "Id: " + this.areaId + ", name: " + this.name + ", doctor: " + this.doctor;
    }

}
