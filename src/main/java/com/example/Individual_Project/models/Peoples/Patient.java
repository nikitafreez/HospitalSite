package com.example.Individual_Project.models.Peoples;

import com.example.Individual_Project.models.Documents.OMS;
import com.example.Individual_Project.models.Documents.Passport;

import javax.persistence.*;

@Entity
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "passport_id")
    private Passport passport;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "oms_id")
    private OMS oms;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public OMS getOms() {
        return oms;
    }

    public void setOms(OMS oms) {
        this.oms = oms;
    }

    public Patient(Passport passport, OMS oms) {
        this.passport = passport;
        this.oms = oms;
    }

    public Patient() {
    }
}
