package com.group1.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShowResponseDto {
    String name;
    String surname;
    String email;
    String phone;
    String photo;
    String token;
}
