package com.peronal.project.ecomApp.ecomPrj.demoMappedSuperClass;

import jakarta.persistence.Entity;

@Entity(name = "mps_me")
public class Mentor extends User{
    private String compName;
    private double avgRating;

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public double getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(double avgRating) {
        this.avgRating = avgRating;
    }
}
