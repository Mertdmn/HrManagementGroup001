package com.group1.repository;

import com.group1.repository.entity.Advance;
import com.group1.repository.entity.BreaksAndShifts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BreaksAndShiftsRepository extends JpaRepository<BreaksAndShifts,Long> {
    Optional<BreaksAndShifts> findOptionalById(Long id);
}
