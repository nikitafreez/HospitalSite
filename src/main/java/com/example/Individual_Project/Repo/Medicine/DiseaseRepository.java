package com.example.Individual_Project.Repo.Medicine;

import com.example.Individual_Project.models.Medicine.Disease;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiseaseRepository extends CrudRepository<Disease, Long> {
    Disease findByDiseaseName(String diseaseName);
}
