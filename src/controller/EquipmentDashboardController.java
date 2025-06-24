package controller;

import dao.EquipmentDao;
import model.EquipmentData;
import view.EquipmentPanelContainer;
import view.Reusablepannel;
import java.util.List;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.io.File;
import java.nio.file.Files;

public class EquipmentDashboardController {
    private EquipmentDao equipmentDao;
    private EquipmentPanelContainer view;

    public EquipmentDashboardController(EquipmentPanelContainer view) {
        this.view = view;
        this.equipmentDao = new EquipmentDao();
    }

    public void populateEquipmentPanels() {
        List<EquipmentData> allEquipment = equipmentDao.getAllEquipment();
        JPanel equipmentPanelContainer = view.getEquipmentPanelContainer();
        equipmentPanelContainer.removeAll();
        equipmentPanelContainer.setLayout(new GridLayout(0, 3, 10, 10));
        equipmentPanelContainer.setBackground(new java.awt.Color(4, 39, 56));
        System.out.println("test");
        for (EquipmentData equipment : allEquipment) {
            Reusablepannel panel = new Reusablepannel();

            if (equipment.getImage() == null || equipment.getImage().length == 0) {
                try {
                    File defaultImg = new File("src/img/default_equipment.jpg");
                    byte[] imgBytes = Files.readAllBytes(defaultImg.toPath());
                    equipment.setImage(imgBytes);
                } catch (Exception ex) {
                    System.out.println("Default equipment image not found: " + ex.getMessage());
                }
            }
            panel.updateEquipmentData(equipment);
            equipmentPanelContainer.add(panel);
        }
        equipmentPanelContainer.revalidate();
        equipmentPanelContainer.repaint();
        // Call debug method after populating
        debugEquipmentPanels(allEquipment, equipmentPanelContainer);
    }

    public void debugEquipmentPanels(java.util.List<model.EquipmentData> allEquipment,
            javax.swing.JPanel equipmentPanelContainer) {
        System.out.println("Equipment count: " + allEquipment.size());
        for (model.EquipmentData equipment : allEquipment) {
            System.out.println("Equipment name: " + equipment.getName());
        }
        System.out.println("Panel component count after add: " + equipmentPanelContainer.getComponentCount());
    }
}
