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
    private String callAddress;

    private String callDate;

    @Size(max = 150, message = "Описание вызова должно содержать до 150 символов")
    private String callDescription;

    @ManyToOne(optional = false, cascade = CascadeType.DETACH)
    @JoinColumn(name = "ambulance_car_id")
    private Ambulance_car ambulance_car;

    public Ambulance_call(String callAddress, String callDate, String callDescription, Ambulance_car ambulance_car) {
        this.callAddress = callAddress;
        this.callDate = callDate;
        this.callDescription = callDescription;
        this.ambulance_car = ambulance_car;
    }

    public Ambulance_call() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCallAddress() {
        return callAddress;
    }

    public void setCallAddress(String callAddress) {
        this.callAddress = callAddress;
    }

    public String getCallDate() {
        return callDate;
    }

    public void setCallDate(String callDate) {
        this.callDate = callDate;
    }

    public String getCallDescription() {
        return callDescription;
    }

    public void setCallDescription(String callDescription) {
        this.callDescription = callDescription;
    }

    public Ambulance_car getAmbulance_car() {
        return ambulance_car;
    }

    public void setAmbulance_car(Ambulance_car ambulanceCar) {
        this.ambulance_car = ambulanceCar;
    }
}
