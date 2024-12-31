package com.peronal.project.ecomApp.ecomPrj.demoMappedSuperClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "mps_ta")
public class TA extends User{

    private float noOfSessions;
    private float rating;
}
