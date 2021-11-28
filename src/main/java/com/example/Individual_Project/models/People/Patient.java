package com.example.Individual_Project.models.People;

import com.example.Individual_Project.models.Documents.OMS;
import com.example.Individual_Project.models.Documents.Passport;
import com.example.Individual_Project.models.Medicine.Treatment;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(optional = false, cascade = CascadeType.DETACH)
    @JoinColumn(name = "passport_id")
    private Passport passport;

    @OneToOne(optional = false, cascade = CascadeType.DETACH)
    @JoinColumn(name = "oms_id")
    private OMS oms;

    @OneToMany(mappedBy = "patient", fetch = FetchType.EAGER)
    private Collection<Treatment> treatments;

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

    public Collection<Treatment> getTreatments() {
        return treatments;
    }

    public void setTreatments(Collection<Treatment> treatments) {
        this.treatments = treatments;
    }
}
