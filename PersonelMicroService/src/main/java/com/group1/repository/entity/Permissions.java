package com.group1.repository.entity;


import com.group1.utility.enums.EState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class Permissions {
    @Id
   private String id;
   private String personelId;
   private LocalDate startingDate;
   private LocalDate endingDate;
   private int usedPermissionDays;
   private String type;
   private LocalDate requestDate;
   private EState state;
   private LocalDate responseDate;


}
