package com.oumaima.jobtracker.application;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Application {
    @Id
    @GeneratedValue
    private Integer id;
    private String company;
    private String position;
    @Enumerated(EnumType.STRING)
    private Status status;
    private LocalDate appliedDate;
    private String notes;
}
