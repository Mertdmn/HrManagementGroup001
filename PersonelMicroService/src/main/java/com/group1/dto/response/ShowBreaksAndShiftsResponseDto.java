package com.group1.dto.response;

import com.group1.utility.enums.EState;
import com.group1.utility.enums.EType;
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
public class ShowBreaksAndShiftsResponseDto {
    @Enumerated(EnumType.STRING)
    EType type;
    @Enumerated(EnumType.STRING)
    EState State;
    LocalDate bSStartingDate;
    LocalDate bSEndingDate;
    double bSTotalTime;
    LocalDate responseDate;
}
