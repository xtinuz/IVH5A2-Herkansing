/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.client.view.ui;

import edu.avans.ivh5.client.control.ScheduleController;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author ferdinand
 */
public class SchedulePanel2 extends javax.swing.JFrame {
    private final JFrame parentFrame;
    private final ScheduleController controller;

    /**
     * Creates new form SchedulePanel2
     */
    public SchedulePanel2( JFrame parentFrame, ScheduleController controller ) {
        initComponents();
        
        getTherapistFromComboBox();        
        this.parentFrame = parentFrame;
        this.controller = controller;
        System.out.println("setting ui reference");
        //controller.setUIRef(this);
        

        jButton1.setActionCommand("refresh table");
        jButton1.addActionListener(controller);
        therapistComboBox.setModel(new DefaultComboBoxModel());
        for (Object item : controller.getEmployees())
        therapistComboBox.addItem(item);
        
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
        jScrollPane1 = new javax.swing.JScrollPane();
        sceduleTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        therapistComboBox = new javax.swing.JComboBox();
        monthComboBox = new javax.swing.JComboBox();
        dayComboBox = new javax.swing.JComboBox();
        yearComboBox = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setName(""); // NOI18N

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
        sceduleTable.setIntercellSpacing(new java.awt.Dimension(2, 2));
        sceduleTable.setMaximumSize(new java.awt.Dimension(930, 450));
        sceduleTable.setMinimumSize(new java.awt.Dimension(930, 450));
        sceduleTable.setRowHeight(24);
        sceduleTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(sceduleTable);

        jLabel1.setText("Datum:");

        jLabel2.setText("Fysiotherapeut");

        monthComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));

        dayComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        yearComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2016", "2015" }));

        jButton1.setText("Refresh");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(monthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dayComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(yearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(therapistComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 980, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(therapistComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(monthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 709, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SchedulePanel2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SchedulePanel2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SchedulePanel2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SchedulePanel2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new SchedulePanel2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox dayComboBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox monthComboBox;
    private javax.swing.JTable sceduleTable;
    private javax.swing.JComboBox therapistComboBox;
    private javax.swing.JComboBox yearComboBox;
    // End of variables declaration//GEN-END:variables

    public Date getDate(){
        Date date = null;
        try{
        String day = (String) dayComboBox.getSelectedItem();
        String month = (String) monthComboBox.getSelectedItem();
        String year = (String) yearComboBox.getSelectedItem();
        
        String stringDate = day + month + year;
        Date formattedDate = new SimpleDateFormat("ddMMMMyyyy", Locale.US).parse(stringDate);
        date = formattedDate;
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        
        return date;
    }
    
    public String getTherapistFromComboBox(){
        String therapist = (String) therapistComboBox.getSelectedItem();
        return therapist;
        
    }
/*    
    public String getTherapistFromComboBox(){
        String therapist = (String) therapistComboBox.getSelectedItem();
        return therapist;
    }
*/    
    
    
    public void setTableHeaderDates(Date date){
        ArrayList datesOfweek;
        String[] days = {"Zondag" ,"Maandag", "Dinsdag", "Woensdag", "Donderdag", "Vrijdag","Zaterdag"};
        try {
            ArrayList datesOfWeek = controller.getScheduleDates( date );
            JTableHeader th = sceduleTable.getTableHeader();
            TableColumnModel tcm = th.getColumnModel();
            for(int x = 1, y = tcm.getColumnCount()-1; x <= y; x++)
            {
                TableColumn tc = tcm.getColumn(x);
                tc.setHeaderValue("" + days[x-1] + " " + datesOfWeek.get(x-1) );
                //sceduleTable.repaint();
                
            }
            
            th.repaint();
            //sceduleTable.repaint();
            
        } catch (ParseException ex) {
            Logger.getLogger(SchedulePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}