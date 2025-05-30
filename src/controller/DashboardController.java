/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.util.List;
import dao.UserDao;
import view.Dashboard;
import model.UserData;

/**
 *
 * @author ACER
 */
public class DashboardController {
    private final UserDao userDao = new UserDao();
    private final Dashboard dashboardView;

    public DashboardController(Dashboard dashboardView) {
        this.dashboardView = dashboardView;
    }

    public void open() {
        this.dashboardView.setVisible(true);
    }

    public void close() {
        this.dashboardView.dispose();
    }

    public void initializeDashboard(String username) {
        List<UserData> allUser= userDao.getAllUsers();
        System.out.println(allUser);
        for (UserData user : allUser) {
            System.out.println(user.getUsername());
        }
        UserData currentUser = userDao.getUserByUsername(username);
        if (currentUser != null) {
            System.out.println("User Details:");
            System.out.println("Username: " + currentUser.getUsername());
            System.out.println("Password: " + currentUser.getPassword());
            System.out.println("Joined Date: " + currentUser.getJoinedDate());
            System.out.println("Expiry Date: " + currentUser.getExpiryDate());
            System.out.println("Membership Type: " + currentUser.getMembershipType());
            System.out.println("Role: " + currentUser.getRole());
        }
    }
}
