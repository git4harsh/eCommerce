package com.peronal.project.ecomApp.ecomPrj.demoMappedSuperClass;
import jakarta.persistence.Entity;

@Entity(name = "mps_it")
public class Instructor extends User{
    private String specialisation;

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }
}
