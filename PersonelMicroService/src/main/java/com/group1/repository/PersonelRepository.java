package com.group1.repository;


import com.group1.dto.response.PersonelResponseDto;
import com.group1.dto.response.ShowResponseDto;
import com.group1.repository.entity.Personel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PersonelRepository extends MongoRepository<Personel,String> {
   Optional<Personel> findOptionalByEmailAndPassword(String email, String password);


   Optional<Personel> findById(String id);
   ShowResponseDto findAllBy(ShowResponseDto dto);


   @Query("SELECT new com.group1.dto.response.ManagerResponseDto(" +
           "p.name, p.secondName, p.surname, p.secondSurname, p.TCNo, " +
           "p.email, p.phone, p.photo, p.company, p.placeOfBirth, " +
           "p.dateOfBirth, p.hiringDate, p.dismissalDate, p.department, " +
           "p.address, p.title, p.salary, p.role, p.state) " +
           "FROM Personel p WHERE p.id = :personelId")
   PersonelResponseDto findPersonelDetails(@Param("personelId") String personelId);
}
