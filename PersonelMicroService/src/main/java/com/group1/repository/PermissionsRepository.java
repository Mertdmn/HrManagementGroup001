package com.group1.repository;


import com.group1.repository.entity.Permissions;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PermissionsRepository extends MongoRepository<Permissions,String> {
}
