package com.revature.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Allergy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int allergyId;
    private String allergy;

    public Allergy(int allergyId, String allergy) {
        this.allergyId = allergyId;
        this.allergy = allergy;
    }

    public Allergy() {
    }

    public int getAllergyId() {
        return allergyId;
    }

    public void setAllergyId(int allergyId) {
        this.allergyId = allergyId;
    }

    public String getAllergy() {
        return allergy;
    }

    public void setAllergy(String allergy) {
        this.allergy = allergy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Allergy allergy1 = (Allergy) o;
        return allergyId == allergy1.allergyId && Objects.equals(allergy, allergy1.allergy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(allergyId, allergy);
    }

    @Override
    public String toString() {
        return "Allergy{" +
                "allergyId=" + allergyId +
                ", allergy='" + allergy + '\'' +
                '}';
    }
}
