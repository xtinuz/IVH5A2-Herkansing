/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.client.control;

import edu.avans.ivh5.api.PhysioManagerClientIF;
import edu.avans.ivh5.client.view.ui.CompanyInfoPanel;
import edu.avans.ivh5.shared.model.domain.PhysioPractice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.rmi.RemoteException;
import javax.swing.JOptionPane;

/**
 *
 * @author Sjonn
 */
public class PhysioPracticeController implements ActionListener, KeyListener {
    private final PhysioManagerClientIF manager;
    private CompanyInfoPanel parentScreen;
    PhysioPractice practice;

    

    public PhysioPracticeController(PhysioManagerClientIF manager) {
        this.manager = manager;
    // Deze moet nog opgehaald worden uit de XML
        practice = new PhysioPractice();
        //setInputFields();
    }

    public void setUIRef(CompanyInfoPanel screen) {
        parentScreen = screen;
    }
    
    public PhysioPractice getPhysioPractice() {
        try {
            practice = manager.getCompanyInfo();
        } catch (RemoteException ex) {
            System.out.println("RemoteException at AddEmployees()");
            System.out.println(ex.getMessage());
        }
        return practice;
    }
    
    
    public void setInputFields(){
        parentScreen.setNameField(this.practice.getName());
        parentScreen.setAddressField(this.practice.getAddress());
        parentScreen.setPostalField(this.practice.getPostal());
        parentScreen.setCityField(this.practice.getCity());
        parentScreen.setPhoneField(this.practice.getPhone());
        parentScreen.setMailField(this.practice.getEmail());
        parentScreen.setKVKField(this.practice.getKVK());
        parentScreen.setIbanField(this.practice.getIBAN());
        parentScreen.setBICField(this.practice.getBIC());
        parentScreen.setBankField(this.practice.getBank());
    }
   
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Validating company info ...");
        if (validatePractice()== true){
            System.out.println("Saving company info ...");
            saveInputFields();
            JOptionPane.showMessageDialog(parentScreen, "Save succesful");         
        };      
    }

    /**
     * Saves all fields from the GUI
     * 
     * 
     */
    public void saveInputFields(){
        
        this.practice.setName(parentScreen.getNameField());
        this.practice.setAddress(parentScreen.getAddressField());
        this.practice.setPostal(parentScreen.getPostalField());
        this.practice.setCity(parentScreen.getCity());
        this.practice.setPhone(parentScreen.getPhoneField());
        this.practice.setEmail(parentScreen.getMailField());
        this.practice.setKVK(parentScreen.getKVKField());
        this.practice.setIBAN(parentScreen.getIbanField());
        this.practice.setBIC(parentScreen.getBICField());
        this.practice.setBank(parentScreen.getBankField());


        try {
            manager.saveCompanyInfo(practice);
            System.out.println("Company info saved");

        } catch (RemoteException ex) {
            System.out.println("saveCompanyInfo can not be called at the server");
        }
    }

    public boolean validatePractice(){
        //Setting variables
        int count = 0;
        Boolean result = null;
        
        
        String errorMsg = "De volgende invoer is onjuist: ";
        
        /*String errorMsg = "";
        String addressMsg = "";
        String postalMsg = "";
        String cityMsg = "";
        String phoneMsg = "";
        String mailMsg = "";
        String kvkMsg = "";
        String ibanMsg = "";
        String bicMsg = "";
        String bankMsg = "";*/
              
        String addressRegex ="[a-zA-Z]{0,25}\\s\\d{1,5}";
        String postalRegex ="[0-9]{4}+[A-Z]{2}";
        String cityRegex="[a-zA-Z]+[[ '-]?[a-zA-Z]+]*";
        String phoneRegex="\\d{10}";
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        String kvkRegex="\\d{8}";
        String ibanRegex="[a-zA-Z]{2}[0-9]{2}[a-zA-Z0-9]{4}[0-9]{7}([a-zA-Z0-9]?){0,16}";
        String bicRegex="[a-zA-Z]{4}[a-zA-Z]{2}[a-zA-Z0-9]{2}([a-zA-Z0-9]{3})?";
        String bankRegex="[a-zA-Z]+[[ '-]?[a-zA-Z]+]*";
 
        //Validating address
        if (parentScreen.getAddressField().matches(addressRegex)) { 
        count++;
        } else {
        //postalMsg = "adress ";
        errorMsg = errorMsg + "straatnaam & huisnummer ";
        }       
        
        //Validating postalcode
        if (parentScreen.getPostalField().matches(postalRegex)) { 
        count++;
        } else {
        //postalMsg = "postcode ";
        errorMsg = errorMsg + "postcode ";
        }
        
        //Validating city
        if (parentScreen.getCity().matches(cityRegex)) { 
        count++;
        } else {    
        //cityMsg = "plaats ";  
        errorMsg = errorMsg + "plaats ";
        }
        
        //Validating phonenumber
        if (parentScreen.getPhoneField().matches(phoneRegex)) { 
        count++;
        } else {
        errorMsg = errorMsg + "telefoonnummer ";
        }
        
        //Validating email
        if (parentScreen.getMailField().matches(emailRegex)) { 
        count++;
        } else {
        errorMsg = errorMsg + "email ";
        }
        
        //Validating kvk
        if (parentScreen.getKVKField().matches(kvkRegex)) { 
        count++;
        } else {
        errorMsg = errorMsg + "KVK-nummer ";
        }

        //Validating iban
        if (parentScreen.getIbanField().matches(ibanRegex)) { 
        count++;
        } else {
        errorMsg = errorMsg + "IBAN";
        }
               
        //Validating bic
        if (parentScreen.getBICField().matches(bicRegex)) { 
        count++;
        } else {
        errorMsg = errorMsg + "BIC";
        }
        
        //Validating bank
        if (parentScreen.getBankField().matches(bankRegex)) { 
        count++;
        } else {
        errorMsg = errorMsg + "bank ";
        }
        
        if (count==9){
            result=true;
        } else {
            //errorMsg="De volgende invoer is onjuist: " + addressMsg + postalMsg + cityMsg + phoneMsg + mailMsg + kvkMsg + ibanMsg + bicMsg + bankMsg;
            JOptionPane.showMessageDialog(parentScreen, errorMsg);
            result=false;     
        }
        return result;
    }
    
    
    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            /*
            switch (parentScreen.getFocusOwner().getName()) {
                case "saveButton":
                    save();
                    break;
            }
                    */
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    public boolean save(){
        
        
        return false;
    }
}