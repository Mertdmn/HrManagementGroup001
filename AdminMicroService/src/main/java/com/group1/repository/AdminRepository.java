package com.group1.repository;


import com.group1.repository.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin,Long> {
    Optional<Admin> findOptionalByEmailAndPassword(String email, String password);


    Optional<Admin> findOptionalById(Long id);
}
