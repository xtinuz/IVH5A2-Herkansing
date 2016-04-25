/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.client.control;

import edu.avans.ivh5.api.PhysioManagerClientIF;
import edu.avans.ivh5.client.view.ui.AddSessionScreen;
import edu.avans.ivh5.client.view.ui.LoginScreen;
import edu.avans.ivh5.client.view.ui.SchedulePanel;
import edu.avans.ivh5.client.view.ui.TreatmentPanel;
import edu.avans.ivh5.shared.model.domain.Employee;
import edu.avans.ivh5.shared.model.domain.Session;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 * //
 *
 *
 * @author bernd_000
 */
public class TreatmentAndSessionController implements ActionListener, KeyListener, MouseListener {

    //private AddTreatmentScreen parentScreen;
    private TreatmentPanel parentPanel;
    private PhysioManagerClientIF manager;
    private SchedulePanel scheduleScreen;
    private ArrayList<Employee> employees;
    private AddSessionScreen sessionScreen;

    public TreatmentAndSessionController(PhysioManagerClientIF manager) {
        this.manager = manager;

    }

    public void setUIRef(TreatmentPanel parentPanel) {
        this.parentPanel = parentPanel;
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
            case "newTreatment": //Open the sessionsScreen for a new treatment
                System.out.println("actioncommand newTreatment");
                AddSessionScreen screen = new AddSessionScreen(this, 0);
                screen.setVisible(true);
                break;
            case "saveTreatment": // Save the input as a new treatment including sessions.
                boolean saveSuccess;
                Treatment treatment = sessionScreen.saveTreatment();
                ArrayList<Session> sessions = sessionScreen.getAllSessionsFromTable();
                System.out.println("amount of sessions: " + sessions.size());
                if (sessionScreen.getTreatmentID() == 0) { // a new Treatment is made
                    System.out.println("actioncommand saveTreatment -> new treatment");
                    try {
                        saveSuccess = manager.saveTreatment(treatment, sessions);
                    } catch (Exception ex) {
                        System.out.println("controllererror: " + ex.getMessage());
                    }
                } else {
                    System.out.println("ActionCommand SaveTreatment -> alter");
                    try {
                        if (manager.deleteTreatmentByTreatmentID(sessionScreen.getTreatmentID())) {
                            manager.saveTreatment(treatment, sessions);
                        } else {
                            System.out.println("Deleting old data failed");
                        }
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                }
                JOptionPane.showMessageDialog(parentPanel, "Succesvol opgeslagen");
                sessionScreen.dispose();
                break;
            case "alterTreatment": // Open the sessionsScreen to alter the treatment.
                System.out.println("actioncommand alterTreatment");
                int currentTreatmentID = parentPanel.getTreatmentID();
                String currentBsn = parentPanel.getBSNFromTable();

                System.out.println("id is " + currentTreatmentID);
                if (currentTreatmentID != 0) {
                    System.out.println("ID for alter found");
                    try {
                        ArrayList currentSessions = manager.getAllSessionsByTreatmentID(currentTreatmentID);
                        Employee currentTherapist = manager.getTherapist(parentPanel.getTherapistLastName());
                        edu.avans.ivh5.shared.models.ClientDTO currentClient =  manager.getClient( currentBsn);

                        AddSessionScreen screen2 = new AddSessionScreen(this, currentTreatmentID, currentSessions, currentTherapist, currentClient); 
                        screen2.setVisible(true);
                    } catch (Exception ex) {
                        System.out.println("Error catched in controller: " + ex.getMessage());
                    }
                } else {
                    // show message
                    JOptionPane.showMessageDialog(parentPanel, "No treatment selected.");
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
                int selectedTreatmentID = parentPanel.getTreatmentID();
                if (selectedTreatmentID != 0) {
                    System.out.println("ID for delete found: " + selectedTreatmentID);
                    try {
                        manager.deleteTreatmentByTreatmentID(selectedTreatmentID);
                        parentPanel.removeTreatmentByTreatmentIDDIRTY(selectedTreatmentID);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                } else {
                    // show message
                    JOptionPane.showMessageDialog(parentPanel, "No treatment selected.");
                }
                break;
            case "cancel":
                System.out.println("actioncommand cancel");
                sessionScreen.dispose();
                break;
            case "newSession":
                System.out.println("action Command new session");
                sessionScreen.insertRow();
                break;
            case "deleteSession":
                System.out.println("action Command delete session");
                sessionScreen.deleteSession();
                break;
            case "searchClient":
                System.out.println("action command searcClient");
                ClientDTO client = getClient();
                System.out.println("cleint test " + client.getName());
                sessionScreen.setClientFields(client);
                break;
            case "FillTherapist":
                System.out.println("Actioncommand Filltherapist");
                try {
                    String name = sessionScreen.getTherapistName();
                    int spacePos = name.indexOf(" ");
                    String lastname = name.substring(spacePos + 1);
                    System.out.println("substring =" + lastname);
                    Employee currentTherapist = manager.getTherapist(lastname);
                    sessionScreen.setTherapistFields(currentTherapist);
                } catch (Exception ex) {
                    System.out.println("Error controller case filltherapist: " + ex.getMessage());
                }
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
//        if (parentPanel != null) {
//            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//                try {
//                    parentScreen.setNextFocus((JTextField) e.getSource());
//                } catch (IndexOutOfBoundsException ex) {
//                }
//            }
//        }
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

    public ArrayList<Employee> getEmployees() {
        ArrayList employees = new ArrayList();
        try {
            ArrayList<Employee> therapists = manager.getTherapists();
            for (Employee e : therapists) {
                String therapistName = null;
                therapistName = e.getFirstname() + " " + e.getLastname();
                employees.add(therapistName);
            }
        } catch (RemoteException ex) {
            System.out.println("RemoteException at getEmployees");
            System.out.println(ex.getMessage());
        }
        return employees;
    }

    public ArrayList<TreatmentType> getTreatmentTypes() {
        ArrayList treatments = new ArrayList();
        try {
            ArrayList<TreatmentType> treatment = manager.getTreatmentTypes();
            System.out.println("looping");
            for (TreatmentType t : treatment) {
                String treatmentCode = null;
                treatmentCode = t.getTreatmentCode() + " " + t.getTreatmentName();
                treatments.add(treatmentCode);
            }
        } catch (RemoteException ex) {
            System.out.println("RemoteException at getTreatments");
            System.out.println(ex.getMessage());
        }
        return treatments;
    }

    public void addTreatments() {
        try {
            parentPanel.addTreatments(manager.getTreatments());
        } catch (RemoteException ex) {
            System.out.println("RemoteException at AddTreatments in controller");
            System.out.println(ex.getMessage());
        }
    }

    public ClientDTO getClient() {
        String bsn = sessionScreen.getBSN();
        ClientDTO client = null;
        try {
            client = manager.getClient(bsn);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return client;

    }
    
    public ArrayList<String> getSessionDates(Date dateFromPanel1, Date DateFromPanel2)throws ParseException{
        Date date1 = null;
        Date date2 = null;
        ArrayList sessionDates = new ArrayList();
        try {
            Calendar c = Calendar.getInstance();
            c.setTime(dateFromPanel1);
            //date2.setTime(dateFromPanel2);
            
            System.out.println("date1 = " + date1 + " date2 " + date2);

            c.setTime(dateFromPanel1);
            Date firstDate = c.getTime();
            c.setTime(DateFromPanel2);
            Date secondDate = c.getTime();
            Calendar loopCalendar = Calendar.getInstance();
            loopCalendar.setTime(firstDate);
            SimpleDateFormat dtf = new SimpleDateFormat("dd-MM-yyyy");

            for (Date i = firstDate; i.before(secondDate);) {
                c.setTime(i);
                String strDate = dtf.format(c.getTime());
                sessionDates.add(strDate);
                loopCalendar.add(Calendar.DATE, 1);
                i = loopCalendar.getTime();

            }

        } catch (Exception ex) {
            System.out.println("Exception at getsessiondata");
            System.out.println(ex.getMessage());
        }

        System.out.println("sessionDates in controller " + sessionDates);
        return sessionDates;
    }
}
