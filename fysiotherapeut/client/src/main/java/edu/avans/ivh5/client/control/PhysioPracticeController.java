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
import java.util.logging.Level;
import java.util.logging.Logger;

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
        this.practice = new PhysioPractice();
        //setInputFields();
    }

    public void setUIRef(CompanyInfoPanel screen) {
        parentScreen = screen;
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
        System.out.println("Button clicked, trying to save company info");
        saveInputFields();
    }

    
    
    /**
     * Saves all fields from the GUI
     * 
     * 
     */
    public void saveInputFields(){
        //PhysioPractice practice = new PhysioPractice();
        
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
            
        System.out.println("Test 1");
        try {
            System.out.println("Test 2");
            System.out.println("Current name: " + practice.getName());
            manager.saveCompanyInfo(practice);
            System.out.println("Company info saved");
        } catch (RemoteException ex) {
            System.out.println("saveCompanyInfo can not be called at the server");
        }
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