/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.client.view.ui;

import edu.avans.ivh5.api.PhysioManagerClientIF;
import edu.avans.ivh5.client.control.TherapistController;
import edu.avans.ivh5.shared.model.domain.Employee;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

/**
 * EmployeePanel is a part of the MainTabbedPaneScreen The Panel contains
 * everything you need in order to
 *
 * @author bernd_000
 */
public class EmployeePanel extends JPanel {

    private JButton logoutButton, addButton, alterButton, deleteButton;
    private final JFrame parentFrame;
    private JTable fysioTable;
    private JMenuItem alter, delete;
    private final TherapistController controller;
    private DefaultTableModel dtm;

    /**
     * EmployeePanel creates the subpanels and adds them to itself It also
     * contains a reference to the parent of the panel which is needed to log
     * out
     *
     * @param parentFrame
     * @param controller
     * @param manager
     */
    public EmployeePanel(JFrame parentFrame, TherapistController controller) {
        this.controller = controller;
        System.out.println("setting ui reference");
        controller.setUIRef(this);
        this.parentFrame = parentFrame;
        dtm = new DefaultTableModel();

        setLayout(new BorderLayout());
        add(createNorthPanel(), BorderLayout.NORTH);
        add(createCenterPanel(), BorderLayout.CENTER);
        controller.addEmployees();
    }

    /**
     * createNorthPanel creates a panel which contains everything seen at the
     * top part of the screen
     *
     * @return
     */
    private JPanel createNorthPanel() {
        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(3, 5, 10, 10));

        // row 1
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));

        logoutButton = new JButton("Log uit");
        logoutButton.setActionCommand("logout");
        logoutButton.addActionListener(controller);
        panel.add(logoutButton);
        // end of row 1

        // row 2
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));

        addButton = new JButton("Toevoegen");
        addButton.setActionCommand("saveEmployee");
        addButton.addActionListener(controller);
        panel.add(addButton);

        alterButton = new JButton("Wijzig");
        alterButton.setActionCommand("alter");
        alterButton.addActionListener(controller);
        panel.add(alterButton);

        deleteButton = new JButton("Verwijder");
        panel.add(deleteButton);
        deleteButton.setActionCommand("delete");
        deleteButton.addActionListener(controller);
        // end of row 2

        //row 3
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        // end of row 3

        return panel;
    }

    /**
     * createCenterPanel creates a panel which contains everything seen at the
     * center part of the screen
     *
     * @return
     */
    private JPanel createCenterPanel() {
        JPanel panel = new JPanel();

        panel.setLayout(new BorderLayout());

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(1, 5));
        JLabel label = new JLabel("Fysiotherapeuten: ");
        label.setFont(new Font("Arial", Font.PLAIN, 20));
        northPanel.add(label);

        JPanel centerPanel = new JPanel(new GridLayout(1, 1));
        centerPanel.setBorder(new EmptyBorder(15, 10, 0, 10));

        dtm.addColumn("ID");
        dtm.addColumn("Voornaam");
        dtm.addColumn("Achternaam");
        dtm.addColumn("Telefoonnummer");
        dtm.addColumn("Email");
        fysioTable = new JTable(dtm);
        fysioTable.setFillsViewportHeight(true);
        fysioTable.getTableHeader().setBackground(Color.CYAN);
        fysioTable.addMouseListener(controller);

        // Make the table vertically scrollable
        JScrollPane scrollPane = new JScrollPane(fysioTable);

        centerPanel.add(scrollPane);

        // add the panels to the mainpanel
        panel.add(northPanel, BorderLayout.NORTH);
        panel.add(centerPanel, BorderLayout.CENTER);

        return panel;
    }

    /**
     * createRightClickMenu creates a menu which gives you the options to alter
     * or delete the employee on which you performed the right click
     *
     * @param row
     * @return
     */
    public JPopupMenu createRightClickMenu(int row) {
        JPopupMenu menu = new JPopupMenu();

        String name = "";

        try {
            name = fysioTable.getValueAt(row, 1) + " " + fysioTable.getValueAt(row, 2);
        } catch (Exception ex) {
        }

        alter = new JMenuItem("Wijzig " + name);
        alter.setActionCommand("alter");
        alter.addActionListener(controller);

        delete = new JMenuItem("Verwijder " + name);
        delete.setActionCommand("delete");
        delete.addActionListener(controller);

        menu.add(alter);
        menu.add(delete);

        return menu;
    }
    
    public void updateTableRow(Employee employee){
        System.out.println(Integer.parseInt(employee.getID()));
        
        fysioTable.setValueAt(employee.getFirstname(), Integer.parseInt(employee.getID())-1, 1);
        fysioTable.setValueAt(employee.getLastname(), Integer.parseInt(employee.getID())-1, 2);
        fysioTable.setValueAt(employee.getPhoneNr(), Integer.parseInt(employee.getID())-1, 3);
        fysioTable.setValueAt(employee.getEmail(), Integer.parseInt(employee.getID())-1, 4);
    }

    public Employee getEmployee() {
        try {
            return new Employee(
                    (String) fysioTable.getValueAt(fysioTable.getSelectedRow(), 0),
                    (String) fysioTable.getValueAt(fysioTable.getSelectedRow(), 1),
                    (String) fysioTable.getValueAt(fysioTable.getSelectedRow(), 2),
                    (String) fysioTable.getValueAt(fysioTable.getSelectedRow(), 3),
                    (String) fysioTable.getValueAt(fysioTable.getSelectedRow(), 4)
            );
        } catch (ArrayIndexOutOfBoundsException ex) {
            return null;
        }
    }

    public JFrame getParentFrame() {
        return parentFrame;
    }

    public int getRowAtPoint(Point point) {
        return fysioTable.rowAtPoint(point);
    }

    public JTable getTable() {
        return fysioTable;
    }

    public void setSelectedRow(int row) {
        fysioTable.setRowSelectionInterval(row, row);
    }

    public void removeRow(int row) {
        dtm.removeRow(row);
    }

    public void addEmployees(ArrayList<Employee> employees) {
        employees.stream().forEach(
                employee -> dtm.addRow(
                        new Object[]{employee.getID(), employee.getFirstname(), employee.getLastname(), employee.getPhoneNr(), employee.getEmail()}
                ));
    }

    public void addEmployee(Employee employee, int id) {
        dtm.addRow(
                new Object[]{Integer.toString(id), employee.getFirstname(), employee.getLastname(), employee.getPhoneNr(), employee.getEmail()}
        );
    }
}
