package com.group1.service;

import com.group1.dto.request.LoginAdminRequestDto;
import com.group1.exception.ErrorType;
import com.group1.exception.AdminManagerException;
import com.group1.repository.AdminRepository;
import com.group1.repository.entity.Admin;
import com.group1.utility.enums.ERole;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final AdminRepository adminRepository;
    public static Long loginUser = null;

    public Boolean login(LoginAdminRequestDto dto) {
        Admin admin1=new Admin();
        admin1.setEmail("xyz@hotmail.com");
        admin1.setPassword("123456");
        adminRepository.save(admin1);
        Optional<Admin> admin= adminRepository.findOptionalByEmailAndPassword(dto.getEmail(),dto.getPassword());
        if (admin.isEmpty()||admin.get().getRole()== ERole.DISMISSED){
            throw new AdminManagerException(ErrorType.LOGIN_ERROR);
        }else {
            loginUser=admin.get().getId();
            return true;
        }
    }
}
