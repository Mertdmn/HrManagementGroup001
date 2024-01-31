package com.group1.repository.entity;


import com.group1.utility.enums.ECurrency;
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
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="tbl_spending")
public class Spending{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String personelId;
    private double amount;
    private LocalDate spendingDate;
    private LocalDate responseDate;
    private LocalDate requestDate;
    private EState state;
    private ECurrency currency;
    private String file;
    private String description;
}
