/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.client.control;

import edu.avans.ivh5.api.PhysioManagerClientIF;
import edu.avans.ivh5.client.view.ui.AddTreatmentScreen;
import edu.avans.ivh5.client.view.ui.EmployeePanel;
import edu.avans.ivh5.client.view.ui.LoginScreen;
import edu.avans.ivh5.client.view.ui.SchedulePanel;
import edu.avans.ivh5.shared.model.domain.PhysioPractice;
import edu.avans.ivh5.shared.model.domain.Session;
import edu.avans.ivh5.client.view.ui.TreatmentPanel;
import edu.avans.ivh5.shared.model.domain.Employee;
import edu.avans.ivh5.shared.model.domain.Treatment;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

/**
 *
 * @author bernd_000
 */
public class ScheduleController implements ActionListener, KeyListener, MouseListener {
    private SchedulePanel parentScreen;
    private PhysioManagerClientIF manager;
    
    public ScheduleController(PhysioManagerClientIF manager){
        this.manager = manager;

    }
    
    public void setUIRef(SchedulePanel parentScreen) {
        this.parentScreen = parentScreen;
        System.out.println("SetUIRef AddTreatmentScreen");
    }
        


    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "refresh table":
        
            try {
                /* try {
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
                String dateAsString = parentScreen.getDate();
                Date dateAsDate;
                dateAsDate = formatter.parse(dateAsString);
                System.out.println("testing date" + dateAsDate);
                } catch (ParseException ex) {
                Logger.getLogger(ScheduleController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                getTableData( new Date() );
                break; */
                getTableData(parentScreen.getDate() );
            } catch (ParseException ex) {
                Logger.getLogger(ScheduleController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public void getTableData(String dateFromPanel) throws ParseException{
        try {
            DateFormat df = new SimpleDateFormat("ddMMMMyyyy", Locale.US);
            System.out.println(dateFromPanel);
            String day = null;
            Date date1 = df.parse( dateFromPanel );
            System.out.println(date1);
            //System.out.print(date1);
//            switch (day) {
//                case "Monday":
//                    
//                    break;
//                    
//                case "Tuesday":
//                    
//                    break;
//                    
//                case "Wednesday":
//                    
//                    break;
//                    
//                case "Thursday":
//                    
//                    break;
//                    
//                case "Friday":
//                    
//                    break;
//                    
//                case "Saturday":
//                    
//                    break;
//                    
//                case "Sunday":
//                    
//                    break;
//                
//                
//            }
            Date date2 = Calendar.getInstance().getTime();
            ArrayList<Session> sessions = null;
            System.out.println("getTablefunction in controller");
            //System.out.println("print date1" + date1);
            //sessions = manager.getsessionsByDate(date1, date2);
            System.out.println("getsessionsByDate controller TEST");
        }
        catch (Exception ex) {
            System.out.println("RemoteException or ParseException at gettabledata");
            System.out.println(ex.getMessage());
        }
    
    }
    
    public void setTableData(){
        
    }
    
}
