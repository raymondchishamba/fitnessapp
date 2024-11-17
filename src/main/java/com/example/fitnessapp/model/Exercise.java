package com.example.fitnessapp.model;

import com.example.fitnessapp.dto.ExerciseDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Exercise extends ExerciseDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;
    private Integer duration; // in minutes
    private Integer repetitions;

    @ManyToOne
    @JoinColumn(name = "workout_plan_id", nullable = false)
    private WorkoutPlan workoutPlan;

    public Exercise(String name, String type, Integer duration, Integer repetitions) {
        this.name = name;
        this.type = type;
        this.duration = duration;
        this.repetitions = repetitions;
    }

    }

