package com.group1.service;

import com.group1.dto.request.LoginPersonelRequestDto;
import com.group1.dto.request.UpdateRequestDto;
import com.group1.dto.response.ManagerResponseDto;
import com.group1.dto.response.ShowResponseDto;
import com.group1.exception.ErrorType;
import com.group1.exception.ManagerException;
import com.group1.mapper.ManagerMapper;
import com.group1.repository.ManagerRepository;
import com.group1.repository.entity.Manager;
import com.group1.utility.enums.ERole;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ManagerService {
    private final ManagerRepository managerRepository;
    public static String loginUser="";
    public Boolean login(LoginPersonelRequestDto dto) {
        Optional<Manager> personel=managerRepository.findOptionalByEmailAndPassword(dto.getEmail(),dto.getPassword());
        if (personel.isEmpty()||personel.get().getRole()== ERole.DISMISSED){
            throw new ManagerException(ErrorType.LOGIN_ERROR);
        }else {
            loginUser=personel.get().getId();
            return true;
        }
    }
    public Optional<Manager> findById(String id){
        return managerRepository.findById(id);
    }
    public Optional<ShowResponseDto> show() {
        Manager manager= managerRepository.findById(loginUser)
                .orElseThrow(() -> new ManagerException(ErrorType.MANAGER_NOT_FOUND));
        ShowResponseDto showResponseDto = ManagerMapper.INSTANCE.toShow(manager);
        return Optional.ofNullable(managerRepository.findAllBy(showResponseDto));
    }
    public void update(UpdateRequestDto dto) {
        // Personel entity'sini bul
        Optional<Manager> existingPersonelOptional = managerRepository.findById(dto.getPersonelId());

        if (existingPersonelOptional.isPresent()) {
            Manager existingManager = existingPersonelOptional.get();

            // Update edilecek alanları güncelle

            existingManager.setPhone(dto.getPhone());
            existingManager.setAddress(dto.getAddress());

            // Güncellenmiş entity'yi kaydet
            managerRepository.save(existingManager);
        } else {
            throw new ManagerException(ErrorType.MANAGER_NOT_FOUND);
        }
    }
    public Optional<ManagerResponseDto> showDetails() {
        managerRepository.findById(loginUser)
                .orElseThrow(() -> new ManagerException(ErrorType.MANAGER_NOT_FOUND));
        ManagerResponseDto managerDetails = managerRepository.findManagerDetails(loginUser);
        return Optional.ofNullable(managerDetails);
    }
}
