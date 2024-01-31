package com.group1.repository;

import com.group1.dto.response.ManagerResponseDto;
import com.group1.dto.response.ShowResponseDto;
import com.group1.repository.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ManagerRepository extends JpaRepository<Manager,Long> {
    Optional<Manager> findOptionalByEmailAndPassword(String email, String password);
    ShowResponseDto findAllBy(ShowResponseDto showResponseDto);

    @Query("SELECT new com.group1.dto.response.ManagerResponseDto(" +
            "m.name, m.secondName, m.surname, m.secondSurname, m.TCNo, " +
            "m.email, m.phone, m.photo, m.company, m.placeOfBirth, " +
            "m.dateOfBirth, m.hiringDate, m.dismissalDate, m.department, " +
            "m.address, m.title, m.salary, m.role, m.state) " +
            "FROM Manager m WHERE m.id = :managerId")
    ManagerResponseDto findManagerDetails(@Param("managerId") String managerId);
}
