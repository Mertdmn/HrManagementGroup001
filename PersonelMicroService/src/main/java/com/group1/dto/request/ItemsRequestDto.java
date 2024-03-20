package com.group1.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemsRequestDto {
    private String personelTcno;
    private LocalDate startingDate;
    private LocalDate endingDate;
    private String name;

}
