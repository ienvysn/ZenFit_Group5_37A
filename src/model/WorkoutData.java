/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.sql.Date;

/**
 *
 * @author HP
 */
public class WorkoutData {
    private int userId;
    private String workoutDate;
    private String workoutName;
    private int reps;
    private int sets;
    private int weightKg;

    // Constructor
    public WorkoutData(int userId, String workoutDate, String workoutName, int reps, int sets, int weightKg) {
        this.userId = userId;
        this.workoutDate = workoutDate;
        this.workoutName = workoutName;
        this.reps = reps;
        this.sets = sets;
        this.weightKg = weightKg;
    }

    // Getters and Setters
    public int getUserId() { return userId; }
    public String getWorkoutDate() { return workoutDate; }
    public String getWorkoutName() { return workoutName; }
    public int getReps() { return reps; }
    public int getSets() { return sets; }
    public int getWeightKg() { return weightKg; }
}
