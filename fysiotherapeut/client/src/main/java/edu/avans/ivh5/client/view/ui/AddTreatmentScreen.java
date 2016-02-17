/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.client.view.ui;

import edu.avans.ivh5.client.control.TherapistController;
import edu.avans.ivh5.client.control.TreatmentAndSessionController;
import edu.avans.ivh5.shared.model.domain.Employee;
import edu.avans.ivh5.shared.model.domain.Treatment;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


public class AddTreatmentScreen extends JFrame {

    private JLabel ID, treatmentCode, BSN, Employee;
    private JTextField IDField, treatmentCodeField, BSNField, EmployeeField;
    private JButton addTreatmentButton, cancelButton;
    private final ArrayList<JTextField> textFields;
    private final TreatmentAndSessionController controller;
    private final String button;
    private JTable fysioTable;
    private DefaultTableModel dtm;

    public AddTreatmentScreen(TreatmentAndSessionController controller, String buttonAction) {
        button = buttonAction;
        this.controller = controller;
        //controller.setUIRef(this);
        textFields = new ArrayList<>();
        dtm = new DefaultTableModel();
        init();
    }

    public AddTreatmentScreen(TreatmentAndSessionController controller, String buttonAction, Employee therapist, Treatment treatment) {
        this.controller = controller;
        //controller.setUIRef(this);

        button = buttonAction;
        textFields = new ArrayList<>();
        init();
        IDField.setText(treatment.getTreatmentID());
        IDField.setEditable(false);
        treatmentCodeField.setText(treatment.getTreatmentCode());
        BSNField.setText(treatment.getBSN());
        EmployeeField.setText(therapist.getFirstname() + therapist.getLastname());
        EmployeeField.setEditable(false);
    }

    private void init() {
        setSize(300, 300);
        setResizable(false);
        setLocationRelativeTo(null);

        add(createTreatmentInfoPanel());

        setVisible(true);
    }

    private JPanel createTreatmentInfoPanel() {
        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(7, 2, 5, 5));
        panel.setBorder(new EmptyBorder(5, 10, 5, 10));

        // row 1
        ID = new JLabel("ID:");
        IDField = new JTextField();
        //IDField.addKeyListener(controller);
        textFields.add(IDField);

        if (!button.equals("newEmployee")) {
            panel.add(ID);
            panel.add(IDField);
        }
        // end of row 1

        // row 2
        treatmentCode = new JLabel("treatmentCode:");
        treatmentCodeField = new JTextField();
        //treatmentCodeField.addKeyListener(controller);
        treatmentCodeField.setEditable(false);
        textFields.add(treatmentCodeField);

        panel.add(treatmentCode);
        panel.add(treatmentCodeField);
        // end of row 2

        // row 3
        BSN = new JLabel("Achternaam:");
        BSNField = new JTextField();
        //BSNField.addKeyListener(controller);
        BSNField.setEditable(false);
        textFields.add(BSNField);

        panel.add(BSN);
        panel.add(BSNField);
        // end of row 3

        // row 4
        Employee = new JLabel("Telefoonnummer:");
        EmployeeField = new JTextField();
        //EmployeeField.addKeyListener(controller);
        EmployeeField.setEditable(false);
        textFields.add(EmployeeField);

        panel.add(Employee);
        panel.add(EmployeeField);
        // end of row 4

        // row 6
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        // end of row 6
        
        //Row 7
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

        panel.add(scrollPane);
        //End row 7

        // row 8
        addTreatmentButton = new JButton("Bevestigen");
        switch (button) {
            case "alterEmployee":
                System.out.println("actioncommand is alteremployee");
                addTreatmentButton.setActionCommand("confirmAlter");
                break;
            case "newEmployee":
                System.out.println("actioncommand is saveemployee");
                addTreatmentButton.setActionCommand("confirmSave");
                break;
        }
        addTreatmentButton.addActionListener(controller);
        cancelButton = new JButton("Annuleren");
        cancelButton.setActionCommand("cancel");
        cancelButton.addActionListener(controller);

        panel.add(addTreatmentButton);
        panel.add(cancelButton);
        // end of row 8

        return panel;
    }
    
    

    public void setNextFocus(JTextField source) throws IndexOutOfBoundsException {
        textFields.get(textFields.indexOf(source) + 1).requestFocus();
    }

    public Treatment getTreatment() {
        System.out.println("Adding employee");
        String id = IDField.getText();
        String treatmentCode = treatmentCodeField.getText();
        String BSN = BSNField.getText();
        String Employee = EmployeeField.getText();
        
        Treatment newTreatment = new Treatment(id, treatmentCode, BSN, Employee);

        return newTreatment;
    }
}
