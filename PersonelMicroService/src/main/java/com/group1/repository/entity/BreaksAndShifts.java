package com.group1.repository.entity;

import com.group1.utility.enums.EState;
import com.group1.utility.enums.EType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.time.LocalDate;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="tbl_breaksandshifts")
public class BreaksAndShifts{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String personelId;
    private EType type;
    private EState State;
    private LocalDate bSStartingDate;
    private LocalDate bSEndingDate;
    private double bSTotalTime;
    private LocalDate responseDate;

}
