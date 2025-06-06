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
import view.Usercard;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.io.File;
import java.nio.file.Files;
import javax.imageio.ImageIO;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author ACER
 */
public class DashboardController {
    private final UserDao userDao = new UserDao();
    private final Dashboard dashboardView;

    public DashboardController(Dashboard dashboardView) {
        this.dashboardView = dashboardView;
        // dashboardView.addADDprofilelistener(new profilelistener());
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
            if (!"ADMIN".equals(currentUser.getRole())) {
                JOptionPane.showMessageDialog(dashboardView,
                        "Access denied. Admin privileges required.",
                        "Authorization Error",
                        JOptionPane.ERROR_MESSAGE);
                close();
                return;
            }

            // Populate dashboard with user panels
            populateUserPanels();

            System.out.println("\nAdmin Details:");
            System.out.println("Username: " + currentUser.getUsername());
            System.out.println("Role: " + currentUser.getRole());
        }
    }

    private void populateUserPanels() {
        List<UserData> allUsers = userDao.getAllUsers();
        JPanel userPanelContainer = dashboardView.getUserPanelContainer();
        userPanelContainer.removeAll(); // Clear previous panels
        userPanelContainer.setLayout(new GridLayout(0, 3, 10, 10));
        for (UserData user : allUsers) {
            view.Reusablepannel panel = new view.Reusablepannel();

            if (user.getImage() == null || user.getImage().length == 0) {
                try {
                    File defaultImg = new File("src/img/defaultprofile.jpg");
                    byte[] imgBytes = Files.readAllBytes(defaultImg.toPath());
                    user.setImage(imgBytes);
                } catch (Exception ex) {
                    System.out.println("Default image not found: " + ex.getMessage());
                }
            }
            panel.updateUserData(user);

            panel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    UserData clickedUser = userDao.getUserByUsername(panel.getUsername());
                    if (clickedUser != null) {
                        view.Usercard usercard = new view.Usercard();
                        usercard.updateUserData(clickedUser);
                        usercard.setVisible(true);
                    }
                }
            });

            userPanelContainer.add(panel);
        }
        userPanelContainer.revalidate();
        userPanelContainer.repaint();

        // Debug print moved here
        System.out.println("All Users:");
        for (UserData user : allUsers) {
            System.out.println("Username: " + user.getUsername());
            System.out.println("Role: " + user.getRole());
            System.out.println("Membership: " + user.getMembershipType());
        }
    }

    // class profilelistener implements ActionListener {
    // @Override
    // public void actionPerformed(ActionEvent e) {
    // UserData currentUser =
    // userDao.getUserByUsername(model.CurrentUser.get().getUsername());
    // if (currentUser != null) {
    // Usercard usercard1 = new Usercard();
    // usercard1.updateUserData(currentUser);
    // usercard1.setVisible(true);
    // }
    // }
    // }
}
