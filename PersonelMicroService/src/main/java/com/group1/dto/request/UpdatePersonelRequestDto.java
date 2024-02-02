package com.group1.dto.request;

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
public class UpdatePersonelRequestDto {
    String address;
    String phone;
    String token;
    Long imageId;
    List<MultipartFile> images;

}