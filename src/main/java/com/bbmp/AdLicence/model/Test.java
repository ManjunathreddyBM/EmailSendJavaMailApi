package com.bbmp.AdLicence.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Test {

    @Id
    private int id;
    private String name;
    public Test() {}

}
