package com.example.Individual_Project.models.Ambulance;

import com.example.Individual_Project.models.People.Worker;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity
@Table(name = "ambulance_car")
public class Ambulance_car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Pattern(regexp = "^[АВЕКМНОРСТУХ]\\d{3}(?<!000)[АВЕКМНОРСТУХ]{2}",
            message = "Введите корректный номер машины")
    @NotNull(message = "Номер автомобиля не может быть пустым")
    @NotEmpty(message = "Номер автомобиля не может быть пустым")
    private String ambulanceCarNum;

    @NotNull(message = "Модель автомобиля не может быть пустой")
    @NotEmpty(message = "Модель автомобиля не может быть пустой")
    @Size(min = 1, max = 20, message = "Модель автомобиля должна содержать от 1 до 20 символов")
    private String carModel;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "worker_id")
    private Worker worker;

    @OneToMany(mappedBy = "ambulance_car", fetch = FetchType.EAGER)
    private Collection<Ambulance_call> ambulance_calls;

    public Ambulance_car(String ambulanceCarNum, String carModel, Worker worker) {
        this.ambulanceCarNum = ambulanceCarNum;
        this.carModel = carModel;
        this.worker = worker;
    }

    public Ambulance_car() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAmbulanceCarNum() {
        return ambulanceCarNum;
    }

    public void setAmbulanceCarNum(String ambulance_carNum) {
        this.ambulanceCarNum = ambulance_carNum;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public Collection<Ambulance_call> getAmbulance_calls() {
        return ambulance_calls;
    }

    public void setAmbulance_calls(Collection<Ambulance_call> ambulance_calls) {
        this.ambulance_calls = ambulance_calls;
    }
}
