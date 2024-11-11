package com.example.fitnessapp.dto;

import lombok.Data;
import java.util.List;

@Data
public class WorkoutPlanDTO {
    private Long id;
    private String name;
    private String description;
    private List<ExerciseDTO> exercises;

    public void setDuration(Object duration) {
    }
}
