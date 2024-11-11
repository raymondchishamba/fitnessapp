package com.example.fitnessapp.repository;

import com.example.fitnessapp.model.Progress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProgressRepository extends JpaRepository<Progress, Long> {
    List<Progress> findByExerciseId(Long exerciseId);

    List<Progress> findByUserId(Long userId);
}
