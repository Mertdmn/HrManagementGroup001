package com.group1.dto.response;

import com.group1.utility.enums.ECurrency;
import com.group1.utility.enums.EState;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShowSpendingResponseDto {
    LocalDate requestDate;
    @Enumerated(EnumType.STRING)
    EState state;
    @Enumerated(EnumType.STRING)
    ECurrency currency;
    String file;
    String description;
}
