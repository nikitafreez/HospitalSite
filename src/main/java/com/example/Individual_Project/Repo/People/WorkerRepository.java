package com.example.Individual_Project.Repo.People;

import com.example.Individual_Project.Repo.Documents.PassportRepository;
import com.example.Individual_Project.models.Documents.Passport;
import com.example.Individual_Project.models.People.Worker;
import com.example.Individual_Project.models.Position.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkerRepository extends CrudRepository<Worker, Long> {
    Worker findByPassport(Passport passport);
}
