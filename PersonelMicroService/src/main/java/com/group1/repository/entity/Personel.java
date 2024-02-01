package com.group1.repository.entity;

import com.group1.utility.enums.ERole;
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
@Table(name = "tbl_personel")
public class Personel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String secondName;
    String surname;
    String secondSurname;
    String TCNo;
    String email;
    String password;
    String phone;
    String photo;
    String company;
    String placeOfBirth;
    LocalDate dateOfBirth;
    LocalDate hiringDate;
    LocalDate dismissalDate;
    String department;
    String address;
    String title;
    double salary;
    @Enumerated(EnumType.STRING)
    ERole role;
    @Enumerated(EnumType.STRING)
    EState state;
    int remainingDaysOff;

}
