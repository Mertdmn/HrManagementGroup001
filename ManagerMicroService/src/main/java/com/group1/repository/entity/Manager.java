package com.group1.repository.entity;

import com.group1.utility.enums.ERole;
import com.group1.utility.enums.EState;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tbl_manager")
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String secondName;
    private String surname;
    private String secondSurname;
    private String TCNo;
    private String email;
    private String password;
    private String phone;
    private String photo;
    private String company;
    private String placeOfBirth;
    private LocalDate dateOfBirth;
    private LocalDate hiringDate;
    private LocalDate dismissalDate;
    private String department;
    private String address;
    private String title;
    private double salary;
    private ERole role;
    private EState state;
    private int remainingDaysOff;
}
