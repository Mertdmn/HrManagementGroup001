package com.group1.repository.entity;

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
@Table(name = "tbl_items")
public class Items {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String personelId;
    LocalDate startingDate;
    LocalDate endingDate;
    String name;
    @Enumerated(EnumType.STRING)
    EState State;
    LocalDate responseDate;
}
