package com.group1.repository;


import com.group1.repository.entity.Permissions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PermissionsRepository extends JpaRepository<Permissions,Long> {
    Optional<Permissions> findOptionalById(Long aLong);
}
