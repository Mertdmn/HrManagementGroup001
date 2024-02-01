package com.group1.service;

import com.group1.dto.request.RegisterRequestDto;
import com.group1.exception.ErrorType;
import com.group1.exception.ManagerException;
import com.group1.mapper.ManagerMapper;
import com.group1.rabbitmq.model.RegisterModel;
import com.group1.rabbitmq.producer.RegisterProducer;
import com.group1.repository.ManagerRepository;
import com.group1.repository.entity.Manager;
import com.group1.utility.enums.EState;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ManagerService {
    private final ManagerRepository managerRepository;
    private final RegisterProducer registerProducer;
    public void register(RegisterRequestDto dto){
        managerRepository.findOptionalByEmailAndPassword(dto.getEmail(),dto.getPassword())
                .ifPresent(manager->{
                    throw new ManagerException(ErrorType.EMAIL_NOT_FOUND);
                });
        Manager manager = ManagerMapper.INSTANCE.fromDto(dto);
        manager.setState(EState.CONFIRMED);
        managerRepository.save(manager);
        registerProducer.sendNewUser(RegisterModel.builder()
                .managerId(manager.getId())
                .email(manager.getEmail())
                .build());
    }
    /*

    public Optional<ShowResponseDto> show() {
        Manager manager= managerRepository.findById(loginUser)
                .orElseThrow(() -> new ManagerException(ErrorType.MANAGER_NOT_FOUND));
        ShowResponseDto showResponseDto = ManagerMapper.INSTANCE.toShow(manager);
        return Optional.ofNullable(managerRepository.findAllBy(showResponseDto));
    }
    public void update(UpdateRequestDto dto) {
        // Personel entity'sini bul
        Optional<Manager> existingPersonelOptional = managerRepository.findById(loginUser);

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
    public Boolean login(LoginManagerRequestDto dto) {
        Manager manager1=new Manager();
        manager1.setEmail("xyz@hotmail.com");
        manager1.setPassword("123456");
        managerRepository.save(manager1);
        Optional<Manager> manager=managerRepository.findOptionalByEmailAndPassword(dto.getEmail(),dto.getPassword());
        if (manager.isEmpty()||manager.get().getRole()== ERole.DISMISSED){
            throw new ManagerException(ErrorType.LOGIN_ERROR);
        }else {
            loginUser=manager.get().getId();
            return true;
        }
    }
    */

}
