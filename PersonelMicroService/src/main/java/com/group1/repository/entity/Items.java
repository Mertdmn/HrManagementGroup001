package com.group1.repository.entity;

import com.group1.utility.enums.EItemState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document
public class Items {
   @Id
   private String id;
   private String personelId;
   private String personelName;
   private String personelSurname;
   private String tcno;
   private LocalDate startingDate;
   private LocalDate endingDate;
   private String name;
   private String managerName;
   private String managerSurname;
   private String ApprovedName;
   private String ApprovedSurname;
   private EItemState itemState;
   private LocalDate createAt;
   private LocalDate updateAt;
}
