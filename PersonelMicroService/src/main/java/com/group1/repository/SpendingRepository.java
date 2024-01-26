package com.group1.repository;


import com.group1.repository.entity.Spending;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SpendingRepository extends MongoRepository<Spending,String> {
}
