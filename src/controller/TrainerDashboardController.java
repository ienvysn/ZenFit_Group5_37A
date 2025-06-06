/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.TrainerDao;
import model.Trainer;
import view.TrainerDashboardadmin;
import view.AddTrainer;
import java.util.List;

/**
 *
 * @author ACER
 */
public class TrainerDashboardController {
    private TrainerDao trainerDao;
    private TrainerDashboardadmin view;
    
    // Constructor for when we don't have a view (like from Dashboard)
    public TrainerDashboardController() {
        trainerDao = new TrainerDao();
    }
    
    // Constructor for when we have a view (like from TrainerDashboardadmin)
    public TrainerDashboardController(TrainerDashboardadmin view) {
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
    public boolean addTrainer(String name, String address, String shift, String speciality, byte[] image) {
        Trainer trainer = new Trainer(name, address, shift, speciality, image);
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
    public boolean updateTrainer(int id, String name, String address, String shift, String speciality, byte[] image) {
        Trainer trainer = new Trainer(name, address, shift, speciality, image);
        trainer.setId(id);
        return trainerDao.updateTrainer(trainer);
    }
    
    // Delete trainer
    public boolean deleteTrainer(int id) {
        return trainerDao.deleteTrainer(id);
    }
}
