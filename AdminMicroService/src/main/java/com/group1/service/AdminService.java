package com.group1.service;

import com.group1.dto.request.*;
import com.group1.dto.response.AdminResponseDto;
import com.group1.dto.response.ShowResponseDto;
import com.group1.exception.ErrorType;
import com.group1.exception.AdminManagerException;
import com.group1.manager.ManagerManager;
import com.group1.mapper.AdminMapper;

import com.group1.repository.AdminRepository;
import com.group1.repository.entity.Admin;
import com.group1.utility.JwtTokenManager;
import com.group1.utility.enums.ERole;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final AdminRepository adminRepository;
    private final JwtTokenManager jwtTokenManager;
    private final ManagerManager manager;

//    public void register(RegisterRequestDto dto){
//        adminRepository.findOptionalByEmailAndPassword(dto.getEmail(),dto.getPassword())
//                .ifPresent(admin->{
//                    throw new AdminManagerException(ErrorType.EMAIL_NOT_FOUND);
//                });
//
//        managerRegisterProducer.sendNewManager(ManagerRegisterModel.builder()
//                .email(dto.getEmail())
//                .password(dto.getPassword())
//                .build());
//    }
    public String login(LoginAdminRequestDto dto) {
        Optional<Admin> admin= adminRepository.findOptionalByEmailAndPassword(dto.getEmail(),dto.getPassword());
        if (admin.isEmpty()||admin.get().getRole()== ERole.DISMISSED){
            throw new AdminManagerException(ErrorType.LOGIN_ERROR);
        }
        Optional<String> token=jwtTokenManager.createToken(admin.get().getId());
        if (token.isEmpty()){
            throw new AdminManagerException(ErrorType.TOKEN_NOT_CREATED);
        }
        return token.get();
    }
    public void register(RegisterRequestDto dto){
        Admin admin=AdminMapper.INSTANCE.fromDto(dto);
//        manager.save(ManagerSaveRequestDto.builder()
//                .adminId(admin.getId())
//                .email(admin.getEmail())
//                .password(dto.getPassword()).build());
        manager.save(AdminMapper.INSTANCE.fromAdmin(admin));
    }

    public void update(UpdateAdminRequestDto dto) {
        Optional<Long> adminId=jwtTokenManager.getIdFromToken(dto.getToken());
        if (adminId.isEmpty()) {
            throw new AdminManagerException(ErrorType.INVALID_TOKEN);
        }
        Optional<Admin> existingAdminOptional = adminRepository.findById(adminId.get());

        if (existingAdminOptional.isPresent()) {
            Admin existingAdmin = existingAdminOptional.get();

            existingAdmin.setPhone(dto.getPhone());
            existingAdmin.setName(dto.getName());
            existingAdmin.setSurname(dto.getSurname());
            existingAdmin.setSecondName(dto.getSecondName());
            existingAdmin.setSecondSurname(dto.getSecondSurname());
            existingAdmin.setRole(dto.getRole());
            existingAdmin.setTCNo(dto.getTCNo());
            adminRepository.save(existingAdmin);
        } else {
            throw new AdminManagerException(ErrorType.ADMIN_NOT_FOUND);
        }
    }

    public ShowResponseDto showAdminByToken(GetAdminByTokenRequestDto dto) {
        Optional<Long> adminId=jwtTokenManager.getIdFromToken(dto.getToken());
        if (adminId.isEmpty()) {
            throw new AdminManagerException(ErrorType.INVALID_TOKEN);
        }
        Optional<Admin> admin=adminRepository.findOptionalById(adminId.get());
        if (admin.isEmpty()) {
            throw new AdminManagerException(ErrorType.ADMIN_NOT_FOUND);
        }
        return AdminMapper.INSTANCE.toShow(admin.get());
    }

    public AdminResponseDto showDetailsPersonelByToken(GetAdminDetailsByTokenRequestDto dto) {
        Optional<Long> adminId=jwtTokenManager.getIdFromToken(dto.getToken());
        if (adminId.isEmpty()) {
            throw new AdminManagerException(ErrorType.INVALID_TOKEN);
        }
        Optional<Admin> admin=adminRepository.findOptionalById(adminId.get());
        if (admin.isEmpty()) {
            throw new AdminManagerException(ErrorType.ADMIN_NOT_FOUND);
        }
        return AdminMapper.INSTANCE.toShowDetails(admin.get());
    }
}
