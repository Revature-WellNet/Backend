package com.revature.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Entity
@Component
public class BloodType {

    @Id
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int typeId;
    private String type;

    public BloodType(int typeId, String type) {
        this.typeId = typeId;
        this.type = type;
    }

    public BloodType() {
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BloodType bloodType = (BloodType) o;
        return typeId == bloodType.typeId && Objects.equals(type, bloodType.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeId, type);
    }

    @Override
    public String toString() {
        return "BloodType{" +
                "typeId=" + typeId +
                ", type='" + type + '\'' +
                '}';
    }
}
