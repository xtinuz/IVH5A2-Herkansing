/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.client.view.ui;

import edu.avans.ivh5.client.control.TherapistController;
import edu.avans.ivh5.shared.model.domain.Employee;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author bernd_000
 */
public class AddEmployeeScreen extends JFrame {

    private JLabel ID, phoneNumber, name, lastName, mail;
    private JTextField IDField, phoneNumberField, nameField, lastNameField, mailField;
    private JButton addEmployeeButton, cancelButton;
    private final ArrayList<JTextField> textFields;
    private final TherapistController controller;
    private final String button;

    public AddEmployeeScreen(TherapistController controller, String buttonAction) {
        button = buttonAction;
        this.controller = controller;
        controller.setUIRef(this);
        textFields = new ArrayList<>();
        init();
    }

    public AddEmployeeScreen(TherapistController controller, String buttonAction, String id, String firstName, String lastName, String phoneNumber, String email) {
        this.controller = controller;
        controller.setUIRef(this);

        button = buttonAction;
        textFields = new ArrayList<>();
        init();
        IDField.setText(id);
        IDField.setEditable(false);
        nameField.setText(firstName);
        lastNameField.setText(lastName);
        phoneNumberField.setText(phoneNumber);
        mailField.setText(email);
    }

    private void init() {
        setSize(300, 300);
        setResizable(false);
        setLocationRelativeTo(null);

        add(createEmployeeInfoPanel());

        setVisible(true);
    }

    private JPanel createEmployeeInfoPanel() {
        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(7, 2, 5, 5));
        panel.setBorder(new EmptyBorder(5, 10, 5, 10));

        // row 1
        ID = new JLabel("ID:");
        IDField = new JTextField();
        IDField.addKeyListener(controller);
        textFields.add(IDField);

        if (!button.equals("newEmployee")) {
            panel.add(ID);
            panel.add(IDField);
        }
        // end of row 1

        // row 2
        name = new JLabel("Voornaam:");
        nameField = new JTextField();
        nameField.addKeyListener(controller);
        textFields.add(nameField);

        panel.add(name);
        panel.add(nameField);
        // end of row 2

        // row 3
        lastName = new JLabel("Achternaam:");
        lastNameField = new JTextField();
        lastNameField.addKeyListener(controller);
        textFields.add(lastNameField);

        panel.add(lastName);
        panel.add(lastNameField);
        // end of row 3

        // row 4
        phoneNumber = new JLabel("Telefoonnummer:");
        phoneNumberField = new JTextField();
        phoneNumberField.addKeyListener(controller);
        textFields.add(phoneNumberField);

        panel.add(phoneNumber);
        panel.add(phoneNumberField);
        // end of row 4

        // row 5
        mail = new JLabel("Email:");
        mailField = new JTextField();
        mailField.addKeyListener(controller);
        textFields.add(mailField);

        panel.add(mail);
        panel.add(mailField);
        // end of row 5

        // row 6
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        // end of row 6

        // row 7
        addEmployeeButton = new JButton("Bevestigen");
        switch (button) {
            case "alterEmployee":
                System.out.println("actioncommand is alteremployee");
                addEmployeeButton.setActionCommand("confirmAlter");
                break;
            case "newEmployee":
                System.out.println("actioncommand is saveemployee");
                addEmployeeButton.setActionCommand("confirmSave");
                break;
        }
        addEmployeeButton.addActionListener(controller);
        cancelButton = new JButton("Annuleren");
        cancelButton.setActionCommand("cancel");
        cancelButton.addActionListener(controller);

        panel.add(addEmployeeButton);
        panel.add(cancelButton);
        // end of row 7

        return panel;
    }

    public void setNextFocus(JTextField source) throws IndexOutOfBoundsException {
        textFields.get(textFields.indexOf(source) + 1).requestFocus();
    }

    public Employee getEmployee() {
        System.out.println("Adding employee");
        String id = IDField.getText();
        String firstname = nameField.getText();
        String lastname = lastNameField.getText();
        String phoneNr = phoneNumberField.getText();
        String email = mailField.getText();
        Employee newEmployee = new Employee(id, firstname, lastname, phoneNr, email);

        return newEmployee;
    }
}
