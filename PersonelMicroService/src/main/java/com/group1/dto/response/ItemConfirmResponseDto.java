package com.group1.dto.response;


import com.group1.utility.enums.EItemState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemConfirmResponseDto {
    private String itemId;
    private String managerName;
    private String managerSurname;
    private EItemState itemState;
    private LocalDate updateAt;


}
