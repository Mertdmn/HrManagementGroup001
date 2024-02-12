package com.group1.repository;


import com.group1.repository.entity.Advance;
import com.group1.repository.entity.Items;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemsRepository extends JpaRepository<Items,Long> {
    Optional<Items> findOptionalById(Long id);
}
