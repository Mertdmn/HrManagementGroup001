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
public class SpendingRequestDto {
    String type;
    double amount;
    LocalDate spendingDate;
    LocalDate responseDate;
    LocalDate requestDate;
    EState state;
    ECurrency currency;
    String file;
    String description;
    String token;

}
