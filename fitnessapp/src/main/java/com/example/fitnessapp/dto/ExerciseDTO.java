package com.example.fitnessapp.dto;

import lombok.Data;

@Data
public class ExerciseDTO {
    private Long id;
    private String name;
    private String description;

    public Integer getDuration() {
        return null;
    }
}
