/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.RegisterationPanels;

import Business.DB4OUtil.DB4OUtil;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import java.awt.CardLayout;
import javax.swing.JPanel;
import Business.EcoSystem;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import Business.UserAccount.UserAccountDirectory;

/**
 *
 * @author prabh
 */
public class RegisterationSelectionJPanel extends javax.swing.JPanel {

    /**
     * Creates new form RegisterationSelection
     */
    JPanel userProcessContainer;
    EcoSystem system;
//    DB4OUtil dB4OUtil;
    public RegisterationSelectionJPanel(JPanel userProcessContainer, EcoSystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.system = system;
//        this.dB4OUtil=dB4OUtil;
        populateComboBox();
    }

    private void populateComboBox() {
        registerationSelectionComboBox.removeAllItems();
        for (Role.RoleType type : Role.RoleType.values()) {
            registerationSelectionComboBox.addItem(type);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        registerationSelectionComboBox = new javax.swing.JComboBox();
        nextBtn = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Kindly select the registeration for:");

        nextBtn.setText("Next >");
        nextBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nextBtn)
                    .addComponent(registerationSelectionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(299, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(169, 169, 169)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(registerationSelectionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(nextBtn)
                .addContainerGap(282, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

//    private void nextBtnActionPerformed(java.awt.event.ActionEvent evt) {                                        
//        // TODO add your handling code here:
//        if (registerationSelectionComboBox.getSelectedItem().toString().equals("Provider")) {
//            ProviderAdminRegistrationWorkAreaJPanel provRegPnl = new ProviderAdminRegistrationWorkAreaJPanel(userProcessContainer, system);
//            userProcessContainer.add("ProviderRegistrationJPanel", provRegPnl);
//            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
//            layout.next(userProcessContainer);
//        }
//    }

    private void nextBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextBtnActionPerformed
        // TODO add your handling code here:
        Role.RoleType roleType = (Role.RoleType) registerationSelectionComboBox.getSelectedItem();

        if (registerationSelectionComboBox.getSelectedItem().toString().equals("Customer")) {
            RegisterCustomerJPanel regisCust = new RegisterCustomerJPanel(userProcessContainer, roleType, system);
            userProcessContainer.add("RegisterHospitalJPanel", regisCust);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        }


    }//GEN-LAST:event_nextBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton nextBtn;
    private javax.swing.JComboBox registerationSelectionComboBox;
    // End of variables declaration//GEN-END:variables
}
