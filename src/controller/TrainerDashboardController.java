/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.TrainerDao;
import model.Trainer;
import view.TrainerDashboardadmin;
import view.AddTrainer;
import view.TrainerPanelContainer;
import java.util.List;

/**
 *
 * @author ACER
 */
public class TrainerDashboardController {
    private TrainerDao trainerDao;
    private TrainerPanelContainer view;

    // Constructor for when we don't have a view (like from Dashboard)
    public TrainerDashboardController() {
        trainerDao = new TrainerDao();
    }

    // Constructor for when we have a view (like from TrainerDashboardadmin or UserDashboard)
    public TrainerDashboardController(TrainerPanelContainer view) {
        this.view = view;
        trainerDao = new TrainerDao();
    }

    // Navigation methods
    public void openTrainerDashboard() {
        TrainerDashboardadmin trainerDashboard = new TrainerDashboardadmin();
        trainerDashboard.setVisible(true);
    }

    public void openAddTrainer() {
        AddTrainer addTrainer = new AddTrainer();
        addTrainer.setVisible(true);
        if (view != null) {
            view.dispose();
        }
    }

    // Add new trainer
    public boolean addTrainer(String name, String address, String shift, String speciality, byte[] image,String phone) {
        Trainer trainer = new Trainer(name, address, shift, speciality, image,phone);
        return trainerDao.addTrainer(trainer);
    }

    // Get all trainers
    public List<Trainer> getAllTrainers() {
        return trainerDao.getAllTrainers();
    }

    // Get trainer by ID
    public Trainer getTrainerById(int id) {
        return trainerDao.getTrainerById(id);
    }

    // Update trainer
    public boolean updateTrainer(int id, String name, String address, String shift, String speciality, byte[] image,String phone) {
        Trainer trainer = new Trainer(name, address, shift, speciality, image,phone);
        trainer.setId(id);
        return trainerDao.updateTrainer(trainer);
    }

    // Delete trainer
    public boolean deleteTrainer(int id) {
        return trainerDao.deleteTrainer(id);
    }

    public void populateTrainerPanels() {
        List<Trainer> allTrainers = trainerDao.getAllTrainers();
        javax.swing.JPanel trainerPanelContainer = view.getTrainerPanelContainer(); // Assuming a getter exists in
                                                                                    // TrainerDashboardadmin
        trainerPanelContainer.removeAll(); // Clear previous panels
        trainerPanelContainer.setLayout(new java.awt.GridLayout(0, 3, 0, 0)); // Set gaps to 0
        trainerPanelContainer.setBackground(new java.awt.Color(4, 39, 56)); // Match background color

        for (Trainer trainer : allTrainers) {
            view.Reusablepannel panel = new view.Reusablepannel();

            if (trainer.getImage() == null || trainer.getImage().length == 0) {
                try {
                    java.io.File defaultImg = new java.io.File("src/img/defaultprofile.jpg");
                    byte[] imgBytes = java.nio.file.Files.readAllBytes(defaultImg.toPath());
                    trainer.setImage(imgBytes);
                } catch (Exception ex) {
                    System.out.println("Default image not found: " + ex.getMessage());
                }
            }
            panel.updateTrainerData(trainer);

            panel.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent e) {
                    view.TrainercardNoRemove trainerCard = new view.TrainercardNoRemove();
                    trainerCard.updateTrainer(trainer);
                    trainerCard.setVisible(true);
                }
            });

            trainerPanelContainer.add(panel);
        }

        trainerPanelContainer.revalidate();
        trainerPanelContainer.repaint();
    }
}
