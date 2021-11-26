package com.example.Individual_Project.models.Documents;

import com.example.Individual_Project.models.People.Worker;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "oms")
public class OMS {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Pattern(regexp = "\\d{16}",
            message = "Номер ОМС должен содержать 16 цифр")
    private String omsNum;

    private String expireDate;

    @OneToOne(optional = false, mappedBy = "oms")
    private Worker owner;

    public OMS() {
    }

    public OMS(String omsNum, String expireDate) {
        this.omsNum = omsNum;
        this.expireDate = expireDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOmsNum() {
        return omsNum;
    }

    public void setOmsNum(String omsNum) {
        this.omsNum = omsNum;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public Worker getOwner() {
        return owner;
    }

    public void setOwner(Worker owner) {
        this.owner = owner;
    }
}
