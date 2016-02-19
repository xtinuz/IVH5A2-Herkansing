/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.client.control;

import edu.avans.ivh5.api.PhysioManagerClientIF;
import edu.avans.ivh5.client.view.ui.AddSessionScreen;
import edu.avans.ivh5.client.view.ui.AddTreatmentScreen;
import edu.avans.ivh5.client.view.ui.EmployeePanel;
import edu.avans.ivh5.client.view.ui.LoginScreen;
import edu.avans.ivh5.client.view.ui.SchedulePanel;
import edu.avans.ivh5.shared.model.domain.PhysioPractice;
import edu.avans.ivh5.shared.model.domain.Session;
import edu.avans.ivh5.client.view.ui.TreatmentPanel;
import edu.avans.ivh5.shared.model.domain.Employee;
import edu.avans.ivh5.shared.model.domain.Treatment;
import edu.avans.ivh5.shared.model.domain.TreatmentType;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("TreatmentController, top of actionperformed");
        switch (e.getActionCommand()) {
            case "newTreatment":
                System.out.println("actioncommand newTreatment");
                AddSessionScreen screen = new AddSessionScreen(this);
                screen.setVisible(true);
                break;
            case "alterTreatment":
                System.out.println("actioncommand alterTreatment");
                Treatment tempTreatment = null;
                try {
                    tempTreatment = manager.getTreatmentByID(parentPanel.getTreatmentID());
                } catch (RemoteException ex) {
                    Logger.getLogger(TreatmentAndSessionController.class.getName()).log(Level.SEVERE, null, ex);
                }
                Employee therapist = null;
                try {
                    therapist = manager.getTherapistByTherapistID(Integer.parseInt(tempTreatment.getPhysioTherapistID()));
                } catch (RemoteException ex) {
                    Logger.getLogger(TreatmentAndSessionController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                try {
                    new AddTreatmentScreen(
                            this,
                            "alterTreatment",
                            therapist,
                            tempTreatment
                    );
                } catch (NullPointerException ex) {
                    System.out.println("No employee selected");
                }
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

                try {
                    manager.deleteTreatmentByTreatmentID(parentPanel.getTreatmentID());
                } catch (RemoteException ex) {
                    Logger.getLogger(TreatmentAndSessionController.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case "confirmSave":
                System.out.println("actioncommand confirmsave");
                /* 
                {
                    
                    try {
                        if (manager.saveEmployee(parentScreen.getEmployee())) {
                            parentPanel.addEmployee(parentScreen.getEmployee(), manager.getMaxID());
                        }
                    } catch (RemoteException ex) {
                        Logger.getLogger(TherapistController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                        */
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
            System.out.println("Fsfljd");
            ArrayList<TreatmentType> treatment = manager.getTreatmentTypes();
            System.out.println("after loop");
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
}