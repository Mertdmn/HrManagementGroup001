package com.group1.repository;


import com.group1.repository.entity.Advance;
import com.group1.repository.entity.Personel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdvanceRepository extends JpaRepository<Advance,Long> {

    Optional<Advance> findOptionalById(Long id);
}
