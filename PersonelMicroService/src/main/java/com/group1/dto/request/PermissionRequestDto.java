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
public class PermissionRequestDto {
    LocalDate startingDate;
    LocalDate endingDate;
    int usedPermissionDays;
    String type;
    String token;
    LocalDate requestDate;
    LocalDate responseDate;
    EState state;
}
