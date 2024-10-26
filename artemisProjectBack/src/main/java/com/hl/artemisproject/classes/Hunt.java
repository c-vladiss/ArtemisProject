package com.hl.artemisproject.classes;

import com.hl.artemisproject.interfaces.IHunt;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;


// a hunt will be the hiring process from the applicants point of view ( stage of the process, log of interviews etc
// a hunt can only have 1 pray and a hunter.
@Entity
public class Hunt implements IHunt {
    @Id
    @GeneratedValue
    private long huntId;
    private String huntName;
    @OneToOne
    @JoinColumn(name = "prey_id")
    private Prey prey;
    @OneToOne
    @JoinColumn( name = "hunter_id")
    private Hunter hunter;
    private HuntState huntState;
    public Hunt(Prey prey, HuntState huntState) {}


    public Hunt() {

    }

    public Prey getPrey() {
        return prey;
    }
    public HuntState getHuntState() {
        return huntState;
    }
    public void setPrey(Prey prey) {
        this.prey = prey;
    }
    public void setHuntState(HuntState huntState) {
        this.huntState = huntState;
    }

}
