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
        parentScreen.setAdressField(this.practice.getStreetname());
        parentScreen.sethouseNo(this.practice.getHouseNo());
        parentScreen.setPostcodeField(this.practice.getPostalcode());
        parentScreen.setCityField(this.practice.getCity());
        parentScreen.setPhoneField(this.practice.getPhoneNo());
        parentScreen.setMailField(this.practice.getEmail());
        parentScreen.setKVKField(this.practice.getKVK());
        parentScreen.setIbanField(this.practice.getIBAN());
        parentScreen.setBICField(this.practice.getBIC());
        parentScreen.setBankField(this.practice.getBank());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        saveInputFields();
    }

    
    
    /**
     * Saves all fields from the GUI
     * 
     * 
     */
    public void saveInputFields(){
        PhysioPractice practice = new PhysioPractice();
        this.practice.setName(parentScreen.getNameField());
        this.practice.setStreetname(parentScreen.getAdressField());
        this.practice.setHouseNo(parentScreen.getHouseNoField());
        this.practice.setPostalcode(parentScreen.getPostcodeField());
        this.practice.setCity(parentScreen.getCity());
        this.practice.setPhoneNo(parentScreen.getPhoneField());
        this.practice.setEmail(parentScreen.getMailField());
        this.practice.setKVK(parentScreen.getKVKField());
        this.practice.setIBAN(parentScreen.getIbanField());
        this.practice.setBIC(parentScreen.getBICField());
        this.practice.setBank(parentScreen.getBankField());
        
        try {
            manager.saveCompanyInfo(this.practice);
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