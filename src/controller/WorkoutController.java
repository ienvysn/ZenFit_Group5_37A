/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import dao.WorkoutDAO;
import model.WorkoutData;
import java.sql.Date;
/**
 *
 * @author HP
 */
public class WorkoutController {
    private WorkoutDAO workoutDAO;

    public WorkoutController(WorkoutDAO workoutDAO) {
        this.workoutDAO = workoutDAO;
    }

    public boolean addWorkout(int userId, String  date, String name, int reps, int sets, int weight) {
        WorkoutData workout = new WorkoutData(userId, date, name, reps, sets, weight);
        return workoutDAO.addWorkout(workout);
    }
}
