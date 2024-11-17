package com.example.fitnessapp.controller;

import com.example.fitnessapp.dto.ExerciseDTO;
import com.example.fitnessapp.dto.WorkoutPlanDTO;
import com.example.fitnessapp.model.WorkoutPlan;
import com.example.fitnessapp.service.WorkoutPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workout-plans")
public class WorkoutPlanController {

    @Autowired
    private WorkoutPlanService workoutPlanService;

    @PostMapping
    public ResponseEntity<WorkoutPlanDTO> createWorkoutPlan(@RequestBody WorkoutPlanDTO workoutPlanDTO) {
        WorkoutPlanDTO createdPlan = workoutPlanService.createWorkoutPlan((WorkoutPlan) workoutPlanDTO);
        return ResponseEntity.ok(createdPlan);
    }


    @GetMapping
    public List<WorkoutPlan> getAllWorkoutPlans() {
        return workoutPlanService.getAllWorkoutPlans();
    }

    @PostMapping("/{id}/exercises")
    public ResponseEntity<WorkoutPlanDTO> addExerciseToWorkoutPlan(
            @PathVariable Long id, @RequestBody ExerciseDTO exerciseDTO) {
        WorkoutPlanDTO updatedPlan = workoutPlanService.addExerciseToWorkoutPlan(id, exerciseDTO);
        return ResponseEntity.ok(updatedPlan);
    }
}
