package com.example.fitnessapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Progress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long workoutPlanId;
    private LocalDate date;
    private String status;

    @ManyToOne
    @JoinColumn(name = "exercise_id", nullable = false)
    private Exercise exercise;

    private String notes;

    public void setUserId(Long userId) {
    }

    public void setWorkoutPlanId(Long workoutPlanId) {
    }

    public void setStatus(String status) {
    }

    public Long getUserId() {
        return null;
    }

    public Long getWorkoutPlanId() {
        return null;
    }

    public String getStatus() {
        return null;
    }
}
