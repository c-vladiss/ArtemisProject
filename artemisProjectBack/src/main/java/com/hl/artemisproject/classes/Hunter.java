package com.hl.artemisproject.classes;

import com.hl.artemisproject.interfaces.IHunter;
import jakarta.persistence.*;

import java.util.*;

@Entity
@Table
public class Hunter implements IHunter, Cloneable {
    @Id
    @SequenceGenerator(
            name = "hunter_index",
            sequenceName = "hunter_index",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "hunterIndex"
    )
    private long hunterId;
    private String hunterName;
    private String hunterMail;
    private String hunterPassword;
    private int numberOfHunts;
    private Date registrationDate;



    public Hunter(String hunterName, String hunterMail, String hunterPassword) {
        this.hunterName = hunterName;
        this.hunterMail = hunterMail;
        this.hunterPassword = hunterPassword;
    }

    public Hunter() {

    }

    public long getHunterId() {
        return hunterId;
    }

    public String getHunterName() {
        return hunterName;
    }
    public String getHunterMail() {
        return hunterMail;
    }

    public void setHunterPassword(String hunterPassword) {
        this.hunterPassword = hunterPassword;
    }

    public void setNumberOfPreys(int numberOfPreys) {
        this.numberOfHunts = numberOfPreys;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hunter hunter = (Hunter) o;
        return hunterId == hunter.hunterId && hunterName.equals(hunter.hunterName) && hunterPassword.equals(hunter.hunterPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hunterId, hunterName, hunterPassword, numberOfHunts);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
