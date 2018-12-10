/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.ProviderAdminRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.OrganQueue.OrganRequest;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author prabh
 */
public class OrganRequestJPanel extends javax.swing.JPanel {

    /**
     * Creates new form OrganRequestJPanel
     */
    JPanel userProcessContainer;
    Enterprise enterprise;
    UserAccount userAccount;
    EcoSystem ecoSystem;
    public OrganRequestJPanel(JPanel userProcessContainer, Enterprise enterprise, UserAccount userAccount, EcoSystem ecoSystem) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.enterprise=enterprise;
        this.userAccount=userAccount;
        this.ecoSystem=ecoSystem;
        populateOrganRequestTbl();
    }
    
    public void populateOrganRequestTbl() {
        DefaultTableModel model = (DefaultTableModel) organRqstTable.getModel();

        for (UserAccount u : enterprise.getUserAccountDirectory().getUserAccountList()) {
            for (OrganRequest request : u.getOrganQueue().getOrganList()) {
                Object[] row = new Object[7];
                row[0] = request;
                row[1] = request.getQty();
                row[2] = request.getStatus();
                row[3] = request.getSender();
                row[4] = request.getSchool();
                row[5] = request.getProvider();
                row[6] = request.getMsg();

                model.addRow(row);
            }
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

        jScrollPane2 = new javax.swing.JScrollPane();
        organRqstTable = new javax.swing.JTable();

        organRqstTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Organ", "qty", "Status", "Sender", "Reciever", "Provider", "message"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(organRqstTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 654, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(169, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(172, 172, 172)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(224, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable organRqstTable;
    // End of variables declaration//GEN-END:variables
}
