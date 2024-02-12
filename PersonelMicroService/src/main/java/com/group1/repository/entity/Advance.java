package com.group1.repository.entity;

import com.group1.utility.enums.ECurrency;
import com.group1.utility.enums.EState;
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
@Table(name = "tbl_advance")
public class Advance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    double amount;
    LocalDate date;
    @Enumerated(EnumType.STRING)
    EState state;
    LocalDate responseDate;
    @Enumerated(EnumType.STRING)
    ECurrency currency;
}
