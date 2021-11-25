package com.example.Individual_Project.models.Position;

import com.example.Individual_Project.models.People.Worker;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Entity
@Table(name = "position")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Название должности не должно быть пустым")
    @NotEmpty(message = "Название должности не должно быть пустым")
    private String position_name;

    @Min(value = 12000)
    private Float position_salary;

    @OneToMany(mappedBy = "position", fetch = FetchType.EAGER)
    private Collection<Worker> workers;

    public Position(String position_name, Float position_salary) {
        this.position_name = position_name;
        this.position_salary = position_salary;
    }

    public Position() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPosition_name() {
        return position_name;
    }

    public void setPosition_name(String position_name) {
        this.position_name = position_name;
    }

    public Float getPosition_salary() {
        return position_salary;
    }

    public void setPosition_salary(Float position_salary) {
        this.position_salary = position_salary;
    }

    public Collection<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(Collection<Worker> workers) {
        this.workers = workers;
    }
}
