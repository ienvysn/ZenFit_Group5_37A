/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import database.Database;
import database.MySqlConnection;
import model.WorkoutData;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class WorkoutDAO {
//    private Connection connection;
//    private MySqlConnection db;
//    
//    public WorkoutDAO() {
//        this.db = new MySqlConnection(); // Initialize your MySQL connection
//    }
//
//    public WorkoutDAO(Connection connection) {
//        this.connection = connection;
//    }
//    
//
//    // Add a new workout to the database
//    public boolean addWorkout(WorkoutData workout) {
//        String sql = "INSERT INTO workouts (user_id, workout_date, workout_name, reps, sets, weight_kg) VALUES (?, ?, ?, ?, ?, ?)";
//        
//        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
//            stmt.setInt(1, workout.getUserId());
//            stmt.setDate(2, workout.getWorkoutDate());
//            stmt.setString(3, workout.getWorkoutName());
//            stmt.setInt(4, workout.getReps());
//            stmt.setInt(5, workout.getSets());
//            stmt.setInt(6, workout.getWeightKg());
//
//            int rowsAffected = stmt.executeUpdate();
//            return rowsAffected > 0;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//
    private final Database db;

    public WorkoutDAO() {
        this.db = new MySqlConnection(); // Initialize your MySQL connection
    }

    public boolean addWorkout(WorkoutData workout) {
        Connection conn = null;
        try {
            conn = db.openConnection();
            String sql = "INSERT INTO workouts (user_id, workout_date, workout_name, reps, sets, weight_kg) VALUES (?, ?, ?, ?, ?, ?)";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, workout.getUserId());
            stmt.setString(2, workout.getWorkoutDate());
            stmt.setString(3, workout.getWorkoutName());
            stmt.setInt(4, workout.getReps());
            stmt.setInt(5, workout.getSets());
            stmt.setInt(6, workout.getWeightKg());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (conn != null) {
                db.CloseConnection(conn);
            }
        }
    }

    public List<WorkoutData> getWorkoutsByUserId(int userId) {
        List<WorkoutData> workouts = new ArrayList<>();
        Connection conn = null;
        try {
            conn = db.openConnection();
            String sql = "SELECT * FROM workouts WHERE user_id = ? ORDER BY workout_date DESC";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                WorkoutData workout = new WorkoutData(
                    rs.getInt("user_id"),
                    rs.getString("workout_date"),
                    rs.getString("workout_name"),
                    rs.getInt("reps"),
                    rs.getInt("sets"),
                    rs.getInt("weight_kg")
                );
                workouts.add(workout);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                db.CloseConnection(conn);
            }
        }
        return workouts;
    }
}
