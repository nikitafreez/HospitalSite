package com.example.Individual_Project.Repo.Position;

import com.example.Individual_Project.models.Documents.OMS;
import com.example.Individual_Project.models.Documents.Passport;
import com.example.Individual_Project.models.Position.Position;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepository extends CrudRepository<Position, Long> {
    Position findByPositionName(String positionName);
}
