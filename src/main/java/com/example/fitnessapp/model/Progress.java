package com.example.fitnessapp.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Progress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    private Long userId;
    private Long workoutPlanId;
    private LocalDate date;
    private String status;

    @ManyToOne
    @JoinColumn(name = "exercise_id", nullable = false)
    private Exercise exercise;
    private String notes;
    public void setUserId(Long userId) {
    }

    public void setWorkoutPlanId(Long workoutPlanId) {
    }

    public void setStatus(String status) {
    }

    public Long getWorkoutPlanId() {
        return null;
    }

    public String getStatus() {
        return null;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Progress progress = (Progress) o;
        return getId() != null && Objects.equals(getId(), progress.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
    public Progress(Long userId, Long workoutPlanId, LocalDate date, String status, Exercise exercise, String notes) {
        this.userId = userId;
        this.workoutPlanId = workoutPlanId;
        this.date = date;
        this.status = status;
        this.exercise = exercise;
        this.notes = notes;
    }

    public void setUser(User user) {
    }

    public void setWorkoutPlan(WorkoutPlan workoutPlan) {
    }

    public void setUserId() {
    }
}