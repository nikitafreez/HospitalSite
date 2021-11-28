package com.example.Individual_Project.Repo.Medicine;

import com.example.Individual_Project.models.Medicine.Disease;
import com.example.Individual_Project.models.Medicine.Treatment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreatmentRepository extends CrudRepository<Treatment, Long> {

}
