package com.group1.repository.entity;


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
import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="tbl_permissions")
public class Permissions{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   private String personelId;
   private LocalDate startingDate;
   private LocalDate endingDate;
   private int usedPermissionDays;
   private String type;
   private LocalDate requestDate;
   private EState state;
   private LocalDate responseDate;


}
