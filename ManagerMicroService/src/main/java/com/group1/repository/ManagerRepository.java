package com.group1.repository;

import com.group1.dto.response.ShowResponseDto;
import com.group1.repository.entity.Manager;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ManagerRepository extends MongoRepository<Manager,String> {
    Optional<Manager> findOptionalByEmailAndPassword(String email, String password);

    ShowResponseDto findAllBy(ShowResponseDto showResponseDto);

    Optional<Manager> findAll(Manager manager1);
}
