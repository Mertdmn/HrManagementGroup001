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
@Table(name = "tbl_permissions")
public class Permissions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    LocalDate startingDate;
    LocalDate endingDate;
    int usedPermissionDays;
    String type;
    LocalDate requestDate;
    @Enumerated(EnumType.STRING)
    EState state;
    LocalDate responseDate;
}
