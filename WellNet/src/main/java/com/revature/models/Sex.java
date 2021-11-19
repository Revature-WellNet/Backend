package com.revature.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Entity
@Component
public class Sex {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sexId;
    private String sex;

    public Sex(int sexId, String sex) {
        this.sexId = sexId;
        this.sex = sex;
    }

    public Sex() {
    }

    public int getSexId() {
        return sexId;
    }

    public void setSexId(int sexId) {
        this.sexId = sexId;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sex sex1 = (Sex) o;
        return sexId == sex1.sexId && Objects.equals(sex, sex1.sex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sexId, sex);
    }

    @Override
    public String toString() {
        return "Sex{" +
                "sexId=" + sexId +
                ", sex='" + sex + '\'' +
                '}';
    }
}
