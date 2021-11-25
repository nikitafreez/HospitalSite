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
    private String oms_num;

    private String expire_date;

    @OneToOne(optional = false, mappedBy = "oms")
    private Worker owner;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOms_num() {
        return oms_num;
    }

    public void setOms_num(String oms_num) {
        this.oms_num = oms_num;
    }

    public String getExpire_date() {
        return expire_date;
    }

    public void setExpire_date(String expire_date) {
        this.expire_date = expire_date;
    }

    public OMS(String oms_num, String expire_date) {
        this.oms_num = oms_num;
        this.expire_date = expire_date;
    }

    public OMS() {
    }

    public Worker getOwner() {
        return owner;
    }

    public void setOwner(Worker owner) {
        this.owner = owner;
    }
}
