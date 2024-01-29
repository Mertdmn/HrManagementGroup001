package com.group1.repository.entity;

import com.group1.utility.enums.EState;
import com.group1.utility.enums.EType;
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
public class BreaksAndShifts implements Serializable {
    @Id
    private String id;
    private String personelId;
    private EType type;
    private EState State;
    private LocalDate bSStartingDate;
    private LocalDate bSEndingDate;
    private double bSTotalTime;
    private LocalDate responseDate;

}
