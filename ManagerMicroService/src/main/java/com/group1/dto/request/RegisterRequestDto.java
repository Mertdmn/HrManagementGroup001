package com.group1.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterRequestDto {
    @Email
    //ad.soyad@company.com
    private String email;
    @NotBlank
    @Size(min =8, max=32, message = "Sifre minimum 8 maksimum 32 karakterden olusmalidir...")
    private String password;
}
