package com.group1.dto.response;

import com.group1.utility.enums.ERole;
import com.group1.utility.enums.EState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminResponseDto {
    String name;
    String secondName;
    String surname;
    String secondSurname;
    String TCNo;
    String email;
    String phone;
    String photo;
    ERole role;
}
