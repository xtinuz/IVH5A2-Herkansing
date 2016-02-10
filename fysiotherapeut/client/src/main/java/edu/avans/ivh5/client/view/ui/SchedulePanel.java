/*//GEN-LINE:variables
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.client.view.ui;


import edu.avans.ivh5.client.control.TreatmentAndSessionController;
import java.util.ArrayList;
import edu.avans.ivh5.client.control.ScheduleController;
import edu.avans.ivh5.shared.model.domain.Employee;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
/**
 *
 * @author ferdinand
 */
public class SchedulePanel extends javax.swing.JPanel {
    private final JFrame parentFrame;
    private final ScheduleController controller;
    /**
     * Creates new form ScedulePanel
     */
    public SchedulePanel(JFrame parentFrame, ScheduleController controller) {
        initComponents();
        
        this.parentFrame = parentFrame;
        this.controller = controller;
        System.out.println("setting ui reference");
        controller.setUIRef(this);
        

        jButton1.setActionCommand("refresh table");
        jButton1.addActionListener(controller);
        jComboBox1.setModel(new DefaultComboBoxModel());
        for (Object item : controller.getEmployees())
        jComboBox1.addItem(item);
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        sceduleTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        monthComboBox = new javax.swing.JComboBox();
        dayComboBox = new javax.swing.JComboBox();
        yearComboBox = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(800, 500));
        setName(""); // NOI18N

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

        monthComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));

        dayComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        yearComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2016", "2015" }));

        jButton1.setText("Refresh");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
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
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 980, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(monthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(239, Short.MAX_VALUE))
        );
    }// </editor-fold>                        


    // Variables declaration - do not modify                     
    private javax.swing.JComboBox dayComboBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox monthComboBox;
    private javax.swing.JTable sceduleTable;
    private javax.swing.JComboBox yearComboBox;
    // End of variables declaration                   


    public String getDate(){
        
        String day = (String) dayComboBox.getSelectedItem();
        String month = (String) monthComboBox.getSelectedItem();
        String year = (String) yearComboBox.getSelectedItem();
        
        String stringDate = day + month + year;
        System.out.println(stringDate);
        return stringDate;
        
    }
    
//        public void fillJComboBox(ArrayList<String> names){
//        
//            for(String name: names)
//                //System.out.println(name);
//                this.jComboBox1.addItem(name);
//    }
//
//
//         public void addToCombobox(ArrayList<Employee> employees){
//        employees = controller.getEmployees();
//        System.out.println("got employees in panel");
//            for(Employee e: employees)
//                
//                jComboBox1.addItem(e);
//                System.out.println("looped employees");
//        
//     }
}
