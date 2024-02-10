package com.group1.service;

import com.group1.dto.request.*;
import com.group1.dto.response.ManagerResponseDto;
import com.group1.dto.response.ShowResponseDto;
import com.group1.exception.ErrorType;
import com.group1.exception.ManagerException;
import com.group1.manager.PersonelManager;
import com.group1.mapper.ManagerMapper;
import com.group1.rabbitmq.model.RegisterModel;
import com.group1.rabbitmq.producer.RegisterProducer;
import com.group1.repository.ManagerRepository;
import com.group1.repository.entity.Manager;
import com.group1.utility.JwtTokenManager;
import com.group1.utility.enums.ERole;
import com.group1.utility.enums.EState;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ManagerService {
    private final ManagerRepository managerRepository;
    private final RegisterProducer registerProducer;
    private final JwtTokenManager jwtTokenManager;


    public void register(RegisterRequestDto dto){
        managerRepository.findOptionalByEmailAndPassword(dto.getEmail(),dto.getPassword())
                .ifPresent(manager->{
                    throw new ManagerException(ErrorType.EMAIL_NOT_FOUND);
                });
//        Manager manager = ManagerMapper.INSTANCE.fromDto(dto);
//        manager.setState(EState.CONFIRMED);
//        managerRepository.save(manager);
        registerProducer.sendNewUser(RegisterModel.builder()
                .email(dto.getEmail())
                .password(dto.getPassword())
                .build());
    }
    public Manager save(PersonelSaveRequestDto dto){
        Manager result = managerRepository.save(ManagerMapper.INSTANCE.fromDto(dto));
        return result;
    }
    public String login(LoginManagerRequestDto dto) {
        Optional<Manager> manager= managerRepository.findOptionalByEmailAndPassword(dto.getEmail(),dto.getPassword());
        if (manager.isEmpty()||manager.get().getRole()== ERole.DISMISSED){
            throw new ManagerException(ErrorType.LOGIN_ERROR);
        }
        Optional<String> token=jwtTokenManager.createToken(manager.get().getId());
        if (token.isEmpty()){
            throw new ManagerException(ErrorType.TOKEN_NOT_CREATED);
        }
        return token.get();
    }

    public void update(UpdateRequestDto dto) {
        Optional<Long> adminId=jwtTokenManager.getIdFromToken(dto.getToken());
        if (adminId.isEmpty()) {
            throw new ManagerException(ErrorType.INVALID_TOKEN);
        }
        Optional<Manager> existingAdminOptional = managerRepository.findById(adminId.get());

        if (existingAdminOptional.isPresent()) {
            Manager existingManager = existingAdminOptional.get();

            existingManager.setPhone(dto.getPhone());
            existingManager.setName(dto.getName());
            existingManager.setSurname(dto.getSurname());
            existingManager.setSecondName(dto.getSecondName());
            existingManager.setSecondSurname(dto.getSecondSurname());
            existingManager.setRole(dto.getRole());
            existingManager.setTCNo(dto.getTCNo());
            managerRepository.save(existingManager);
        } else {
            throw new ManagerException(ErrorType.MANAGER_NOT_FOUND);
        }
    }

    public ShowResponseDto showAdminByToken(GetManagerByTokenRequestDto dto) {
        Optional<Long> adminId=jwtTokenManager.getIdFromToken(dto.getToken());
        if (adminId.isEmpty()) {
            throw new ManagerException(ErrorType.INVALID_TOKEN);
        }
        Optional<Manager> admin=managerRepository.findOptionalById(adminId.get());
        if (admin.isEmpty()) {
            throw new ManagerException(ErrorType.MANAGER_NOT_FOUND);
        }
        return ManagerMapper.INSTANCE.toShow(admin.get());
    }

    public ManagerResponseDto showDetailsPersonelByToken(GetManagerByTokenRequestDto dto) {
        Optional<Long> adminId=jwtTokenManager.getIdFromToken(dto.getToken());
        if (adminId.isEmpty()) {
            throw new ManagerException(ErrorType.INVALID_TOKEN);
        }
        Optional<Manager> admin=managerRepository.findOptionalById(adminId.get());
        if (admin.isEmpty()) {
            throw new ManagerException(ErrorType.MANAGER_NOT_FOUND);
        }
        return ManagerMapper.INSTANCE.toShowDetails(admin.get());
    }
}
