package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Trainer;
import database.MySqlConnection;
import database.Database;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ACER
 */
public class TrainerDao {
    private Database db;
    private Connection connection;
    
    public TrainerDao() {
        db = new MySqlConnection();
        connection = db.openConnection();
    }
    
    // Add new trainer
    public boolean addTrainer(Trainer trainer) {
        String sql = "INSERT INTO trainers (name, address, shift, speciality, image) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, trainer.getName());
            stmt.setString(2, trainer.getAddress());
            stmt.setString(3, trainer.getShift());
            stmt.setString(4, trainer.getSpeciality());
            stmt.setBytes(5, trainer.getImage());
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Get all trainers
    public List<Trainer> getAllTrainers() {
        List<Trainer> trainers = new ArrayList<>();
        String sql = "SELECT * FROM trainers";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Trainer trainer = new Trainer();
                trainer.setId(rs.getInt("id"));
                trainer.setName(rs.getString("name"));
                trainer.setAddress(rs.getString("address"));
                trainer.setShift(rs.getString("shift"));
                trainer.setSpeciality(rs.getString("speciality"));
                trainer.setImage(rs.getBytes("image"));
                trainers.add(trainer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trainers;
    }
    
    // Get trainer by ID
    public Trainer getTrainerById(int id) {
        String sql = "SELECT * FROM trainers WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                Trainer trainer = new Trainer();
                trainer.setId(rs.getInt("id"));
                trainer.setName(rs.getString("name"));
                trainer.setAddress(rs.getString("address"));
                trainer.setShift(rs.getString("shift"));
                trainer.setSpeciality(rs.getString("speciality"));
                trainer.setImage(rs.getBytes("image"));
                return trainer;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    // Update trainer
    public boolean updateTrainer(Trainer trainer) {
        String sql = "UPDATE trainers SET name=?, address=?, shift=?, speciality=?, image=? WHERE id=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, trainer.getName());
            stmt.setString(2, trainer.getAddress());
            stmt.setString(3, trainer.getShift());
            stmt.setString(4, trainer.getSpeciality()); 
            stmt.setBytes(5, trainer.getImage());
            stmt.setInt(6, trainer.getId());
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Delete trainer
    public boolean deleteTrainer(int id) {
        String sql = "DELETE FROM trainers WHERE id=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Close connection when done
    public void closeConnection() {
        if (connection != null) {
            db.CloseConnection(connection);
        }
    }
}
