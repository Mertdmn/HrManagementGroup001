package com.group1.repository.entity;



import com.group1.utility.enums.ECurrency;
import com.group1.utility.enums.EState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document
public class Advance implements Serializable {
    @Id
    private String id;
    private String personelId;
    private double amount;
    private LocalDate date;
    private EState state;
    private LocalDate responseDate;
    private ECurrency currency;

}
