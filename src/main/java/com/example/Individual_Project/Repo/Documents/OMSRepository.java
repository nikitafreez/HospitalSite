package com.example.Individual_Project.Repo.Documents;

import com.example.Individual_Project.models.Documents.OMS;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OMSRepository extends CrudRepository<OMS, Long> {
    List<OMS> findByOmsNum(String omsNum);
    OMS findOMSByOmsNum(String omsNum);
}
