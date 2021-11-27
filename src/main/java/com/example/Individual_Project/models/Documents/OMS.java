package com.example.Individual_Project.models.Documents;

import com.example.Individual_Project.models.People.Worker;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "oms")
public class OMS {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long oms_id;

    @Pattern(regexp = "\\d{16}",
            message = "Номер ОМС должен содержать 16 цифр")
    private String omsNum;

    private String expireDate;

    @OneToOne(mappedBy = "oms")
    private Worker owner;

    public OMS() {
    }

    public OMS(String omsNum, String expireDate) {
        this.omsNum = omsNum;
        this.expireDate = expireDate;
    }

    public Long getId() {
        return oms_id;
    }

    public void setId(Long id) {
        this.oms_id = id;
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
