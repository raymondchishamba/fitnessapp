package com.example.fitnessapp.dataloader;

import com.example.fitnessapp.model.Exercise;
import com.example.fitnessapp.model.Progress;
import com.example.fitnessapp.model.User;
import com.example.fitnessapp.model.WorkoutPlan;
import com.example.fitnessapp.repository.ExerciseRepository;
import com.example.fitnessapp.repository.ProgressRepository;
import com.example.fitnessapp.repository.UserRepository;
import com.example.fitnessapp.repository.WorkoutPlanRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;


import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(DataLoader.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WorkoutPlanRepository workoutPlanRepository;

    @Autowired
    private ExerciseRepository exerciseRepository;

    @Autowired
    private ProgressRepository progressRepository;

    @Override
    public void run(String... args) {
        logger.info("Starting data loading...");
        try {
            if (userRepository.count() > 0) {
                logger.info("Data already exists. Skipping data loader.");
                return;
            }

            // Create Users
            User user1 = createUser("john_doe", "john@example.com", "password123");
            User user2 = createUser("jane_doe", "jane@example.com", "password123");
            User user3 = createUser("mike_smith", "mike@example.com", "password123");
            User user4 = createUser("susan_lee", "susan@example.com", "password123");
            User user5 = createUser("alex_jones", "alex@example.com", "password123");

            // Create Workout Plans
            WorkoutPlan workoutPlan1 = createWorkoutPlan("Cardio Blast", "A workout plan focused on endurance.", user1);
            WorkoutPlan workoutPlan2 = createWorkoutPlan("Strength Builder", "A workout plan for gaining strength.", user2);
            WorkoutPlan workoutPlan3 = createWorkoutPlan("Core Focus", "A workout plan for building core strength.", user3);
            WorkoutPlan workoutPlan4 = createWorkoutPlan("Flexibility Routine", "A stretching and yoga-based workout plan.", user4);
            WorkoutPlan workoutPlan5 = createWorkoutPlan("High-Intensity Training", "An advanced workout plan for experienced athletes.", user5);

            // Create Exercises for Each Plan
            Exercise exercise1 = createExercise("Running", "Cardio", 30, 0, workoutPlan1);
            Exercise exercise2 = createExercise("Cycling", "Cardio", 40, 0, workoutPlan1);
            Exercise exercise3 = createExercise("Deadlifts", "Strength", 20, 10, workoutPlan2);
            Exercise exercise4 = createExercise("Squats", "Strength", 20, 15, workoutPlan2);
            Exercise exercise5 = createExercise("Plank", "Core", 5, 1, workoutPlan3);
            Exercise exercise6 = createExercise("Sit-ups", "Core", 15, 25, workoutPlan3);
            Exercise exercise7 = createExercise("Yoga Stretches", "Flexibility", 20, 0, workoutPlan4);
            Exercise exercise8 = createExercise("Hamstring Stretch", "Flexibility", 10, 0, workoutPlan4);
            Exercise exercise9 = createExercise("Burpees", "Cardio/Strength", 15, 20, workoutPlan5);
            Exercise exercise10 = createExercise("Pull-ups", "Strength", 10, 10, workoutPlan5);

            // Create Progress Entries
            createProgress(user1, workoutPlan1, exercise1, LocalDate.now(), "In Progress", "Pushed hard today, feeling good!");
            createProgress(user1, workoutPlan1, exercise2, LocalDate.now().minusDays(1), "Completed", "Great cycling session, burned a lot of calories.");
            createProgress(user2, workoutPlan2, exercise3, LocalDate.now(), "In Progress", "Trying to improve my deadlift form.");
            createProgress(user2, workoutPlan2, exercise4, LocalDate.now().minusDays(2), "Completed", "Leg day was intense!");
            createProgress(user3, workoutPlan3, exercise5, LocalDate.now(), "In Progress", "Plank hold for 3 minutes, need to improve.");
            createProgress(user3, workoutPlan3, exercise6, LocalDate.now().minusDays(3), "Completed", "Sit-ups felt easier today.");
            createProgress(user4, workoutPlan4, exercise7, LocalDate.now(), "In Progress", "Morning yoga session was calming.");
            createProgress(user4, workoutPlan4, exercise8, LocalDate.now().minusDays(1), "Completed", "Hamstring stretches feel much better now.");
            createProgress(user5, workoutPlan5, exercise9, LocalDate.now(), "In Progress", "Burpees are killer, but I pushed through!");
            createProgress(user5, workoutPlan5, exercise10, LocalDate.now().minusDays(1), "Completed", "Hit 10 pull-ups, progress!");

            // Additional Progress Entries for Variety
            createProgress(user1, workoutPlan1, exercise1, LocalDate.now().minusDays(4), "Completed", "Felt exhausted but satisfied.");
            createProgress(user2, workoutPlan2, exercise4, LocalDate.now().minusDays(5), "Completed", "Getting stronger, added more reps.");
            createProgress(user3, workoutPlan3, exercise5, LocalDate.now().minusDays(6), "Completed", "Holding plank longer, good improvement.");
            createProgress(user4, workoutPlan4, exercise7, LocalDate.now().minusDays(2), "In Progress", "Feeling more flexible day by day.");
            createProgress(user5, workoutPlan5, exercise9, LocalDate.now().minusDays(3), "Completed", "Max effort on burpees today.");

            logger.info("Data loading completed successfully!");
        } catch (Exception e) {
            logger.error("Error during data loading: {}", e.getMessage(), e);
        }
    }

    private User createUser(String username, String email, String password) {
        try {
            User user = new User();
            user.setUsername(username);
            user.setEmail(email);
            user.setPassword(password);
            return userRepository.save(user);
        } catch (Exception e) {
            logger.error("Failed to create user: {}", username, e);
            throw e;
        }
    }

    private WorkoutPlan createWorkoutPlan(String name, String description, User user) {
        if (user == null) {
            throw new IllegalArgumentException("WorkoutPlan must have a valid User.");
        }
        try {
            WorkoutPlan workoutPlan = new WorkoutPlan();
            workoutPlan.setName(name);
            workoutPlan.setDescription(description);
            workoutPlan.setUser(user);
            return workoutPlanRepository.save(workoutPlan);
        } catch (Exception e) {
            logger.error("Failed to create workout plan: {}", name, e);
            throw e;
        }
    }

    private Exercise createExercise(String name, String type, int duration, int repetitions, WorkoutPlan workoutPlan) {
        if (workoutPlan == null) {
            throw new IllegalArgumentException("Exercise must have a valid WorkoutPlan.");
        }
        try {
            Exercise exercise = new Exercise();
            exercise.setName(name);
            exercise.setType(type);
            exercise.setDuration(duration);
            exercise.setRepetitions(repetitions);
            exercise.setWorkoutPlan(workoutPlan);
            return exerciseRepository.save(exercise);
        } catch (Exception e) {
            logger.error("Failed to create exercise: {}", name, e);
            throw e;
        }
    }

    private void createProgress(User user, WorkoutPlan workoutPlan, Exercise exercise, LocalDate date, String status, String notes) {
        if (user == null || workoutPlan == null || exercise == null) {
            throw new IllegalArgumentException("Progress must have valid User, WorkoutPlan, and Exercise.");
        }
        try {
            Progress progress = new Progress();
            progress.setUser(user);
            progress.setWorkoutPlan(workoutPlan);
            progress.setExercise(exercise);
            progress.setDate(date);
            progress.setStatus(status);
            progress.setNotes(notes);
            progressRepository.save(progress);
        } catch (Exception e) {
            logger.error("Failed to create progress entry for user: {}", user.getUsername(), e);
            throw e;
        }
    }
}