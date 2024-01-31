package com.group1.repository;


import com.group1.repository.entity.Spending;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpendingRepository extends JpaRepository<Spending,Long> {
}
