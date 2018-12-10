/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.RegisterationPanels;

import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Enterprise.*;
import Business.Network.Network;
import Business.Organization.DoctorOrganization;
import Business.Organization.LabOrganization;
import Business.Organization.Organization;
import static Business.Organization.Organization.Type.Doctor;
import Business.Organization.OrganizationDirectory;
import Business.Role.AdminRole;
import Business.Role.DoctorRole;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.AccessApprovalRequest;
import Business.WorkQueue.DoctorRegistrationRequest;
import Business.WorkQueue.LabTestWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import Business.Organization.Organization.Type;
import Business.Role.LabAssistantRole;
import Business.Role.MedicalSchoolLabRole;
import userinterface.MedicalSchoolLabAssistAdminRole.MedicalLabWorkAreaJPanel;

/**
 *
 * @author hp
 */
public class RegisterDoctorJPanel extends javax.swing.JPanel {

    /**
     * Creates new form RegisterMedicalSchool
     */
    JPanel userProcessContainer;
    EcoSystem system;
    private Enterprise enterprise;
    private Organization organization;
    private UserAccount userAccount;
    private Role role;
    private Role.RoleType roleSelect;

    public RegisterDoctorJPanel(JPanel userProcessContainer, EcoSystem system, Role role, Role.RoleType roleSelect) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.system = system;
        this.role = role;
        this.roleSelect = roleSelect;
        populateNetworkComboBox();
        if (roleSelect.equals(Role.RoleType.Doctor)) {
            msgTxt.setText("Doctor");
        } else if (roleSelect.equals(Role.RoleType.LabAssistant)) {
            msgTxt.setText("Lab Assistant");
        } else {
            msgTxt.setText("Medical School Lab");
        }

    }

    private void populateNetworkComboBox() {
        networkJComboBox.removeAllItems();
        for (Network network : system.getNetworkList()) {
            networkJComboBox.addItem(network);
        }
    }

    private void populateEnterpriseComboBox(Network n) {
        enterpriseJComboBox.removeAllItems();
        for (Enterprise enter : n.getEnterpriseDirectory().getEnterpriseList()) {
            if (roleSelect.equals(Role.RoleType.Doctor) || roleSelect.equals(Role.RoleType.LabAssistant)) {
                if (enter.getEnterpriseType().equals(Enterprise.EnterpriseType.HealthCareProvider)) {
                    enterpriseJComboBox.addItem(enter);
                }
            }else{
                if(enter.getEnterpriseType().equals(Enterprise.EnterpriseType.MedicalSchool))
                enterpriseJComboBox.addItem(enter);
            }
        }

    }

    private void create(Enterprise ent, Organization org) {
        Employee empDoctor = org.getEmployeeDirectory().createEmployee(txtFiledFname.getText(), null, null, networkJComboBox.getSelectedItem().toString(), ent.getEnterpriseType().toString());
        UserAccount ua = org.getUserAccountDirectory().createEmployeeAccount(userNameTxt.getText(), pwsTxt.getText(), empDoctor, role);

        AccessApprovalRequest request = new AccessApprovalRequest();
        request.setRole(roleSelect.toString());
        request.setSender(ua);
        request.setStatus("Pending");

        for (UserAccount u : ent.getUserAccountDirectory().getUserAccountList()) {
            if (u.getUsername().equalsIgnoreCase(ent.getName())) {
                u.getWorkQueue().getWorkRequestList().add(request);
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

        jComboBox1 = new javax.swing.JComboBox<String>();
        msgTxt = new javax.swing.JLabel();
        txtFiledFname = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        textFieldLname = new javax.swing.JTextField();
        textFieldept = new javax.swing.JTextField();
        txtFieldSSN = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        registerBtn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        userNameTxt = new javax.swing.JTextField();
        pwsTxt = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        networkJComboBox = new javax.swing.JComboBox();
        enterpriseJComboBox = new javax.swing.JComboBox();
        backBtn = new javax.swing.JButton();
        txtfieldRetype = new javax.swing.JPasswordField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        userNameMsg1 = new javax.swing.JLabel();
        userNameMsg2 = new javax.swing.JLabel();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 5));
        setMaximumSize(new java.awt.Dimension(602, 390));
        setPreferredSize(new java.awt.Dimension(700, 390));

        msgTxt.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        msgTxt.setForeground(new java.awt.Color(0, 102, 51));

        jLabel2.setText("First Name:");

        jLabel3.setText("Last Name:");

        jLabel4.setText("Department: ");

        jLabel5.setText("Employee Id");

        jLabel6.setText("Region:");

        registerBtn.setText("Register");
        registerBtn.setEnabled(false);
        registerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerBtnActionPerformed(evt);
            }
        });

        jLabel7.setText("Select Provider:");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 51));
        jLabel8.setText("Create:");

        userNameTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                userNameTxtKeyReleased(evt);
            }
        });

        jLabel9.setText("Password:");

        jLabel10.setText("User Name:");

        networkJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        networkJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                networkJComboBoxActionPerformed(evt);
            }
        });

        enterpriseJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        enterpriseJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterpriseJComboBoxActionPerformed(evt);
            }
        });

        backBtn.setText("<<  Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        txtfieldRetype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfieldRetypeActionPerformed(evt);
            }
        });
        txtfieldRetype.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtfieldRetypeKeyTyped(evt);
            }
        });

        jLabel11.setText("Re-Type Pass:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 102, 51));
        jLabel12.setText("Register as ");

        userNameMsg1.setForeground(new java.awt.Color(251, 51, 51));

        userNameMsg2.setForeground(new java.awt.Color(0, 204, 102));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(msgTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(txtFiledFname, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(textFieldLname, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(textFieldept, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(txtFieldSSN, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(networkJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(enterpriseJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(userNameTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                            .addComponent(userNameMsg2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(10, 10, 10)
                                .addComponent(userNameMsg1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pwsTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtfieldRetype, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(315, 315, 315)
                        .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(130, 130, 130)
                        .addComponent(registerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(msgTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtFiledFname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(textFieldLname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(textFieldept, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFieldSSN, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel6))
                            .addComponent(networkJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel7))
                            .addComponent(enterpriseJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(userNameMsg1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(userNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(userNameMsg2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pwsTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtfieldRetype, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(registerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(115, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void registerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerBtnActionPerformed
        // TODO add your handling code here:
        if (txtFiledFname.getText().isEmpty() && txtFieldSSN.getText().isEmpty() && textFieldLname.getText().isEmpty() && textFieldept.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill mandatory fields");
        } else {
            Enterprise ent = (Enterprise) enterpriseJComboBox.getSelectedItem();
            OrganizationDirectory directory = ent.getOrganizationDirectory();

            if (roleSelect.equals(Role.RoleType.Doctor)) {

                Organization.Type type = Organization.Type.Doctor;
                Organization org = directory.createOrganization(type);

                Employee empDoctor = org.getEmployeeDirectory().createEmployee(txtFiledFname.getText(),
                        textFieldept.getText(), null, networkJComboBox.getSelectedItem().toString(),
                        type.toString());
                UserAccount ua = org.getUserAccountDirectory().createEmployeeAccount(userNameTxt.getText(), pwsTxt.getText(), empDoctor, new DoctorRole());

                for (UserAccount entAccount : ent.getUserAccountDirectory().getUserAccountList()) {
                    System.out.println(entAccount);

                }

                AccessApprovalRequest request = new AccessApprovalRequest();
                request.setRole(roleSelect.toString());
                request.setSender(ua);
                request.setStatus("Pending");
                for (UserAccount u : ent.getUserAccountDirectory().getUserAccountList()) {
                    if (u.getUsername().equalsIgnoreCase(ent.getName())) {
                        System.out.println(u.getUsername() + " " + u.getRole());
                        u.getWorkQueue().getWorkRequestList().add(request);
                    }

                }
                empDoctor.setRegStatus(request.getStatus());

            } else if (roleSelect.equals(Role.RoleType.LabAssistant)) {
                Organization.Type type = Organization.Type.Lab;
                Organization org = ent.getOrganizationDirectory().createOrganization(type);

                Employee empDoctor = org.getEmployeeDirectory().createEmployee(txtFiledFname.getText(), null, textFieldept.getText(), networkJComboBox.getSelectedItem().toString(), type.toString());
                UserAccount ua = org.getUserAccountDirectory().createEmployeeAccount(userNameTxt.getText(), pwsTxt.getText(), empDoctor, new LabAssistantRole());

                for (UserAccount entAccount : ent.getUserAccountDirectory().getUserAccountList()) {
                    System.out.println(entAccount);

                }

                AccessApprovalRequest request = new AccessApprovalRequest();
                request.setRole(roleSelect.toString());
                request.setSender(ua);
                request.setStatus("Pending");
                for (UserAccount u : ent.getUserAccountDirectory().getUserAccountList()) {
                    if (u.getUsername().equalsIgnoreCase(ent.getName())) {
                        System.out.println(u.getUsername() + " " + u.getRole());
                        u.getWorkQueue().getWorkRequestList().add(request);
                    }

                }
                empDoctor.setRegStatus(request.getStatus());

            } else if (roleSelect.equals(Role.RoleType.MedicalSchoolLab)) {
                Organization.Type type = Organization.Type.Lab;
                Organization org = ent.getOrganizationDirectory().createOrganization(type);

                Employee empDoctor = org.getEmployeeDirectory().createEmployee(txtFiledFname.getText(), null, textFieldept.getText(), networkJComboBox.getSelectedItem().toString(), type.toString());
                UserAccount ua = org.getUserAccountDirectory().createEmployeeAccount(userNameTxt.getText(), pwsTxt.getText(), empDoctor, new MedicalSchoolLabRole());

                for (UserAccount entAccount : ent.getUserAccountDirectory().getUserAccountList()) {
                    System.out.println(entAccount);

                }
                AccessApprovalRequest request = new AccessApprovalRequest();
                request.setRole(roleSelect.toString());
                request.setSender(ua);
                request.setStatus("Pending");
                for (UserAccount u : ent.getUserAccountDirectory().getUserAccountList()) {
                    if (u.getUsername().equalsIgnoreCase(ent.getName())) {
                        System.out.println(u.getUsername() + " " + u.getRole());
                        u.getWorkQueue().getWorkRequestList().add(request);
                    }

                }

            }

            JOptionPane.showMessageDialog(null, "Request successfully sent to provider \n Your status is Pending");
            RegisterationSelectionJPanel origin = new RegisterationSelectionJPanel(userProcessContainer, system, role);
            userProcessContainer.add("Original Panel", origin);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);

        }
    }//GEN-LAST:event_registerBtnActionPerformed

    private void networkJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_networkJComboBoxActionPerformed
        // TODO add your handling code here:
        Network network = (Network) networkJComboBox.getSelectedItem();
        if (network != null) {
            populateEnterpriseComboBox(network);
        }
    }//GEN-LAST:event_networkJComboBoxActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backBtnActionPerformed

    private void userNameTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userNameTxtKeyReleased
        // TODO add your handling code here:
        userNameMsg1.setText("");
        userNameMsg2.setText("");
        for (UserAccount ua : system.getUserAccountDirectory().getUserAccountList()) {
            if (ua.getUsername().equalsIgnoreCase(userNameTxt.getText())) {
                System.out.println(ua.getUsername());
                userNameMsg1.setText("Username is not available");
                userNameMsg2.setText("");
            } else {
                userNameMsg1.setText("");
                userNameMsg2.setText("Available");
            }
        }
    }//GEN-LAST:event_userNameTxtKeyReleased

    private void txtfieldRetypeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfieldRetypeKeyTyped
        // TODO add your handling code here:
        checkForButtonVisibility();
        String check = "" + evt.getKeyChar();
        String compare = txtfieldRetype.getText();
        if (!check.isEmpty()) {
            compare += check;
        }
        if (pwsTxt.getText().equals(compare)
                && userNameMsg2.getText().equals("Available")) {
            registerBtn.setEnabled(true);
            txtfieldRetype.setBackground(Color.white);
        } else {
            registerBtn.setEnabled(false);
            txtfieldRetype.setBackground(Color.red);
        }
    }//GEN-LAST:event_txtfieldRetypeKeyTyped

    private void txtfieldRetypeActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        userNameMsg1.setText("");
        userNameMsg2.setText("");
        for (UserAccount ua : system.getUserAccountDirectory().getUserAccountList()) {
            if (ua.getUsername().equalsIgnoreCase(userNameTxt.getText())) {
                System.out.println(ua.getUsername());
                userNameMsg1.setText("Username is not available");
                userNameMsg2.setText("");
            } else {
                userNameMsg1.setText("");
                userNameMsg2.setText("Available");
            }
        }
    }

    private void enterpriseJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterpriseJComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_enterpriseJComboBoxActionPerformed

    public boolean passwordPatternCorrect() {
        Pattern p = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$");
        Matcher m = p.matcher(pwsTxt.getText());
        boolean b = m.matches();
        if (b == true) {
            System.out.println("There is special character in my string");
            return false;
        } else {
            System.out.println("There is no speacial character");
            return true;
        }

    }

    public void checkForButtonVisibility() {
        if (!userNameTxt.getText().isEmpty()
                && !pwsTxt.getText().isEmpty()
                && !txtfieldRetype.getText().isEmpty()) {
            registerBtn.setEnabled(true);
        } else {
            registerBtn.setEnabled(false);
        }

    }

    private void initialize() {
        checkForButtonVisibility();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JComboBox enterpriseJComboBox;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel msgTxt;
    private javax.swing.JComboBox networkJComboBox;
    private javax.swing.JPasswordField pwsTxt;
    private javax.swing.JButton registerBtn;
    private javax.swing.JTextField textFieldLname;
    private javax.swing.JTextField textFieldept;
    private javax.swing.JTextField txtFieldSSN;
    private javax.swing.JTextField txtFiledFname;
    private javax.swing.JPasswordField txtfieldRetype;
    private javax.swing.JLabel userNameMsg1;
    private javax.swing.JLabel userNameMsg2;
    private javax.swing.JTextField userNameTxt;
    // End of variables declaration//GEN-END:variables
}
