package com.example.Individual_Project.Repo.Ambulance;

import com.example.Individual_Project.models.Ambulance.Ambulance_call;
import com.example.Individual_Project.models.Ambulance.Ambulance_car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmbulanceCallRepository extends CrudRepository<Ambulance_call, Long> {
}
