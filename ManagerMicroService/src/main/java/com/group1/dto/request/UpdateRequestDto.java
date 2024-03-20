package com.group1.dto.request;

import com.group1.utility.enums.ERole;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateRequestDto {
    // photo alıncak
    String address;
    String phone;
    String name;
    String surname;
    String secondName;
    String token;
    String secondSurname;
    @Enumerated(EnumType.STRING)
    ERole role;
    String TCNo;
    String company;
    String placeOfBirth;
    LocalDate dateOfBirth;
    LocalDate hiringDate;
    LocalDate dismissalDate;
    String department;
    double salary;


}