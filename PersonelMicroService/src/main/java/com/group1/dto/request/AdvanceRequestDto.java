package com.group1.dto.request;


import com.group1.utility.enums.ECurrency;
import com.group1.utility.enums.EState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AdvanceRequestDto {
    double amount;
    LocalDate date;
    EState state;
    LocalDate responseDate;
    ECurrency currency;

}