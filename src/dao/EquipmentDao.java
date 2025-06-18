/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author Niraj
 */


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.EquipmentData;  // Updated import
import database.Database;

public class EquipmentDao {
    private Database db;

    public EquipmentDao() {
        db = new database.MySqlConnection();
    }

    public boolean addEquipment(EquipmentData equipment) {
        String query = "INSERT INTO equipment (name, type, quantity, purchaseDate) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = db.openConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, equipment.getName());
            pstmt.setString(2, equipment.getType());
            pstmt.setInt(3, equipment.getQuantity());
            pstmt.setString(4, equipment.getPurchaseDate());
            
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<EquipmentData> getAllEquipment() {
        List<EquipmentData> equipmentList = new ArrayList<>();
        String query = "SELECT * FROM equipment";
        
        try (Connection conn = db.openConnection();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            
            while (rs.next()) {
                EquipmentData equipment = new EquipmentData(
                    rs.getString("name"),
                    rs.getString("type"),
                    rs.getInt("quantity"),
                    rs.getString("purchaseDate")
                );
                equipmentList.add(equipment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return equipmentList;
    }
}