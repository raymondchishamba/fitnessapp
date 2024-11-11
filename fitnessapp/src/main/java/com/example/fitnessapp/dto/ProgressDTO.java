package com.example.fitnessapp.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ProgressDTO {
    private Long id;
    private Long userId;
    private Long workoutPlanId;
    private LocalDate date;
    private String status;
    private String notes;
}
