package com.group1.service;


import com.group1.dto.request.LoginPersonelRequestDto;
import com.group1.dto.request.RegisterRequestDto;
import com.group1.dto.response.RegisterResponseDto;
import com.group1.exception.ErrorType;
import com.group1.exception.PersonelManagerException;
import com.group1.mapper.PersonelMapper;
import com.group1.repository.PersonelRepository;
import com.group1.repository.entity.Personel;
import com.group1.utility.enums.ERole;
import com.group1.utility.enums.EState;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonelService {


    private final PersonelRepository personelRepository;
   // private final CloudinaryConfig cloudinaryConfig;
    private static String loginUser="";
    public String getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(String user) {
        loginUser = user;
    }

    public Boolean login(LoginPersonelRequestDto dto) {
        Optional<Personel> personel=personelRepository.findOptionalByEmailAndPassword(dto.getEmail(),dto.getPassword());
        if (personel.isEmpty()||personel.get().getRole()== ERole.DISMISSED){
           throw new PersonelManagerException(ErrorType.LOGIN_ERROR);
        }else {
            loginUser=personel.get().getId();
            return true;

        }

    }

        /*  public boolean existsById(String personelId){

        return personelRepository.existsById(personelId);
          }
          public String findByPersonelId(String personelId){
            return personelRepository.findByPersonelId(personelId);
          }
    public void register(RegisterPersonelRequestDto dto, ERole callerRole) {
        // Register işlemi
        if (callerRole != ERole.ROLE_MANAGER) {
            throw new PersonelManagerException(ErrorType.UNAUTHORIZED_ACCESS);
        }

        Optional<Personel> existingPersonel = personelRepository.findOptionalByEmail(dto.getEmail());
        if (existingPersonel.isPresent()) {
            throw new PersonelManagerException(ErrorType.REGISTRATION_ERROR);
        } else {
            // Yeni personel oluştur
            Personel newPersonel = new Personel();
            newPersonel.setEmail(dto.getEmail());
            newPersonel.setPassword(dto.getPassword());

            // Personeli kaydet
            personelRepository.save(newPersonel);
        }
    }*/


    // personel id bulup spending / advance service üzerinde çağırdık
    public Optional<Personel> findById(String id){
        return personelRepository.findById(id);
    }

    public Optional<Personel>findPersonelByTCNO(String TCNO){
        return personelRepository.findPersonelByTcno(TCNO);
    }

    public Optional<Personel> findByIdFromLoginUser() {
        return personelRepository.findById(loginUser);
    }

    public Optional<Personel>findPersonelByNameAndSurname(String name,String surname){
        return personelRepository.findPersonelByNameAndSurname(name,surname);
    }

/*
    public RegisterResponseDto register(RegisterRequestDto dto) {
        System.out.println("Received TCNO in register method: " + dto.getTcno());

        Personel personel = Personel.builder()
                .name(dto.getName())
                .surname(dto.getSurname())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .phone(dto.getPhone())
                .photo(cloudinaryConfig.toTurnStringAvatar(dto.getPhoto()))
                .company(dto.getCompany())
                .dateOfBirth(dto.getDateOfBirth())
                .hiringDate(dto.getHiringDate())
                .department(dto.getDepartment())
                .address(dto.getAddress())
                .title(dto.getTitle())
                .salary(dto.getSalary())
                .role(ERole.PERSONEL)
                .state(EState.PENDING)
                .remainingDaysOff(dto.getRemainingDaysOff())
                .tcno(dto.getTcno())
                .build();

        personelRepository.save(personel);
        return PersonelMapper.INSTANCE.fromPersonelToRegisterResponse(personel);
    }
*/
}





