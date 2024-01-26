package com.group1.repository;


import com.group1.repository.entity.Advance;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AdvanceRepository extends MongoRepository<Advance,String> {

}
