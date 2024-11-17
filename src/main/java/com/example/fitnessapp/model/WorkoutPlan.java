package com.example.fitnessapp.model;

import com.example.fitnessapp.dto.ExerciseDTO;
import com.example.fitnessapp.dto.WorkoutPlanDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkoutPlan extends WorkoutPlanDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    public List<ExerciseDTO> getExercises() {
        return null;
    }

    public Object getDuration() {
        return null;
    }
    public WorkoutPlan(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
