package com.peronal.project.ecomApp.ecomPrj.demoMappedSuperClass;

import jakarta.persistence.Entity;

@Entity(name = "mps_ta")
public class TA extends User{

    private float noOfSessions;
    private float rating;
}
