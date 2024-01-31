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
public class PersonelResponseDto {
    String name;
    String secondName;
    String surname;
    String secondSurname;
    String TCNo;
    String email;
    String phone;
    String token;
    String photo;
    String company;
    String placeOfBirth;
    LocalDate dateOfBirth;
    LocalDate hiringDate;
    LocalDate dismissalDate;
    String department;
    String address;
    String title;
    double salary;
    ERole role;
    EState state;
}
