/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.UserDao;
import model.UserData;
import view.Update;

import javax.swing.*;
import java.sql.Date;

public class UpdateController {
    private final Update view;

    public UpdateController(Update view) {
        this.view = view;
    }

    public void updateUserFromForm() {
        try {
            String phone = view.getPhoneField().getText().trim();
            String username = view.getUsernameField().getText().trim();
            Date joinedDate = Date.valueOf(view.getJoinedDateField().getText().trim());
            Date expiryDate = Date.valueOf(view.getExpiryDateField().getText().trim());

            UserData user = view.getUserData();
            user.setPhone(phone);
            user.setUsername(username);
            user.setJoinedDate(joinedDate);
            user.setExpiryDate(expiryDate);

            boolean updated = new UserDao().updateUser(user);
            if (updated) {
                JOptionPane.showMessageDialog(view, "User updated successfully.");
                view.dispose();
            } else {
                JOptionPane.showMessageDialog(view, "Update failed.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Error: " + e.getMessage());
        }
    }
}
