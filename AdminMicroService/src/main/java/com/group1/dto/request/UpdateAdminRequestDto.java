package com.group1.dto.request;

import com.group1.utility.enums.ERole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateAdminRequestDto {
    String token;
    String name;
    String secondName;
    String surname;
    String secondSurname;
    String TCNo;
    String email;
    String password;
    String phone;
//    String photo;
    ERole role;
}