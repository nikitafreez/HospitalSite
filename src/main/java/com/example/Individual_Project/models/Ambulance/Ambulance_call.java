package com.example.Individual_Project.models.Ambulance;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "ambulance_call")
public class Ambulance_call {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Адрес вызова не может быть пустым")
    @NotEmpty(message = "Адрес вызова не может быть пустым")
    @Size(min = 1, max = 100, message = "Адрес вызова должен содержать от 5 до 100 символов")
    private String call_address;

    private String call_date;

    @Size(max = 150, message = "Описание вызова должно содержать до 150 символов")
    private String call_description;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "ambulance_car_id")
    private Ambulance_car ambulance_car;

    public Ambulance_call(String call_address, String call_date, String call_description, Ambulance_car ambulance_car) {
        this.call_address = call_address;
        this.call_date = call_date;
        this.call_description = call_description;
        this.ambulance_car = ambulance_car;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCall_address() {
        return call_address;
    }

    public void setCall_address(String call_address) {
        this.call_address = call_address;
    }

    public String getCall_date() {
        return call_date;
    }

    public void setCall_date(String call_date) {
        this.call_date = call_date;
    }

    public String getCall_description() {
        return call_description;
    }

    public void setCall_description(String call_description) {
        this.call_description = call_description;
    }

    public Ambulance_car getAmbulance_car() {
        return ambulance_car;
    }

    public void setAmbulance_car(Ambulance_car ambulance_car) {
        this.ambulance_car = ambulance_car;
    }
}
