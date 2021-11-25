package com.example.Individual_Project.models.People;

import com.example.Individual_Project.models.Documents.OMS;
import com.example.Individual_Project.models.Documents.Passport;
import com.example.Individual_Project.models.Position.Position;

import javax.persistence.*;

@Entity
@Table(name = "worker")
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "passport_id")
    private Passport passport;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "oms_id")
    private OMS oms;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "position_id")
    private Position position;

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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Worker(Passport passport, OMS oms, Position position) {
        this.passport = passport;
        this.oms = oms;
        this.position = position;
    }

    public Worker() {
    }
}
