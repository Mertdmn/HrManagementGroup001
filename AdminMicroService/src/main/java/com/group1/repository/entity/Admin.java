package com.group1.repository.entity;

import com.group1.utility.enums.ERole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_admin")
public class Admin {
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
    ERole role;
}
