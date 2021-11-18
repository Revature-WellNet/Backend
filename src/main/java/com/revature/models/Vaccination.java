package com.revature.models;

import org.springframework.stereotype.Component;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Component
public class Vaccination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vaccinationId;
    private String vaccination;

    public Vaccination(int vaccinationId, String vaccination) {
        this.vaccinationId = vaccinationId;
        this.vaccination = vaccination;
    }

    public Vaccination() {
    }

    public int getVaccinationId() {
        return vaccinationId;
    }

    public void setVaccinationId(int vaccinationId) {
        this.vaccinationId = vaccinationId;
    }

    public String getVaccination() {
        return vaccination;
    }

    public void setVaccination(String vaccination) {
        this.vaccination = vaccination;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vaccination that = (Vaccination) o;
        return vaccinationId == that.vaccinationId && Objects.equals(vaccination, that.vaccination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vaccinationId, vaccination);
    }

    @Override
    public String toString() {
        return "Vaccination{" +
                "vaccinationId=" + vaccinationId +
                ", vaccination='" + vaccination + '\'' +
                '}';
    }
}
