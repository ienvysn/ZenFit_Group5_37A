/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.WorkoutDAO;
import model.WorkoutData;
import model.CurrentUser;
import model.UserData;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class WorkoutController {
    private final WorkoutDAO workoutDAO;
    private final JTable workoutTable;

    public WorkoutController(JTable workoutTable) {
        this.workoutDAO = new WorkoutDAO();
        this.workoutTable = workoutTable;
    }

    public void loadWorkoutData() {
        try {
            // Get current user
            UserData currentUser = CurrentUser.get();
            
            // Get workouts for current user
            List<WorkoutData> workouts = workoutDAO.getWorkoutsByUserId(currentUser.getId());
            
            // Create table model
            DefaultTableModel model = (DefaultTableModel) workoutTable.getModel();
            model.setRowCount(0); // Clear existing rows
            
            // Add workouts to table
            for (WorkoutData workout : workouts) {
                model.addRow(new Object[]{
                    workout.getWorkoutName(),
                    workout.getSets(),
                    workout.getReps(),
                    workout.getWeightKg()
                });
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error loading workouts: " + e.getMessage());
        }
    }

    public boolean addWorkout(int userId, String date, String name, int reps, int sets, int weight) {
        WorkoutData workout = new WorkoutData(userId, date, name, reps, sets, weight);
        return workoutDAO.addWorkout(workout);
    }
}
