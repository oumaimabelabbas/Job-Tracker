package com.oumaima.jobtracker.application;


import java.time.LocalDate;
import java.time.LocalDateTime;

public record ApplicationRequest(

         String company,
         String position,
         Status status,
         LocalDate appliedDate,
         String notes
) {
}
