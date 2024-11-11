package com.example.fitnessapp.service;

import aj.org.objectweb.asm.commons.Remapper;
import com.example.fitnessapp.dto.ProgressDTO;
import com.example.fitnessapp.model.Progress;
import com.example.fitnessapp.repository.ProgressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProgressService {

    @Autowired
    private ProgressRepository progressRepository;

    public ProgressDTO logProgress(ProgressDTO progressDTO) {
        // Convert DTO to entity
        Progress progress = convertToEntity(progressDTO);

        // Save the entity to the database
        progress = progressRepository.save(progress);

        // Convert the saved entity back to DTO
        return convertToDTO(progress);
    }

    public List<ProgressDTO> getProgressByUser(Long userId) {
        List<Progress> progressList = progressRepository.findByUserId(userId);
        return progressList.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    // Utility method to convert ProgressDTO to Progress entity
    private Progress convertToEntity(ProgressDTO progressDTO) {
        Progress progress = new Progress();
        progress.setUserId(progressDTO.getUserId());
        progress.setWorkoutPlanId(progressDTO.getWorkoutPlanId());
        progress.setDate(progressDTO.getDate());
        progress.setStatus(progressDTO.getStatus());
        progress.setNotes(progressDTO.getNotes());
        return progress;
    }

    // Utility method to convert Progress entity to ProgressDTO
    private ProgressDTO convertToDTO(Progress progress) {
        ProgressDTO progressDTO = new ProgressDTO();
        progressDTO.setId(progress.getId());
        progressDTO.setUserId(progress.getUserId());
        progressDTO.setWorkoutPlanId(progress.getWorkoutPlanId());
        progressDTO.setDate(progress.getDate());
        progressDTO.setStatus(progress.getStatus());
        progressDTO.setNotes(progress.getNotes());
        return progressDTO;
    }

    public List<Progress> getAllProgress() {
        return null;
    }

    public Optional<Progress> getProgressById(Long id) {
        return null;
    }
}
