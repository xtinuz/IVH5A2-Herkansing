/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.client.view.ui;

import edu.avans.ivh5.client.control.PhysioPracticeController;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class CompanyInfoPanel extends JPanel {
    
    private JButton saveButton;
    private JTextField nameField, addressField, postalField, cityField, phoneField, mailField, KVKField, IBANField, BICField, bankField;
    private PhysioPracticeController controller;
    
    public CompanyInfoPanel(PhysioPracticeController controller) {
        setLayout(new BorderLayout());
        this.controller =  controller;
        add(createCenterPanel(), BorderLayout.CENTER);
        System.out.println("setting ui reference CompanyInfoPanel");
        controller.setUIRef(this);
        controller.getPhysioPractice();
        controller.setInputFields();
    }
    
    public JPanel createCenterPanel() {
        JPanel panel = new JPanel();                                                                                                                                                                                             
        
        panel.setLayout(new GridLayout(11,4,5,5));
        panel.setBorder(new EmptyBorder(150,150,150,150));
        // row 1
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        
        saveButton = new JButton("Opslaan");
        saveButton.addActionListener(this.controller);
        panel.add(saveButton);
        // end of row 1
        
        // row 2
        panel.add(new JLabel("Naam praktijk:"));
        
        nameField = new JTextField();
        panel.add(nameField);
        
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        // end of row 2
        
        // row 3
        panel.add(new JLabel("Straatname & huisnummer:"));
        
        addressField = new JTextField();
        panel.add(addressField);
        
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        // end of row 3
        
        // row 4
        panel.add(new JLabel("Postcode:"));
        
        postalField = new JTextField();
        panel.add(postalField);
        
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        // end of row 4
        
        // row 5
        panel.add(new JLabel("Plaats:"));
        
        cityField = new JTextField();
        panel.add(cityField);
        
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        // end of row 5
        
        // row 6
        panel.add(new JLabel("Telefoonnummer:"));
        
        phoneField = new JTextField();
        panel.add(phoneField);
        
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        // end of row 6
        
        // row 7
        panel.add(new JLabel("Email adres"));
        
        mailField = new JTextField();
        panel.add(mailField);
        
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        // end of row 7
        
        // row 8
        panel.add(new JLabel("KVK nummer:"));
        
        KVKField = new JTextField();
        panel.add(KVKField);
        
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        // end of row 8
        
        // row 9
        panel.add(new JLabel("IBAN:"));
        
        IBANField = new JTextField();
        panel.add(IBANField);
        
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        // end of row 9
        
        // row 10
        panel.add(new JLabel("BIC:"));
        
        BICField = new JTextField();
        panel.add(BICField);
        
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        // end of row 10
        
        // row 11
        panel.add(new JLabel("Bank:"));
        
        bankField = new JTextField();
        panel.add(bankField);
        
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        // end of row 11
        return panel;
    }   
    
     public String getNameField() {
        return nameField.getText();
    }

    public void setNameField(String name) {
        nameField.setText(name);
    }
    
    public String getAddressField() {
        return addressField.getText();
    }

    public void setAddressField(String name) {
        addressField.setText(name);
    }
    
    public String getPostalField() {
        return postalField.getText();
    }

    public void setPostalField(String postalcode) {
        postalField.setText(postalcode);
    }    
    
    public String getCity() {
        return cityField.getText();
    }

    public void setCityField(String city) {
        cityField.setText(city);
    }
    
    public String getPhoneField() {
        return phoneField.getText();
    }

    public void setPhoneField(String phone) {
        phoneField.setText(phone);
    }
    
    public String getMailField() {
        return mailField.getText();
    }

    public void setMailField(String email) {
        mailField.setText(email);
    }
    
    public String getKVKField() {
        return KVKField.getText();
    }

    public void setKVKField(String KVK) {
        KVKField.setText(KVK);
    }
    
    public String getIbanField() {
        return IBANField.getText();
    }

    public void setIbanField(String Iban) {
        IBANField.setText(Iban);
    }
    
    public String getBICField() {
        return BICField.getText();
    }

    public void setBICField(String BIC) {
        BICField.setText(BIC);
    }
    
    public String getBankField() {
        return bankField.getText();
    }

    public void setBankField(String bank) {
        bankField.setText(bank);
    }
}