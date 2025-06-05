/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.UserDao;
import java.awt.HeadlessException;
import view.Login;
import view.Dashboard;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.LoginRequest;
import model.UserData;

/**
 *
 * @author ACER
 */
public class LoginController {
    private final UserDao userDao = new UserDao();
    private final Login userView;

    public LoginController(Login userView) {
        this.userView = userView;
        userView.addLoginListener(new AddLoginListener());
    }

    public void open() {
        this.userView.setVisible(true);
    }

    public void close() {
        this.userView.dispose();
    }

    class AddLoginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String username = userView.getUsernameField().getText();
                String password = userView.getPasswordField().getText();

                if (username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(userView,
                            "Username and password cannot be empty",
                            "Login Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                LoginRequest user = new LoginRequest(username, password);
                boolean loginSuccessful = userDao.checkLogin(user);

                if (loginSuccessful) {
                    // Fetch user data from DB
                    UserData userData = userDao.getUserByUsername(username);
                    // model.CurrentUser.set(userData);
                    JOptionPane.showMessageDialog(userView, "Login successful!",
                            "Success",
                            JOptionPane.INFORMATION_MESSAGE);

                    close(); // Close the login window before opening dashboard

                    if ("ADMIN".equals(userData.getRole())) {
                        // Open admin dashboard
                        view.Dashboard adminDashboard = new view.Dashboard();
                        controller.DashboardController adminController = new controller.DashboardController(
                                adminDashboard);
                        adminController.initializeDashboard(username);
                        adminController.open();
                    } else {
                        // Open user dashboard
                        view.UserDashboard userDashboard = new view.UserDashboard();
                        controller.UserDashboardController userController = new controller.UserDashboardController(
                                userDashboard);
                        userController.initializeDashboard(username);
                        userController.open();
                    }
                } else {
                    JOptionPane.showMessageDialog(userView,
                            "Invalid username or password",
                            "Login Failed",
                            JOptionPane.ERROR_MESSAGE);
                }
            } catch (HeadlessException ex) {
                JOptionPane.showMessageDialog(userView,
                        "An error occurred: " + ex.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                System.err.println("Login error: " + ex.getMessage());
            }
        }
    }
}
