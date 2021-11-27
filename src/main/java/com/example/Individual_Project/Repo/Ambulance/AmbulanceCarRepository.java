package com.example.Individual_Project.Repo.Ambulance;

import com.example.Individual_Project.models.Ambulance.Ambulance_car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmbulanceCarRepository extends CrudRepository<Ambulance_car, Long> {
    Ambulance_car findByAmbulanceCarNum(String carNum);
}
