/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

/**
 *
 * @author Salifa
 */
public class AdminFeedback extends javax.swing.JFrame {

    /**
     * Creates new form AdminFeedback
     */
    public AdminFeedback() {
        initComponents();
        // Set feedback panel to a 2-column grid layout
        feedback.setLayout(new java.awt.GridLayout(0, 2, 20, 20));
        displayAllFeedback();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        MembersText = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        Members = new javax.swing.JButton();
        Trainer = new javax.swing.JButton();
        Equipment = new javax.swing.JButton();
        Feedback = new javax.swing.JButton();
        Profilebtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        feedback = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(4, 39, 56));
        jPanel1.setForeground(new java.awt.Color(38, 50, 56));

        MembersText.setFont(new java.awt.Font("Segoe UI Semibold", 0, 36)); // NOI18N
        MembersText.setForeground(new java.awt.Color(255, 255, 255));
        MembersText.setText("Feedback");

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ZenFit");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE));
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE));
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 491, Short.MAX_VALUE));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 8, Short.MAX_VALUE));
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 541, Short.MAX_VALUE));

        Members.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        Members.setText("Members");
        Members.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Members.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MembersActionPerformed(evt);
            }
        });

        Trainer.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        Trainer.setText("Trainer");
        Trainer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Trainer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TrainerMouseClicked(evt);
            }
        });
        Trainer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TrainerActionPerformed(evt);
            }
        });

        Equipment.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        Equipment.setText("Equipment");
        Equipment.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Equipment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EquipmentActionPerformed(evt);
            }
        });

        Feedback.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        Feedback.setText("Feedback");
        Feedback.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Feedback.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FeedbackMouseClicked(evt);
            }
        });
        Feedback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FeedbackActionPerformed(evt);
            }
        });

        Profilebtn.setBackground(new java.awt.Color(153, 204, 255));
        Profilebtn.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        Profilebtn.setText("Profile");
        Profilebtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Profilebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProfilebtnActionPerformed(evt);
            }
        });

        feedback.setBackground(new java.awt.Color(4, 39, 56));

        javax.swing.GroupLayout feedbackLayout = new javax.swing.GroupLayout(feedback);
        feedback.setLayout(feedbackLayout);
        feedbackLayout.setHorizontalGroup(
                feedbackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 835, Short.MAX_VALUE));
        feedbackLayout.setVerticalGroup(
                feedbackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 439, Short.MAX_VALUE));

        jScrollPane1.setViewportView(feedback);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(34, 34, 34)
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel1)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(Profilebtn)
                                                                .addGap(32, 32, 32))))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                false)
                                                        .addComponent(Members, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(Trainer, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(Equipment, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                126, Short.MAX_VALUE)
                                                        .addComponent(Feedback, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(378, 378, 378)
                                                .addComponent(MembersText))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(36, 36, 36)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 837,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(60, 60, 60)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(106, 106, 106)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addContainerGap()));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(35, 35, 35)
                                .addComponent(Members)
                                .addGap(47, 47, 47)
                                .addComponent(Trainer)
                                .addGap(47, 47, 47)
                                .addComponent(Equipment)
                                .addGap(47, 47, 47)
                                .addComponent(Feedback)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Profilebtn)
                                .addGap(18, 18, 18))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(10, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(MembersText))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 441,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1078, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MembersActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_MembersActionPerformed
        // Navigate to Members (Dashboard)
        view.Dashboard dashboard = new view.Dashboard();
        controller.DashboardController dashboardController = new controller.DashboardController(dashboard);
        // Get current user
        String username = model.CurrentUser.get().getUsername();
        dashboardController.initializeDashboard(username); // Properly initialize with username
        dashboardController.open();
        this.dispose();
    }// GEN-LAST:event_MembersActionPerformed

    private void TrainerMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_TrainerMouseClicked
        // TODO add your handling code here:
    }// GEN-LAST:event_TrainerMouseClicked

    private void TrainerActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_TrainerActionPerformed
        // Navigate to Trainer Dashboard
        view.TrainerDashboardadmin trainerDashboard = new view.TrainerDashboardadmin();
        // Controller is loaded in TrainerDashboardadmin constructor
        trainerDashboard.setVisible(true);
        this.dispose();
    }// GEN-LAST:event_TrainerActionPerformed

    private void EquipmentActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_EquipmentActionPerformed
        // Navigate to Equipmentadmin
        view.Equipmentadmin equipmentDashboard = new view.Equipmentadmin();
        equipmentDashboard.setVisible(true);
        this.dispose();
    }// GEN-LAST:event_EquipmentActionPerformed

    private void FeedbackActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_FeedbackActionPerformed
        // Reload AdminFeedback (current page)
        view.AdminFeedback adminFeedback = new view.AdminFeedback();
        adminFeedback.setVisible(true);
        this.dispose();
    }// GEN-LAST:event_FeedbackActionPerformed

    private void ProfilebtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_ProfilebtnActionPerformed
        try {
            // Get current user
            model.UserData currentUser = model.CurrentUser.get();
            // Show user profile card
            view.Usercardnoremove userCard = new view.Usercardnoremove();
            userCard.updateUserData(currentUser);
            userCard.setVisible(true);
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error loading profile: " + e.getMessage());
        }
    }// GEN-LAST:event_ProfilebtnActionPerformed

    private void FeedbackMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_FeedbackMouseClicked
        // TODO add your handling code here:

    }// GEN-LAST:event_FeedbackMouseClicked

    private void displayAllFeedback() {
        controller.FeedbackController feedbackController = new controller.FeedbackController();
        java.util.List<model.FeedbackData> feedbackList = feedbackController.getAllFeedback();
        feedback.removeAll();
        // Already set to GridLayout in constructor
        for (model.FeedbackData data : feedbackList) {
            view.FeedbackCardPanel card = new view.FeedbackCardPanel();
            card.setFeedbackData(data);
            feedback.add(card);
        }
        feedback.revalidate();
        feedback.repaint();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminFeedback.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminFeedback.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminFeedback.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminFeedback.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminFeedback().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Equipment;
    private javax.swing.JButton Feedback;
    private javax.swing.JButton Members;
    private javax.swing.JLabel MembersText;
    private javax.swing.JButton Profilebtn;
    private javax.swing.JButton Trainer;
    private javax.swing.JPanel feedback;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
