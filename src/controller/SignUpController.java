/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author ACER
 */
import dao.UserDao;
import java.awt.HeadlessException;
import view.SignUp;
import view.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.UserData;

import java.util.Date;
import java.util.Calendar;
import view.Dashboard;
import controller.DashboardController;
import java.nio.file.Files;
import org.mindrot.jbcrypt.BCrypt;

public class SignUpController {
    private final UserDao userDao = new UserDao();
    private final SignUp userView;

    public SignUpController(SignUp userView) {
        this.userView = userView;
        userView.setSignUpListener(new AddUserListener());
    }

    public void open() {
        this.userView.setVisible(true);
    }

    public void close() {
        this.userView.dispose();
    }

    class AddUserListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String username = userView.getUsernameField().getText().trim();
                String password = new String(userView.getPasswordField().getPassword());
                String membershipType = userView.getSelectedMembership();
                String phone = userView.getPhone().getText().trim();
                java.io.File imgFile = userView.getSelectedImageFile();
                byte[] image = null;
                if (imgFile != null) {
                    try {
                        image = Files.readAllBytes(imgFile.toPath());
                    } catch (java.io.IOException ioEx) {
                        JOptionPane.showMessageDialog(userView,
                                "Failed to read image file: " + ioEx.getMessage(),
                                "File Error",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }

                if (username.isEmpty() || password.isEmpty() || phone.isEmpty()) {
                    JOptionPane.showMessageDialog(userView,
                            "All fields are required",
                            "Validation Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (password.length() < 8) {
                    JOptionPane.showMessageDialog(userView,
                            "Password must be at least 8 characters long.",
                            "Validation Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;

                }
                if (!phone.matches("\\d{10}")) {
                    JOptionPane.showMessageDialog(userView,
                            "Phone number isnt 10 digits.",
                            "Validation Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                // Check if phone number already exists
                if (userDao.checkPhoneExists(phone)) {
                    JOptionPane.showMessageDialog(userView,
                            "This phone number is already registered.",
                            "Registration Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Date joinedDate = new Date();
                Calendar cal = Calendar.getInstance();
                cal.setTime(joinedDate);
                switch (membershipType) {
                    case "1 Month":
                        cal.add(Calendar.MONTH, 1);
                        break;
                    case "3 Month":
                        cal.add(Calendar.MONTH, 3);
                        break;
                    case "6 Month":
                        cal.add(Calendar.MONTH, 6);
                    case "1 Year":
                        cal.add(Calendar.YEAR, 1);
                        break;
                    default:
                        cal.add(Calendar.MONTH, 1);
                }
                Date expiryDate = cal.getTime();

                // Hash the password before saving
                String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

                UserData user = new UserData(username, phone, hashedPassword, joinedDate, expiryDate, membershipType,
                        "member", image);

                boolean userExists = userDao.checkUser(user);
                if (userExists) {
                    JOptionPane.showMessageDialog(userView,
                            "A user with this username already exists",
                            "Registration Error",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    userDao.signup(user);
                    JOptionPane.showMessageDialog(userView,
                            "Registration successful! Please login.",
                            "Success",
                            JOptionPane.INFORMATION_MESSAGE);

                    userView.dispose();
                    // Redirect to login after signup
                    view.Login loginView = new view.Login();
                    controller.LoginController loginController = new controller.LoginController(loginView);
                    loginController.open();
                }

            } catch (HeadlessException ex) {
                JOptionPane.showMessageDialog(userView,
                        "An error occurred: " + ex.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                System.err.println("Registration error: " + ex.getMessage());
            }
        }
    }
}
