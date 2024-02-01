package com.group1.service;


import com.group1.dto.request.LoginPersonelRequestDto;
import com.group1.dto.request.PersonelSaveRequestDto;
import com.group1.dto.request.RegisterRequestDto;
import com.group1.dto.request.UpdatePersonelRequestDto;
import com.group1.dto.response.PersonelResponseDto;
import com.group1.dto.response.ShowResponseDto;
import com.group1.exception.ErrorType;
import com.group1.exception.PersonelManagerException;
import com.group1.mapper.PersonelMapper;
import com.group1.repository.PersonelRepository;
import com.group1.repository.entity.Personel;
import com.group1.utility.JwtTokenManager;
import com.group1.utility.enums.ERole;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonelService {
    private final PersonelRepository personelRepository;
    private final JwtTokenManager jwtTokenManager;
    public Boolean login(LoginPersonelRequestDto dto) {
        Personel personel1=new Personel();
        personel1.setEmail("abc@hotmail.com");
        personel1.setPassword("123456");
        personelRepository.save(personel1);
        Optional<Personel> personel=personelRepository.findOptionalByEmailAndPassword(dto.getEmail(),dto.getPassword());
        if (personel.isEmpty()||personel.get().getRole()== ERole.DISMISSED){
           throw new PersonelManagerException(ErrorType.LOGIN_ERROR);
        }else {
            return true;
        }
    }
    public Personel save(PersonelSaveRequestDto dto){
        Personel result = personelRepository.save(PersonelMapper.INSTANCE.fromDto(dto));
        return result;
    }
//    public Optional<Personel> register(RegisterRequestDto dto){
//        String token=jwtTokenManager.createToken()
//        Optional<Long> personelId=jwtTokenManager.getIdFromToken(dto.getToken());
//        if (personelId.isEmpty()) {
//            throw new PersonelManagerException(ErrorType.INVALID_TOKEN);
//        }
//        Optional<Personel> personel=personelRepository.findOptionalById(personelId.get());
//        personel= Optional.of(personelRepository.save(PersonelMapper.INSTANCE.fromDto(dto)));
//        if (personel==null){
//            throw new PersonelManagerException(ErrorType.PERSONEL_NOT_FOUND);
//        }
//        return personel;
//    }


    // personel id bulup spending / advance service üzerinde çağırdık
    public Optional<Personel> findById(String id){
        return personelRepository.findById(id);
    }

    public Optional<Personel> findOptionalById(Long id){
        return personelRepository.findOptionalById(id);
    }


    public Optional<ShowResponseDto> show(ShowResponseDto showResponseDto) {
        Optional<Long> personelId=jwtTokenManager.getIdFromToken(showResponseDto.getToken());
        if (personelId.isEmpty()) {
            throw new PersonelManagerException(ErrorType.INVALID_TOKEN);
        }
        Personel personel = personelRepository.findById(personelId.get())
                .orElseThrow(() -> new PersonelManagerException(ErrorType.PERSONEL_NOT_FOUND));
        showResponseDto=PersonelMapper.INSTANCE.toShow(personel);

        return Optional.ofNullable(personelRepository.findAllBy(showResponseDto));
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

            // Güncellenmiş entity'yi kaydet
            personelRepository.save(existingPersonel);
        } else {
            throw new PersonelManagerException(ErrorType.PERSONEL_NOT_FOUND);
        }
    }

    public Optional<PersonelResponseDto> showDetails() {
        PersonelResponseDto personelResponseDto=new PersonelResponseDto();
        Optional<Long> personelId=jwtTokenManager.getIdFromToken(personelResponseDto.getToken());
        if (personelId.isEmpty()) {
            throw new PersonelManagerException(ErrorType.INVALID_TOKEN);
        }

         personelResponseDto = personelRepository.findPersonelDetails(personelId.get());
        return Optional.ofNullable(personelResponseDto);
    }


}







