package com.example.Individual_Project.Repo.Documents;

import com.example.Individual_Project.models.Documents.Passport;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PassportRepository extends CrudRepository<Passport, Long> {
    List<Passport> findByPassNumAndPassSeria(String passNum, String passSeria);
    List<Passport> findBySecondName(String secondName);
    Passport findByPassSeriaAndPassNum(String passSeria, String passNum);
}
