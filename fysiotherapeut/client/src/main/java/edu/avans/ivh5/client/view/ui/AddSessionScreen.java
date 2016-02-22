/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.client.view.ui;

import edu.avans.ivh5.client.control.TreatmentAndSessionController;
import edu.avans.ivh5.shared.model.domain.Session;
import edu.avans.ivh5.shared.model.domain.Treatment;
import edu.avans.ivh5.shared.model.domain.TreatmentType;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ferdinand
 */
public class AddSessionScreen extends javax.swing.JFrame {
    private TreatmentAndSessionController controller;
    private int treatmentID;

    /**
     * Creates new form AddTreatmentScreen2
     */
    public AddSessionScreen(TreatmentAndSessionController treatmentAndSessionController, int treatmentID ) {
        this.controller = treatmentAndSessionController;
        
            
        initComponents();
           controller.setUIRef(this);
           fillTherapistComboBox();
           fillTreatmentCodeComboBox();
           saveButton.setActionCommand("save treatment");
           saveButton.addActionListener( controller );
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        therapistComboBox = new javax.swing.JComboBox();
        idLabel = new javax.swing.JLabel();
        firstnameLabel1 = new javax.swing.JLabel();
        lastnameLabel1 = new javax.swing.JLabel();
        telLabel1 = new javax.swing.JLabel();
        mailLabel1 = new javax.swing.JLabel();
        idTextField = new javax.swing.JTextField();
        firstnameTextField1 = new javax.swing.JTextField();
        lastnameTextField1 = new javax.swing.JTextField();
        telTextField = new javax.swing.JTextField();
        mailTextField1 = new javax.swing.JTextField();
        bsnLabel = new javax.swing.JLabel();
        firstnameLabel2 = new javax.swing.JLabel();
        lastnameLabel2 = new javax.swing.JLabel();
        telLabel = new javax.swing.JLabel();
        mailLabel = new javax.swing.JLabel();
        bsnTextField = new javax.swing.JTextField();
        firstnameTextField2 = new javax.swing.JTextField();
        lastnameTextField2 = new javax.swing.JTextField();
        telTextField2 = new javax.swing.JTextField();
        mailTextField2 = new javax.swing.JTextField();
        therapeutLabel = new javax.swing.JLabel();
        klantLabel = new javax.swing.JLabel();
        treatmentcodeLabel = new javax.swing.JLabel();
        treatmentcodeComboBox = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        commentsTextArea = new javax.swing.JTextArea();
        sessionLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        sessionsTable = new javax.swing.JTable();
        cancelButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        clientSearchField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        therapistComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        therapistComboBox.setName(""); // NOI18N

        idLabel.setText("ID");

        firstnameLabel1.setText("Voornaam");

        lastnameLabel1.setText("Achternaam");

        telLabel1.setText("Tel");

        mailLabel1.setText("Mail");

        bsnLabel.setText("BSN");

        firstnameLabel2.setText("Voornaam");

        lastnameLabel2.setText("Achternaam");

        telLabel.setText("Tel");

        mailLabel.setText("Mail");

        therapeutLabel.setText("Fysiotherapeut");

        klantLabel.setText("Zoek klant op BSN");

        treatmentcodeLabel.setText("Behandelcode:");

        treatmentcodeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        treatmentcodeComboBox.setName(""); // NOI18N

        commentsTextArea.setColumns(20);
        commentsTextArea.setRows(5);
        commentsTextArea.setBorder(javax.swing.BorderFactory.createTitledBorder("Opmerkingen"));
        jScrollPane1.setViewportView(commentsTextArea);

        sessionLabel.setText("Sessies");

        jButton1.setBackground(new java.awt.Color(255, 0, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("-");

        jButton2.setBackground(new java.awt.Color(0, 204, 0));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("+");

        sessionsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Datum", "Begintijd", "eindtijd"
            }
        ));
        jScrollPane2.setViewportView(sessionsTable);

        cancelButton.setText("Annuleren");

        saveButton.setText("Opslaan");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(therapeutLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(therapistComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(134, 134, 134)
                .addComponent(klantLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(34, 34, 34))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(treatmentcodeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lastnameLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(idLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(mailLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(telLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(firstnameLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(idTextField)
                                            .addComponent(firstnameTextField1)
                                            .addComponent(lastnameTextField1)
                                            .addComponent(telTextField)
                                            .addComponent(mailTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(treatmentcodeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(95, 95, 95)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(clientSearchField)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(bsnLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(lastnameLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(telLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(firstnameLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(mailLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(bsnTextField)
                                                    .addComponent(firstnameTextField2)
                                                    .addComponent(lastnameTextField2)
                                                    .addComponent(telTextField2)
                                                    .addComponent(mailTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)))))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(sessionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(123, 123, 123)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(therapeutLabel)
                    .addComponent(klantLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(therapistComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(clientSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(idLabel)
                                                    .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(bsnLabel)
                                                    .addComponent(bsnTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(firstnameLabel1))
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(firstnameTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(firstnameLabel2)
                                                .addComponent(firstnameTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lastnameLabel1))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lastnameTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lastnameLabel2)
                                        .addComponent(lastnameTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(telLabel1))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(telTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(telLabel)
                                .addComponent(telTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mailLabel1))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(mailTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(mailLabel)
                        .addComponent(mailTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(treatmentcodeLabel)
                    .addComponent(treatmentcodeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sessionLabel)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(cancelButton))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bsnLabel;
    private javax.swing.JTextField bsnTextField;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField clientSearchField;
    private javax.swing.JTextArea commentsTextArea;
    private javax.swing.JLabel firstnameLabel1;
    private javax.swing.JLabel firstnameLabel2;
    private javax.swing.JTextField firstnameTextField1;
    private javax.swing.JTextField firstnameTextField2;
    private javax.swing.JLabel idLabel;
    private javax.swing.JTextField idTextField;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel klantLabel;
    private javax.swing.JLabel lastnameLabel1;
    private javax.swing.JLabel lastnameLabel2;
    private javax.swing.JTextField lastnameTextField1;
    private javax.swing.JTextField lastnameTextField2;
    private javax.swing.JLabel mailLabel;
    private javax.swing.JLabel mailLabel1;
    private javax.swing.JTextField mailTextField1;
    private javax.swing.JTextField mailTextField2;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel sessionLabel;
    private javax.swing.JTable sessionsTable;
    private javax.swing.JLabel telLabel;
    private javax.swing.JLabel telLabel1;
    private javax.swing.JTextField telTextField;
    private javax.swing.JTextField telTextField2;
    private javax.swing.JLabel therapeutLabel;
    private javax.swing.JComboBox therapistComboBox;
    private javax.swing.JComboBox treatmentcodeComboBox;
    private javax.swing.JLabel treatmentcodeLabel;
    // End of variables declaration//GEN-END:variables

public void fillTherapistComboBox(){
            therapistComboBox.setModel(new DefaultComboBoxModel());
            for (Object item : controller.getEmployees())
                therapistComboBox.addItem(item); 
}

public void fillTreatmentCodeComboBox(){
    treatmentcodeComboBox.setModel(new DefaultComboBoxModel());
    for (Object item: controller.getTreatmentTypes()){
        
        treatmentcodeComboBox.addItem(item);
    }
}

public Treatment saveTreatment(){
        int treatmentID = 0;
        String treatmentCode = (String) treatmentcodeComboBox.getSelectedItem();
        String BSN = bsnTextField.getText();
        String PhysioTherapistLastName = lastnameTextField1.getText();
        String Status = "actief";
        
        Treatment newTreatment = new Treatment(treatmentID, treatmentCode, BSN, PhysioTherapistLastName, Status);
        System.out.println("reached return");
        return newTreatment;
    }


public void insertRow(){
    DefaultTableModel model = (DefaultTableModel) sessionsTable.getModel();
    int newRow = sessionsTable.getRowCount();
    model.insertRow(newRow, new Object[]{"","",""});
}

public Session saveSession(){

   System.out.println("saveSession in screen");
    int newRow = sessionsTable.getRowCount()-1;
    System.out.println("rowcount " + newRow);
    String date = (String) sessionsTable.getValueAt(newRow, 0);
    System.out.println("test date " + date);
    String startTime = (String) sessionsTable.getValueAt(newRow, 1);
    String endTime = (String) sessionsTable.getValueAt(newRow, 2);
    String notes = commentsTextArea.getText();
    String id = "" + treatmentID;
    Session session = new Session(date, startTime, endTime, notes, id);
    
    return session;
}

/*
public Treatment saveNewTreatment(){
        int treatmentID = 0;
        String treatmentCode = (String) treatmentcodeComboBox.getSelectedItem();
        String BSN = bsnTextField.getText();
        String PhysioTherapistLastName = lastnameTextField1.getText();
        String Status = "actief";
        
        Treatment newTreatment = new Treatment(treatmentID, treatmentCode, BSN, PhysioTherapistLastName, Status);
        System.out.println("reached return");
        return newTreatment;
    }
*/
}


