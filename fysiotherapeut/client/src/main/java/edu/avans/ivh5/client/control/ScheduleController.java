/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.client.control;

import edu.avans.ivh5.api.PhysioManagerClientIF;
import edu.avans.ivh5.client.view.ui.SchedulePanel;
import edu.avans.ivh5.shared.model.domain.Session;
import edu.avans.ivh5.shared.model.domain.Employee;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ScheduleController implements ActionListener, KeyListener, MouseListener {
    private SchedulePanel parentScreen;
    private PhysioManagerClientIF manager;
    
    public ScheduleController(PhysioManagerClientIF manager){
        this.manager = manager;
         getEmployees();
         //getLastNameFromCBox();
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
                String lastname = getLastNameFromCBox(); //Temporary until the rest is fully implemented
                Date date = parentScreen.getDate();
                parentScreen.setTableHeaderDates( date );
                getSessionsForSchedule(date, lastname);
                
            } catch (Exception ex) {
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
    
    public ArrayList getScheduleTableDates2(Date dateFromPanel){
        ArrayList dates = new ArrayList();
        
        return dates;
    }
    
    
    public ArrayList getScheduleDates(Date dateFromPanel) throws ParseException{
        Date date1 = null;
        Date date2 = null;
        ArrayList tableDates = new ArrayList();
        try {
            Calendar c = Calendar.getInstance();
            c.setTime(dateFromPanel);
            int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
            System.out.println("day of week is " + dayOfWeek);
            
            switch (dayOfWeek) {
                case 1: //Sunday
                    date1 = dateFromPanel;
                    c.add(Calendar.DATE, 6);
                    date2 = c.getTime();
                    break;
                    
                case 2: //Monday
                    c.add(Calendar.DATE, -1);
                    date1 = c.getTime();
                    c.add(Calendar.DATE, 6);
                    date2 = c.getTime();
                    break;
                    
                case 3: //Tuesday
                    c.add(Calendar.DATE, -2);
                    date1 = c.getTime();
                    c.add(Calendar.DATE, 6);
                    date2 = c.getTime();
                    break;
                    
                case 4: //Wednesday
                    c.add(Calendar.DATE, -3);
                    date1 = c.getTime();
                    c.add(Calendar.DATE, 6);
                    date2 = c.getTime();
                    break;
                    
                case 5: //Thursday
                    c.add(Calendar.DATE, -4);
                    date1 = c.getTime();
                    c.add(Calendar.DATE, 6);
                    date2 = c.getTime();
                    break;
                   
                case 6: //Friday
                    c.add(Calendar.DATE, -5);
                    date1 = c.getTime();
                    c.add(Calendar.DATE, 6);
                    date2 = c.getTime();
                    break;
                    
                case 7: //Saturday
                    c.add(Calendar.DATE, -6);
                    date1 = c.getTime();
                    c.add(Calendar.DATE, 6);
                    date2 = c.getTime();
                    break;
            }
            System.out.println("date1 = " + date1 + " date2 " + date2);
            
            Calendar c1 = Calendar.getInstance();
            c1.setTime(date1);
            Date firstDate = c1.getTime();
            System.out.println("first date = " + firstDate);
            Calendar c2 = Calendar.getInstance();
            c2.setTime(date2);
            c2.add(Calendar.DATE, 1);
            Date lastDatePlusOne = c2.getTime();
            //System.out.println("last date = " + lastDatePlusOne);
            Calendar loopCalendar = Calendar.getInstance();
            loopCalendar.setTime(firstDate);
            
            for (Date i = firstDate; i.before(lastDatePlusOne);){
            c2.setTime(i); 
            String day = Integer.toString(c2.get(Calendar.DATE));
            String month = Integer.toString(c2.get(Calendar.MONTH));
            String year = Integer.toString(c2.get(Calendar.YEAR));
            String dateForArray = day + "-" + month + "-" + year;
            tableDates.add(dateForArray);
            loopCalendar.add(Calendar.DATE, 1);
            i = loopCalendar.getTime();
            
        }
            
        }
        catch (Exception ex) {
            System.out.println("Exception at gettabledata");
            System.out.println(ex.getMessage());
        }
        
        System.out.println("talesDates in controller " + tableDates);
        return tableDates;
       
    }
    
    public ArrayList<Session> getSessionsForSchedule(Date date, String lastname){
        ArrayList<Session> sessions = null;
        
        try{
        ArrayList dates = getScheduleDates(date); // return the 7 days of the week matching with the date input.
        manager.getScheduleTableData(dates, lastname);
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        
        return sessions;
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

    public String getLastNameFromCBox(){
      System.out.println("\nTESTING STRINGS");
      String fullName = parentScreen.getTherapistFromComboBox();
      String lastName = "";
      String[] parts = fullName.split("\\s+");      //Splitting into array based on whitespace
      int arrayCount = parts.length - 1;            //-1 because the array starts counting at [0]
      
      for (int n=1; n<arrayCount; n++){             //Combines everything BUT the fist and last element into a string
          lastName = lastName + parts[n] + " ";
      }
      lastName = lastName + parts[arrayCount];          //Adds last element to the string (avoids space at the end of the string)
      System.out.println(lastName);  
      System.out.println("\n");
      return lastName;
    }
    
    
    public void setTableData() {

    }
    
}
