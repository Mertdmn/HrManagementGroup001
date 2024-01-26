package com.group1.repository;

import com.group1.repository.entity.BreaksAndShifts;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BreaksAndShiftsRepository extends MongoRepository<BreaksAndShifts,String> {
}
