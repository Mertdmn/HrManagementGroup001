package com.group1.dto.request;

import com.group1.utility.enums.ERole;
import com.group1.utility.enums.EState;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdatePersonelRequestDto {
    String address;
    String phone;
    String token;
    String name;
    String secondName;
    String surname;
    String secondSurname;
    String TCNo;
//    String photo;
    String company;
//    Long imageId;
    LocalDate placeOfBirth;
    LocalDate dateOfBirth;
    LocalDate hiringDate;
    LocalDate dismissalDate;
    String department;
    String title;
    double salary;
    @Enumerated(EnumType.STRING)
    ERole role;
    @Enumerated(EnumType.STRING)
    EState state;
    int remainingDaysOff;
//    Long imageId;
//    List<MultipartFile> images;

}