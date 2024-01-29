package com.group1.service;


import com.group1.dto.request.LoginPersonelRequestDto;
import com.group1.dto.request.UpdatePersonelRequestDto;
import com.group1.dto.response.PersonelResponseDto;
import com.group1.dto.response.ShowResponseDto;
import com.group1.exception.ErrorType;
import com.group1.exception.PersonelManagerException;
import com.group1.mapper.PersonelMapper;
import com.group1.repository.PersonelRepository;
import com.group1.repository.entity.Personel;
import com.group1.utility.enums.ERole;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonelService {
    private final PersonelRepository personelRepository;

    public static String loginUser="";
    public String getLoginUser() {
        return loginUser;
    }
    public void setLoginUser(String user) {
        loginUser = user;
    }
    public Boolean login(LoginPersonelRequestDto dto) {
        Personel personel1=new Personel();
        personel1.setEmail("abc@hotmail.com");
        personel1.setPassword("123456");
        personelRepository.save(personel1);
        Optional<Personel> personel=personelRepository.findOptionalByEmailAndPassword(dto.getEmail(),dto.getPassword());
        if (personel.isEmpty()||personel.get().getRole()== ERole.DISMISSED){
           throw new PersonelManagerException(ErrorType.LOGIN_ERROR);
        }else {
            loginUser=personel.get().getId();
            return true;
        }
    }


    // personel id bulup spending / advance service üzerinde çağırdık
    public Optional<Personel> findById(String id){
        return personelRepository.findById(id);
    }


    public Optional<Personel> findByIdFromLoginUser() {
        return personelRepository.findById(loginUser);
    }

    public Optional<ShowResponseDto> show() {
        Personel personel = personelRepository.findById(loginUser)
                .orElseThrow(() -> new PersonelManagerException(ErrorType.PERSONEL_NOT_FOUND));
        ShowResponseDto showResponseDto = PersonelMapper.INSTANCE.toShow(personel);
        return Optional.ofNullable(personelRepository.findAllBy(showResponseDto));
    }

    public void update(UpdatePersonelRequestDto dto) {
        // Personel entity'sini bul
        Optional<Personel> existingPersonelOptional = personelRepository.findById(loginUser);

        if (existingPersonelOptional.isPresent()) {
            Personel existingPersonel = existingPersonelOptional.get();

            // Update edilecek alanları güncelle

            existingPersonel.setPhone(dto.getPhone());
            existingPersonel.setAddress(dto.getAddress());

            // Güncellenmiş entity'yi kaydet
            personelRepository.save(existingPersonel);
        } else {
            throw new PersonelManagerException(ErrorType.PERSONEL_NOT_FOUND);
        }
    }

    public Optional<PersonelResponseDto> showDetails() {
        personelRepository.findById(loginUser)
                .orElseThrow(() -> new PersonelManagerException(ErrorType.PERSONEL_NOT_FOUND));
        PersonelResponseDto personelDetails = personelRepository.findPersonelDetails(loginUser);
        return Optional.ofNullable(personelDetails);
    }

    }







