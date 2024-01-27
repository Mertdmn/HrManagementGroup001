package com.group1.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdatePersonelRequestDto {
    // photo alıncak
    String address;
    String phone;
    String personelId;

}