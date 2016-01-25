/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.client.view.ui;

import edu.avans.ivh5.client.control.TreatmentController;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author ferdinand
 */
public class SchedulePanel extends javax.swing.JPanel {
    private final JFrame parentFrame;
    private final TreatmentController controller;

    /**
     * Creates new form ScedulePanel
     */
    public SchedulePanel(JFrame parentFrame, TreatmentController controller) {
        initComponents();
        
        this.parentFrame = parentFrame;
        this.controller = controller;
        System.out.println("setting ui reference");
        controller.setUIRef(this);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        sceduleTable = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();

        setMinimumSize(new java.awt.Dimension(800, 500));

        sceduleTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"08:00", null, null, null, null, null, null, null},
                {"08:30", null, null, null, null, null, null, null},
                {"09:00", null, null, null, null, null, null, null},
                {"09:30", null, null, null, null, null, null, null},
                {"10:00", null, null, null, null, null, null, null},
                {"10:30", null, null, null, null, null, null, null},
                {"11:00", null, null, null, null, null, null, null},
                {"11:30", null, null, null, null, null, null, null},
                {"12:00", null, null, null, null, null, null, null},
                {"12:30", null, null, null, null, null, null, null},
                {"13:00", null, null, null, null, null, null, null},
                {"13:30", null, null, null, null, null, null, null},
                {"14:00", null, null, null, null, null, null, null},
                {"14:30", null, null, null, null, null, null, null},
                {"15:00", null, null, null, null, null, null, null}
            },
            new String [] {
                "Tijd", "Zondag", "Maandag", "Dinsdag", "Woensdag", "Donderdag", "Vrijdag", "Zaterdag"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        sceduleTable.setMaximumSize(new java.awt.Dimension(930, 450));
        sceduleTable.setMinimumSize(new java.awt.Dimension(930, 450));
        jScrollPane1.setViewportView(sceduleTable);
        if (sceduleTable.getColumnModel().getColumnCount() > 0) {
            sceduleTable.getColumnModel().getColumn(5).setResizable(false);
            sceduleTable.getColumnModel().getColumn(7).setResizable(false);
        }

        jLabel1.setText("Datum:");

        jLabel2.setText("Fysiotherapeut");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 980, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(31, 31, 31)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(199, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable sceduleTable;
    // End of variables declaration//GEN-END:variables


 
    public void getTableData(){
        controller.getTableData();
    }
    
        public void fillJComboBox(ArrayList<String> names){
        
            for(String name: names)
                //System.out.println(name);
                this.jComboBox1.addItem(name);
    }

         public void addToCombobox(String name){
            System.out.println("addToCombobox: " + name);
             
            this.jComboBox1.addItem(name);
     }

}
