package com.hl.artemisproject.classes;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Prey {
    @Id
    @GeneratedValue
    private long preyId;
    private String preyName;
    private Date preyDate;
    // a prey ( job opening can have 1 or more hunters ( applicants )
    // we will solve the many to many relationship between job aplications and applicants by class hunt

    private long numberOfHunters;
    public Prey() {}




}
