/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.client.control;

import edu.avans.ivh5.api.PhysioManagerClientIF;
import edu.avans.ivh5.client.view.ui.SchedulePanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.Date;

/**
 *
 * @author bernd_000
 */
public class TreatmentController implements ActionListener {
     private PhysioManagerClientIF manager;
     private SchedulePanel parentScreen;
    
    public TreatmentController(PhysioManagerClientIF manager) {
        this.manager = manager;
        System.out.println("Treatmentcontroller constructor");
        getTableData();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void setUIRef(SchedulePanel parentScreen) {
        this.parentScreen = parentScreen;
    }
    
    public void getTableData(){
        try { 
            System.out.println("getTablefunction in controller");
            manager.getsessionsByDate(new Date(), new Date());
            System.out.println("getsessionsByDate TEST");
        
        }
        catch (RemoteException ex) {
                        System.out.println("error getTableData in treatmentcontroller");
                        System.out.println(ex.getMessage());
                    }
    }
    
    public void setTableData(){
        
    }
    
}
