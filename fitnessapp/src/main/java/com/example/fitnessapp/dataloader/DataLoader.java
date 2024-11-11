package com.example.fitnessapp.dataloader;

import com.example.fitnessapp.model.Exercise;
import com.example.fitnessapp.model.User;
import com.example.fitnessapp.model.WorkoutPlan;
import com.example.fitnessapp.repository.ExerciseRepository;
import com.example.fitnessapp.repository.UserRepository;
import com.example.fitnessapp.repository.WorkoutPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WorkoutPlanRepository workoutPlanRepository;

    @Autowired
    private ExerciseRepository exerciseRepository;

    @Override
    public void run(String... args) throws Exception {
        //  Suggest different users
        User user = new User();
        user.setUsername("john_doe");
        user.setEmail("john@example.com");
        user.setPassword("password123");
        userRepository.save(user);

        User user1 = new User();
        user1.setUsername("john_doe1");
        user1.setEmail("johndoe1@example.com");
        user.setPassword("password123");
        userRepository.save(user);

        User user2 = new User();
        user2.setUsername("rays_don");
        user2.setEmail("raysdon@example.com");
        user.setPassword("<PASSWORD>");
        userRepository.save(user);

        // Suggest different workout plans
        WorkoutPlan workoutPlan = new WorkoutPlan();
        workoutPlan.setName("Strength Training");
        workoutPlan.setDescription("A beginner's workout plan for building strength.");
        workoutPlan.setUser(user);
        workoutPlan = workoutPlanRepository.save(workoutPlan);

        WorkoutPlan workoutPlan1 = new WorkoutPlan();
        workoutPlan1.setName("Cardio");
        workoutPlan.setDescription("A beginner's workout plan for building strength.");
        workoutPlan.setUser(user);
        workoutPlan = workoutPlanRepository.save(workoutPlan);

        WorkoutPlan workoutPlan2 = new WorkoutPlan();
        workoutPlan2.setName("muscle training");
        workoutPlan.setDescription("A beginner's workout plan for building strength.");
        workoutPlan.setUser(user);
        workoutPlan = workoutPlanRepository.save(workoutPlan);

        // Create sample exercises
        Exercise exercise1 = new Exercise();
        exercise1.setName("Push-ups");
        exercise1.setType("Strength");
        exercise1.setDuration(10);
        exercise1.setRepetitions(15);
        exercise1.setWorkoutPlan(workoutPlan);
        exerciseRepository.save(exercise1);

        Exercise exercise2 = new Exercise();
        exercise2.setName("Squats");
        exercise2.setType("Strength");
        exercise2.setDuration(10);
        exercise2.setRepetitions(20);
        exercise2.setWorkoutPlan(workoutPlan);
        exerciseRepository.save(exercise2);

        //suggests more users and workoutplans



        Exercise exercise3 = new Exercise();
        exercise3.setName("Bench Press");
        exercise3.setType("Strength");
        exercise3.setDuration(10);
        exercise3.setRepetitions(15);
        exercise3.setWorkoutPlan(workoutPlan);
        exerciseRepository.save(exercise3);

        System.out.println("Sample data loaded!");
    }
}
