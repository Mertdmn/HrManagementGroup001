package com.group1.repository;


import com.group1.repository.entity.Permissions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionsRepository extends JpaRepository<Permissions,Long> {
}
