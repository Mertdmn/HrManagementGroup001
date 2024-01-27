package com.group1.repository;


import com.group1.dto.response.ShowResponseDto;
import com.group1.repository.entity.Personel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PersonelRepository extends MongoRepository<Personel,String> {
   Optional<Personel> findOptionalByEmailAndPassword(String email, String password);


   Optional<Personel> findById(String id);
   ShowResponseDto findAllBy(ShowResponseDto dto);


}
