package com.group1.dto.request;


import com.group1.utility.enums.ERole;
import com.group1.utility.enums.EState;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequestDto {
    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    @NotBlank
    @Size(min =8, max=32, message = "Sifre minimum 8 maksimum 32 karakterden olusmalidir...")
    private String password;
    @Email
    private String email;
    @NotBlank
    private String phone;
    @NotBlank
    private MultipartFile photo;
    private String company;
    private LocalDate dateOfBirth;
    private LocalDate hiringDate;
    private String department;
    private String address;
    @NotBlank
    private String title;
    private double salary;
    private ERole role;
    @NotBlank
    private EState state;
    private int remainingDaysOff;
    @NotBlank
    @Size(min = 11, max = 11, message = "TCNO 11 Karakter Olmalıdır")
    private String tcno;


}
