package controller;

import dao.UserDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.UserDashboard;
import model.UserData;
import view.UsercardNoRemove;

public class UserDashboardController {
    private final UserDao userDao = new UserDao();
    private final UserDashboard dashboardView;
    private String username; // Store the logged-in username

    public UserDashboardController(UserDashboard dashboardView, String username) {
        this.dashboardView = dashboardView;
        this.username = username;
        dashboardView.addADDprofilelistener(new profilelistener());
    }

    public void open() {
        this.dashboardView.setVisible(true);
    }

    public void close() {
        this.dashboardView.dispose();
    }

    public void initializeDashboard(String username) {
        UserData currentUser = userDao.getUserByUsername(username);
        if (currentUser != null) {
            System.out.println("User Details:");
            System.out.println("Username: " + currentUser.getUsername());
            System.out.println("Joined Date: " + currentUser.getJoinedDate());
            System.out.println("Expiry Date: " + currentUser.getExpiryDate());
            System.out.println("Membership Type: " + currentUser.getMembershipType());
            System.out.println("Role: " + currentUser.getRole());
        }
    }

    class profilelistener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            UserData user = userDao.getUserByUsername(username);
            if (user != null) {
                UsercardNoRemove usercard3 = new UsercardNoRemove();
                usercard3.updateUserData(user);
                usercard3.setVisible(true);
            } else {
                javax.swing.JOptionPane.showMessageDialog(dashboardView, "User not found!", "Error",
                        javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}