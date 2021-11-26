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
    private String positionName;

    @Min(value = 12000, message = "Зарплата должна быть выше 12 тыс. рублей")
    private Float positionSalary;

    @OneToMany(mappedBy = "position", fetch = FetchType.EAGER)
    private Collection<Worker> workers;

    public Position(String position_name, Float position_salary) {
        this.positionName = position_name;
        this.positionSalary = position_salary;
    }

    public Position() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String position_name) {
        this.positionName = position_name;
    }

    public Float getPositionSalary() {
        return positionSalary;
    }

    public void setPositionSalary(Float position_salary) {
        this.positionSalary = position_salary;
    }

    public Collection<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(Collection<Worker> workers) {
        this.workers = workers;
    }
}
