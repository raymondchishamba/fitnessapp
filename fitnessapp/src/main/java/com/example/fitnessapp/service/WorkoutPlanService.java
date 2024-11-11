package com.example.fitnessapp.service;

import com.example.fitnessapp.dto.ExerciseDTO;
import com.example.fitnessapp.dto.WorkoutPlanDTO;
import com.example.fitnessapp.model.Exercise;
import com.example.fitnessapp.model.WorkoutPlan;
import com.example.fitnessapp.repository.WorkoutPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkoutPlanService {

    @Autowired
    private WorkoutPlanRepository workoutPlanRepository;

    public List<WorkoutPlan> getWorkoutPlansByUserId(Long userId) {
        return workoutPlanRepository.findByUserId(userId);
    }

    public WorkoutPlan createWorkoutPlan(WorkoutPlan workoutPlan) {
        return workoutPlanRepository.save(workoutPlan);
    }

    public List<WorkoutPlanDTO> getAllWorkoutPlans() {
        List<WorkoutPlan> workoutPlans = workoutPlanRepository.findAll();
        return workoutPlans.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public WorkoutPlanDTO addExerciseToWorkoutPlan(Long id, ExerciseDTO exerciseDTO) {
        WorkoutPlan workoutPlan = workoutPlanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Workout plan not found"));

        Exercise exercise = convertToEntity(exerciseDTO);
        workoutPlan.getExercises().add(exercise);

        workoutPlan = workoutPlanRepository.save(workoutPlan);
        return convertToDTO(workoutPlan);
    }

    private WorkoutPlanDTO convertToDTO(WorkoutPlan workoutPlan) {
        WorkoutPlanDTO dto = new WorkoutPlanDTO();
        dto.setId(workoutPlan.getId());
        dto.setName(workoutPlan.getName());
        dto.setDuration(workoutPlan.getDuration());
        // Convert and set other properties
        return dto;
    }

    private Exercise convertToEntity(ExerciseDTO exerciseDTO) {
        Exercise exercise = new Exercise();
        exercise.setName(exerciseDTO.getName());
        exercise.setDuration(exerciseDTO.getDuration());
        // Convert and set other properties
        return exercise;
    }
}
