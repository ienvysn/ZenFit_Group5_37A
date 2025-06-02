/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.util.List;
import dao.UserDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.Dashboard;
import model.UserData;
import javax.swing.JOptionPane;
import view.UsercardNoRemove;

/**
 *
 * @author ACER
 */
public class DashboardController {
    private final UserDao userDao = new UserDao();
    private final Dashboard dashboardView;

    public DashboardController(Dashboard dashboardView) {
        this.dashboardView = dashboardView;
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
            // Verify admin role
            if (!"admin".equals(currentUser.getRole())) {
                JOptionPane.showMessageDialog(dashboardView,
                        "Access denied. Admin privileges required.",
                        "Authorization Error",
                        JOptionPane.ERROR_MESSAGE);
                close();
                return;
            }

            
            List<UserData> allUsers = userDao.getAllUsers();
            System.out.println("All Users:");
            for (UserData user : allUsers) {
                System.out.println("Username: " + user.getUsername());
                System.out.println("Role: " + user.getRole());
                System.out.println("Membership: " + user.getMembershipType());
            }

            System.out.println("\nAdmin Details:");
            System.out.println("Username: " + currentUser.getUsername());
            System.out.println("Role: " + currentUser.getRole());
        }
    }
    class profilelistener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            UsercardNoRemove usercard1 = new UsercardNoRemove();
            usercard1.setVisible(true);
        }
        
    }
}
