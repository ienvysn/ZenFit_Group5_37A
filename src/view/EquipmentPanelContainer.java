package view;

import javax.swing.*;
import java.awt.*;

public class EquipmentPanelContainer extends JFrame {
    private JPanel equipmentPanelContainer;

    public EquipmentPanelContainer() {
        equipmentPanelContainer = new JPanel();
        JScrollPane scrollPane = new JScrollPane(equipmentPanelContainer);
        this.setLayout(new BorderLayout());
        this.add(scrollPane, BorderLayout.CENTER);
        this.setSize(900, 500);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public JPanel getEquipmentPanelContainer() {
        return equipmentPanelContainer;
    }
}
