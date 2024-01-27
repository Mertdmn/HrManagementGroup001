package com.group1.dto.request;

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
public class ItemsRequestDto {
    LocalDate startingDate;
    LocalDate endingDate;
    String name;
    EState State;

}
