package com.example.Individual_Project.Repo;

import com.example.Individual_Project.models.authModels.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
