package com.group1.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FindAllItemResponseDto {
    private String itemId;
    private String personelName;
    private String personelSurname;
    private LocalDate startingDate;
    private LocalDate endingDate;
    private String name;
}
