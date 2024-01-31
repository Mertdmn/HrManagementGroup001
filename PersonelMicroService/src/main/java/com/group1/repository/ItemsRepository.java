package com.group1.repository;


import com.group1.repository.entity.Items;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsRepository extends JpaRepository<Items,Long> {
}
