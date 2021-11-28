package com.example.Individual_Project.Repo.People;

import com.example.Individual_Project.models.Documents.Passport;
import com.example.Individual_Project.models.People.Patient;
import com.example.Individual_Project.models.People.Worker;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Long> {
    Patient findByPassport(Passport passport);
}
