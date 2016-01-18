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

/**
 *
 * @author bernd_000
 */
public class CompanyInfoPanel extends JPanel {
    
    private JButton saveButton;
    private JTextField nameField, adressField, houseNoField, postcodeField, cityField, phoneField, mailField, KVKField, IBANField, BICField, bankField;
    private PhysioPracticeController controller;
    
    public CompanyInfoPanel(PhysioPracticeController controller) {
        setLayout(new BorderLayout());
        this.controller =  controller;
        add(createCenterPanel(), BorderLayout.CENTER);
    }
    
    public JPanel createCenterPanel() {
        JPanel panel = new JPanel();
        
        panel.setLayout(new GridLayout(11,4,5,5));
        panel.setBorder(new EmptyBorder(300,300,300,300));
        // row 1
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        
        saveButton = new JButton("Opslaan");
        saveButton.addActionListener(this.controller);
        panel.add(saveButton);
        // end of row 1
        
        // row 2
        panel.add(new JLabel("Name praktijk:"));
        
        nameField = new JTextField();
        panel.add(nameField);
        
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        // end of row 2
        
        // row 3
        panel.add(new JLabel("Straatname + huisnummer:"));
        
        adressField = new JTextField();
        panel.add(adressField);
        
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        // end of row 3
        
        // row 4
        panel.add(new JLabel("Postcode:"));
        
        postcodeField = new JTextField();
        panel.add(postcodeField);
        
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
        panel.add(new JLabel("Email"));
        
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
        panel.add(new JLabel("Name bank:"));
        
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
    
    public String getAdressField() {
        return adressField.getText();
    }

    public void setAdressField(String name) {
        adressField.setText(name);
    }
    
    public void sethouseNo(String houseNo){
        houseNoField.setText(houseNo);
    }
    
    public String getHouseNoField(){
        return houseNoField.getText();
    }
    
    public String getPostcodeField() {
        return postcodeField.getText();
    }

    public void setPostcodeField(String postalcode) {
        postcodeField.setText(postalcode);
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

    public void setPhoneField(String phoneNo) {
        phoneField.setText(phoneNo);
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