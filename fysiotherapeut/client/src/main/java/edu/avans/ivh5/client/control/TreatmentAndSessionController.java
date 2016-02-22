/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.client.control;

import edu.avans.ivh5.api.PhysioManagerClientIF;
import edu.avans.ivh5.client.view.ui.AddSessionScreen;
import edu.avans.ivh5.client.view.ui.AddTreatmentScreen;
import edu.avans.ivh5.client.view.ui.LoginScreen;
import edu.avans.ivh5.client.view.ui.SchedulePanel;
import edu.avans.ivh5.client.view.ui.TreatmentPanel;
import edu.avans.ivh5.shared.model.domain.Employee;
import edu.avans.ivh5.shared.model.domain.Treatment;
import edu.avans.ivh5.shared.model.domain.TreatmentType;
import edu.avans.ivh5.shared.models.ClientDTO;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

/**
// *
 * @author bernd_000
 */
public class TreatmentAndSessionController implements ActionListener, KeyListener, MouseListener {
    private AddTreatmentScreen parentScreen;
    private TreatmentPanel parentPanel;
    private PhysioManagerClientIF manager;
    private SchedulePanel scheduleScreen;
    private ArrayList<Employee> employees;
    private AddSessionScreen sessionScreen;
    
    public TreatmentAndSessionController(PhysioManagerClientIF manager){
        this.manager = manager;
        //getEmployees();

        //getTableData();
    }
    
    public void setUIRef(AddTreatmentScreen parentScreen) {
        this.parentScreen = parentScreen;
        System.out.println("SetUIRef AddTreatmentScreen");
    }
        
    public void setUIRef(TreatmentPanel parentScreen) {
        this.parentPanel = parentScreen;
        System.out.println("SetUIRef TreatmentPanel");
    }
    
    public void setUIRef(AddSessionScreen sessionScreen) {
        this.sessionScreen = sessionScreen;
        System.out.println("SetUIRef sessionScreen");
    }

    public void setUIRef(SchedulePanel scheduleScreen) {
        this.scheduleScreen = scheduleScreen;
        System.out.println("SetUIRef scheduleScreen");
    }
    
    public void saveTreatment(Treatment treatment) {
    treatment = sessionScreen.saveTreatment();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("TreatmentAndSessionController, top of actionperformed");
        switch (e.getActionCommand()) {
            case "saveTreatment":
                System.out.println("actioncommand savetreatment");
                Treatment treatment = sessionScreen.saveTreatment();
                try{
                  System.out.println("Savinug treatmenrt: " + treatment.toString());
                   manager.saveTreatment(treatment); 
                } catch (RemoteException ex) {
                    ex.getMessage();
                }                
                        break;
            case "newTreatment":
                System.out.println("actioncommand newTreatment");
                AddSessionScreen screen = new AddSessionScreen(this, true);
                screen.setVisible(true);
                break;
            case "openAlterScreen":
                System.out.println("actioncommand alterTreatment");
                
                //Get Treatment data
                Treatment tempTreatment = null;
                try {
                    tempTreatment = manager.getTreatmentByID(parentPanel.getTreatmentID());
                } catch (RemoteException ex) {
                    Logger.getLogger(TreatmentAndSessionController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                //Get Client data
                ClientDTO client = new ClientDTO("Joey", "Beljaars", "0187484337", "joeyBeljaars@hotmail.com", "114441231f" );
                /*
                ClientDTO client = null;
                try {
                    client = manager.getClient(tempTreatment.getBSN());
                } catch (RemoteException ex) {
                    Logger.getLogger(TreatmentAndSessionController.class.getName()).log(Level.SEVERE, null, ex);
                }
                        */
                
                //Get Employee data
                Employee therapist = null;
                try {
                    therapist = manager.getTherapist(tempTreatment.getPhysioTherapistLastName());
                } catch (RemoteException ex) {
                    Logger.getLogger(TreatmentAndSessionController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                AddSessionScreen alterScreen = new AddSessionScreen(this, false, therapist, tempTreatment, client);
                alterScreen.setVisible(true);
                alterScreen.fillFields();
                break;
            case "logout":
                System.out.println("actioncommand logout");
                
                if (parentPanel != null) {
                    parentPanel.getParentFrame().dispose();
                }
                new LoginScreen(new LoginController(manager));
                break;
            case "deleteTreatment":
                System.out.println("actioncommand delete");
                parentPanel.removeTreatmentByTreatmentIDDIRTY();
/*
                try {
                    manager.deleteTreatmentByTreatmentID(parentPanel.getTreatmentID());
                    System.out.println(parentPanel.getTreatmentID());
                } catch (RemoteException ex) {
                    Logger.getLogger(TreatmentAndSessionController.class.getName()).log(Level.SEVERE, null, ex);
                } */
                break;
            case "alterTreatment":
                System.out.println("actioncommand confirmsave");
                parentScreen.dispose();
                break;
            case "confirmSave":
                System.out.println("actioncommand confirmsave");
                parentScreen.dispose();
                break;
            case "confirmAlter":
                System.out.println("actioncommand confirmAlter");
                
                parentScreen.dispose();
                break;
            case "cancel":
                System.out.println("actioncommand cancel");
                parentScreen.dispose();
                break;
        }
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (parentPanel != null) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                try {
                    parentScreen.setNextFocus((JTextField) e.getSource());
                } catch (IndexOutOfBoundsException ex) {
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON3) {
            int row = parentPanel.getRowAtPoint(new Point(e.getX(), e.getY()));
            // if the row is empty it will return -1
            // you will not be able to right click on an empty row
            if (row != -1) {
                parentPanel.setSelectedRow(row);
                parentPanel.createRightClickMenu(row).show(parentPanel.getTable(), e.getX(), e.getY());
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
    
    public ArrayList<Employee> getEmployees(){
            ArrayList employees = new ArrayList();
        try{
            ArrayList<Employee> therapists = manager.getTherapists();
            for (Employee e: therapists){
                String therapistName = null;
                therapistName = e.getFirstname() + " " + e.getLastname();
                employees.add(therapistName);
            }            
        } 
        catch(RemoteException ex){
            System.out.println("RemoteException at getEmployees");
            System.out.println(ex.getMessage());
        }
        return employees;
        }
    
    public ArrayList<TreatmentType> getTreatmentTypes(){
            ArrayList treatments = new ArrayList();
        try{
            ArrayList<TreatmentType> treatment = manager.getTreatmentTypes();
            System.out.println("looping");
            for (TreatmentType t: treatment){
                String treatmentCode = null;
                treatmentCode = t.getTreatmentCode() + " " + t.getTreatmentName();
                treatments.add(treatmentCode);   
            }
        }
        catch(RemoteException ex){
                System.out.println("RemoteException at getTreatments");
                        System.out.println(ex.getMessage());
            }
        return treatments;
    }
    
    public void getClient(String needle){
        try {
            ClientDTO client = manager.getClient(needle);
            sessionScreen.updateClient(client);
        } catch (RemoteException ex) {
            Logger.getLogger(TreatmentAndSessionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addTreatments() {
        try {
            ArrayList<Treatment> treatments = manager.getTreatments();
            System.out.println("test addtreatments after manager " + treatments.size());
            parentPanel.addTreatments( treatments);
        } catch (RemoteException ex) {
            System.out.println("RemoteException at AddEmployees()");
            System.out.println(ex.getMessage()); 
        }
    }
}
