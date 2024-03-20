package com.group1.repository;


import com.group1.repository.entity.Items;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ItemsRepository extends MongoRepository<Items,String> {
}
