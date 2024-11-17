package com.example.fitnessapp.repository;

import com.example.fitnessapp.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
    List<Exercise> findByWorkoutPlanId(Long workoutPlanId);
}
