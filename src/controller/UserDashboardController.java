package controller;

import dao.UserDao;
import view.UserDashboard;
import model.UserData;

public class UserDashboardController {
    private final UserDao userDao = new UserDao();
    private final UserDashboard dashboardView;

    public UserDashboardController(UserDashboard dashboardView) {
        this.dashboardView = dashboardView;
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
} 