/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author Niraj
 */

import dao.EquipmentDao;
import model.EquipmentData;  // Updated import
import javax.swing.JOptionPane;

public class EquipmentController {
    private EquipmentDao equipmentDao;

    public EquipmentController() {
        equipmentDao = new EquipmentDao();
    }

    public boolean addEquipment(String name, String type, String quantityStr, String purchaseDate) {
        // Validation
        if (name.isEmpty() || type.isEmpty() || quantityStr.isEmpty() || purchaseDate.isEmpty()) {
            JOptionPane.showMessageDialog(null, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        try {
            int quantity = Integer.parseInt(quantityStr);
            EquipmentData equipment = new EquipmentData(name, type, quantity, purchaseDate);
            return equipmentDao.addEquipment(equipment);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Quantity must be a number!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
