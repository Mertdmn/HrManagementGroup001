package com.group1.repository;


import com.group1.repository.entity.Items;
import com.group1.repository.entity.Spending;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpendingRepository extends JpaRepository<Spending,Long> {
    Optional<Spending> findOptionalById(Long id);
}
