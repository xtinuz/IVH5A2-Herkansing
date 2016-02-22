/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.client.view.ui;

import edu.avans.ivh5.client.control.TreatmentAndSessionController;
import edu.avans.ivh5.shared.model.domain.Treatment;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


public class TreatmentPanel extends JPanel {

    private JButton logOutButton, newButton, changeButton, deleteButton;
    private JComboBox employeeBox;
    private JLabel overviewLabel;
    //private JTextField searchField;
    private final TreatmentAndSessionController controller;
    private JFrame parentFrame;
    private JTable treatmentTable;
    private JMenuItem alter, delete;
    private DefaultTableModel dtm;

    public TreatmentPanel(JFrame parentFrame, TreatmentAndSessionController controller) {
        this.controller = controller;
        this.parentFrame = parentFrame;
        dtm = new DefaultTableModel();
        System.out.println("setting ui reference TreatmentPanel");
        controller.setUIRef(this);
        setLayout(new BorderLayout());
        add(createNorthPanel(), BorderLayout.NORTH);
        add(createCenterPanel(), BorderLayout.CENTER);
        
        this.controller.addTreatments();
    }

    private JPanel createNorthPanel() {
        JPanel panel = new JPanel();
        // panel consists of 5 columns and 3 rows
        panel.setLayout(new GridLayout(3, 5, 10, 10));

        // Begin row 1
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));

        logOutButton = new JButton("Log uit");
        logOutButton.setActionCommand("logout");
        logOutButton.addActionListener(controller);
        panel.add(logOutButton);
        // end row 1

        // begin row 2
        employeeBox = new JComboBox();
        panel.add(employeeBox);

        panel.add(new JLabel(""));

        newButton = new JButton("Toevoegen");
        newButton.setActionCommand("newTreatment");
        newButton.addActionListener(controller);
        panel.add(newButton);
        
        changeButton = new JButton("Wijzig");
        changeButton.setActionCommand("openAlterScreen");
        changeButton.addActionListener(controller);
        panel.add(changeButton);
        
        deleteButton = new JButton("Verwijder");
        deleteButton.setActionCommand("deleteTreatment");
        deleteButton.addActionListener(controller);
        panel.add(deleteButton);
        // end row 2

        // begin row 3
        overviewLabel = new JLabel("Overzicht behandelingen: ");
        overviewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        panel.add(overviewLabel);

        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));

        /*
        searchField = new JTextField();
        panel.add(searchField); */
        // end row 3

        return panel;
    }

   private JPanel createCenterPanel() {
//        JPanel panel = new JPanel(new GridLayout(1, 1));
//        panel.setBorder(new EmptyBorder(15, 10, 0, 10));
        JPanel panel = new JPanel();

        panel.setLayout(new BorderLayout());

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(1, 5));
        JLabel label = new JLabel("Behandelingen: ");
        label.setFont(new Font("Arial", Font.PLAIN, 20));
        northPanel.add(label);

        JPanel centerPanel = new JPanel(new GridLayout(1, 1));
        centerPanel.setBorder(new EmptyBorder(15, 10, 0, 10));
        
        dtm.addColumn("treatmentid");
        dtm.addColumn("Treatmentcode");
        dtm.addColumn("KlantBSN");
        dtm.addColumn("FysioTherapeutAchternaam");
        dtm.addColumn("Status");
        treatmentTable = new JTable(dtm);
        treatmentTable.setFillsViewportHeight(true);
        treatmentTable.getTableHeader().setBackground(Color.CYAN);
        treatmentTable.addMouseListener(controller);
        
//        treatmentTable = new JTable(rowData, columnNames);
//        treatmentTable.setFillsViewportHeight(true);
//        treatmentTable.getTableHeader().setBackground(Color.CYAN);
//        treatmentTable.addMouseListener(new MouseListener() {

            
/*            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    int row = treatmentTable.rowAtPoint(new Point(e.getX(), e.getY()));
                    // if the row is empty it will return -1
                    // you will not be able to right click on an empty row
                    if (row != -1) {
                        createRightClickMenu(row).show(treatmentTable, e.getX(), e.getY());
                    }
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

        });*/

        // Make the table vertically scrollable
        JScrollPane scrollPane = new JScrollPane(treatmentTable);

        centerPanel.add(scrollPane);

        panel.add(northPanel, BorderLayout.NORTH);
        panel.add(centerPanel, BorderLayout.CENTER);
        
        return panel;
    }
   
   public void removeTreatmentByTreatmentIDDIRTY(){
       for(int i = 0; i < dtm.getRowCount(); i++){//For each row
            if(dtm.getValueAt(i, 0).equals(this.getTreatmentID())){//Search the model
                dtm.removeRow(i);
            }
        }
   }
   

    public int getTreatmentID() {
        //System.out.println("Dit moet de ID ZIJN: " + (String) treatmentTable.getValueAt(treatmentTable.getSelectedRow(), 0));
        return Integer.parseInt(treatmentTable.getValueAt(treatmentTable.getSelectedRow(), 0).toString());
//        return Integer.parseInt( (String) treatmentTable.getValueAt(treatmentTable.getSelectedRow(), 0));
    }
    
    public JPopupMenu createRightClickMenu(int row) {
        JPopupMenu menu = new JPopupMenu();

        String id = "";

        try {
            id = treatmentTable.getValueAt(row, 0) + "";
        } catch (Exception ex) {
        }

        alter = new JMenuItem("Wijzig behandeling " + id);
        alter.setName("" + row);
        alter.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // alterEmployee();
            }

        });

        delete = new JMenuItem("Verwijder behandeling " + id);
        delete.setName("" + row);
        delete.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // deleteEmployee();
            }

        });

        menu.add(alter);
        menu.add(delete);

        return menu;
    }
    
     public int getRowAtPoint(Point point) {
        return treatmentTable.rowAtPoint(point);
    }

    public JTable getTable() {
        return treatmentTable;
    }

    public void setSelectedRow(int row) {
        treatmentTable.setRowSelectionInterval(row, row);
    }

    public void removeRow(int row) {
        dtm.removeRow(row);
    }
    
    public JFrame getParentFrame() {
        return parentFrame;
    }
    
    public void addTreatments(ArrayList<Treatment> treatments) {
        treatments.stream().forEach(
                treatment -> dtm.addRow(
                        new Object[]{treatment.getTreatmentID(), treatment.getTreatmentCode(), treatment.getBSN(), treatment.getPhysioTherapistLastName(), treatment.getStatus()}
                ));
    }
}
