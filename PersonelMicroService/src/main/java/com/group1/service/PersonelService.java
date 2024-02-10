package com.group1.service;


import com.group1.dto.request.*;
import com.group1.dto.response.PersonelResponseDto;
import com.group1.dto.response.ShowResponseDto;
import com.group1.exception.ErrorType;
import com.group1.exception.PersonelManagerException;
import com.group1.mapper.PersonelMapper;
import com.group1.repository.PersonelRepository;
import com.group1.repository.entity.Personel;
import com.group1.utility.JwtTokenManager;
import com.group1.utility.enums.ERole;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonelService {
    private final PersonelRepository personelRepository;
    private final JwtTokenManager jwtTokenManager;
    public String login(LoginPersonelRequestDto dto) {
        Optional<Personel> personel=personelRepository.findOptionalByEmailAndPassword(dto.getEmail(),dto.getPassword());
        if (personel.isEmpty()||personel.get().getRole()== ERole.DISMISSED){
           throw new PersonelManagerException(ErrorType.LOGIN_ERROR);
        }
        Optional<String> token=jwtTokenManager.createToken(personel.get().getId());
        if (token.isEmpty()){
        throw new PersonelManagerException(ErrorType.TOKEN_NOT_CREATED);
        }
        return token.get();
    }
    public Personel save(PersonelSaveRequestDto dto){
        Personel result = personelRepository.save(PersonelMapper.INSTANCE.fromDto(dto));
        return result;
    }

    public Optional<Personel> findOptionalById(Long id){
        return personelRepository.findOptionalById(id);
    }


    public ShowResponseDto showPersonelByToken(GetPersonelByTokenRequestDto getPersonelByTokenRequestDto) {
        Optional<Long> personelId=jwtTokenManager.getIdFromToken(getPersonelByTokenRequestDto.getToken());
        if (personelId.isEmpty()) {
            throw new PersonelManagerException(ErrorType.INVALID_TOKEN);
        }
        Optional<Personel> personel=personelRepository.findOptionalById(personelId.get());
        if (personel.isEmpty()) {
            throw new PersonelManagerException(ErrorType.PERSONEL_NOT_FOUND);
        }
        return PersonelMapper.INSTANCE.toShow(personel.get());
    }
    public PersonelResponseDto showDetailsPersonelByToken(GetPersonelDetailsByTokenRequestDto getPersonelByTokenRequestDto) {
        Optional<Long> personelId=jwtTokenManager.getIdFromToken(getPersonelByTokenRequestDto.getToken());
        if (personelId.isEmpty()) {
            throw new PersonelManagerException(ErrorType.INVALID_TOKEN);
        }
        Optional<Personel> personel=personelRepository.findOptionalById(personelId.get());
        if (personel.isEmpty()) {
            throw new PersonelManagerException(ErrorType.PERSONEL_NOT_FOUND);
        }
        return PersonelMapper.INSTANCE.toShowDetails(personel.get());
    }

    public void update(UpdatePersonelRequestDto dto) {
        Optional<Long> personelId=jwtTokenManager.getIdFromToken(dto.getToken());
        if (personelId.isEmpty()) {
            throw new PersonelManagerException(ErrorType.INVALID_TOKEN);
        }
        // Personel entity'sini bul
        Optional<Personel> existingPersonelOptional = personelRepository.findById(personelId.get());

        if (existingPersonelOptional.isPresent()) {
            Personel existingPersonel = existingPersonelOptional.get();

            // Update edilecek alanları güncelle

            existingPersonel.setPhone(dto.getPhone());
            existingPersonel.setAddress(dto.getAddress());
            existingPersonel.setCompany(dto.getCompany());
            existingPersonel.setDateOfBirth(dto.getDateOfBirth());
            existingPersonel.setDepartment(dto.getDepartment());
            existingPersonel.setDismissalDate(dto.getDismissalDate());
            existingPersonel.setHiringDate(dto.getHiringDate());
            existingPersonel.setRemainingDaysOff(dto.getRemainingDaysOff());
            existingPersonel.setRole(dto.getRole());
            existingPersonel.setSalary(dto.getSalary());
            existingPersonel.setSecondName(dto.getSecondName());
            existingPersonel.setSecondSurname(dto.getSecondSurname());
            existingPersonel.setState(dto.getState());
            existingPersonel.setTitle(dto.getTitle());
            existingPersonel.setTCNo(dto.getTCNo());
            existingPersonel.setName(dto.getName());
            existingPersonel.setSurname(dto.getSurname());
            existingPersonel.setPlaceOfBirth(dto.getPlaceOfBirth());
            personelRepository.save(existingPersonel);
        } else {
            throw new PersonelManagerException(ErrorType.PERSONEL_NOT_FOUND);
        }
    }



}







