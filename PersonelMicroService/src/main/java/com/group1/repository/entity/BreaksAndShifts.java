package com.group1.repository.entity;

import com.group1.utility.enums.EState;
import com.group1.utility.enums.EType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_breaksandshifts")
public class BreaksAndShifts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String personelId;
    @Enumerated(EnumType.STRING)
    EType type;
    @Enumerated(EnumType.STRING)
    EState State;
    LocalDate bSStartingDate;
    LocalDate bSEndingDate;
    double bSTotalTime;
    LocalDate responseDate;
}
