/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.client.control;

import edu.avans.ivh5.api.PhysioManagerClientIF;
import edu.avans.ivh5.client.view.ui.SchedulePanel;
import edu.avans.ivh5.client.view.ui.SchedulePanel2;
import edu.avans.ivh5.shared.model.domain.Session;
import edu.avans.ivh5.shared.model.domain.Employee;
import edu.avans.ivh5.shared.model.domain.Schedule;
import edu.avans.ivh5.shared.model.domain.ScheduleItem;
import java.awt.Color;
import java.awt.Component;
import java.awt.Rectangle;
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
import java.util.ListIterator;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;


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
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "refresh table":
        
            try {
                setTableData();

                
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
    
    
    
    public ArrayList<String> getScheduleDates(Date dateFromPanel) throws ParseException{
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
            
            c.setTime(date1);
            Date firstDate = c.getTime();
            c.setTime(date2);
            c.add(Calendar.DATE, 1);
            Date lastDatePlusOne = c.getTime();
            Calendar loopCalendar = Calendar.getInstance();
            loopCalendar.setTime(firstDate);
            SimpleDateFormat dtf = new SimpleDateFormat("dd-MM-yyyy");
            
            for (Date i = firstDate; i.before(lastDatePlusOne);){
            c.setTime(i); 
            String strDate = dtf.format( c.getTime() );
            //System.out.println("strdate" + strDate);
            tableDates.add(strDate);
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
    
    public ArrayList<ScheduleItem> getSessionsForSchedule(Date date, String lastname){
        ArrayList<ScheduleItem> sessions = null;
        
        try{
        ArrayList dates = getScheduleDates(date); // return the 7 days of the week matching with the date input.
        Schedule schedule = manager.getScheduleTableData(dates, lastname);
        sessions = schedule.getScheduleItems();
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
      String fullName = parentScreen.getTherapistFromComboBox();
      String lastName = "";
      String[] parts = fullName.split("\\s+");      //Splitting into array based on whitespace
      int arrayCount = parts.length - 1;            //-1 because the array starts counting at [0]
      
      for (int n=1; n<arrayCount; n++){             //Combines everything BUT the fist and last element into a string
          lastName = lastName + parts[n] + " ";
      }
      lastName = lastName + parts[arrayCount];          //Adds last element to the string (avoids space at the end of the string)
      System.out.println("lastname " + lastName);
      return lastName;
    }
    
    
    public void setTableData() throws ParseException {
        System.out.println("setTableData in controller");
        String lastname = getLastNameFromCBox();
        Date date = parentScreen.getDate();
        ArrayList<ScheduleItem> scheduleItems = getSessionsForSchedule(date, lastname);
        ArrayList<String> datesFromTable = getScheduleDates( date);
        JTable table        = parentScreen.getTable();
        JTableHeader th     = table.getTableHeader();
        TableColumnModel tcm = th.getColumnModel();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        parentScreen.setTableHeaderDates( date );
        table.repaint();
        parentScreen.repaint();

            clearTable();
            
            ListIterator<String> di = datesFromTable.listIterator();
            
            for (ScheduleItem scheduleItem : scheduleItems) {                                   // for every scheduleItem
                for (int b = 0; b < model.getColumnCount(); b++){                               // for every column
                    String toBeSplit = (String) tcm.getColumn(b).getHeaderValue();
                    String splittedDate = toBeSplit.substring(toBeSplit.lastIndexOf(" ")+1);    // split the day from the date
                    if ( splittedDate.equals( scheduleItem.getDate() ) ){                       // if the date of the column matches the scheduleItem date
                        //System.out.println("matched date");
                        for(int c = 0; c < model.getRowCount(); c++){                           // for every row
                            if ( model.getValueAt(c, 0).equals( scheduleItem.getStartTime() ) ){    // if the row's time matches the scheduleItem's time
                                //System.out.println("matched time");
                                model.setValueAt( scheduleItem.getLastname() + " : " + scheduleItem.getBSN() , c, b);
                                
                            }
                            
                        }
                    }
                }
            }
            repaintTable();
    }
    
    
    
    public void repaintTable() {
        JTable table        = parentScreen.getTable();
    DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
    tableModel.fireTableDataChanged();
    table.repaint();

}
    
    private void clearTable() {
        DefaultTableModel tableModel = (DefaultTableModel)parentScreen.getTable().getModel();
        for(int x = 1; x < tableModel.getColumnCount(); x++)
        {
            for(int y = 0 ; y < tableModel.getRowCount(); y++)
            {
                tableModel.setValueAt(null, y, x);
            }
        }
    }
    
    
    
       public TableCellRenderer getRenderer() {
        return new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table,
                    Object value, boolean isSelected, boolean hasFocus,
                    int row, int column) {
                Component tableCellRendererComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus,row, column);
                if( (null == value) && isSelected == false ){
                    tableCellRendererComponent.setBackground(Color.GREEN);
                } 
//                    tableCellRendererComponent.setBackground(isSelected ? table.getSelectionBackground() : table.getBackground());
//                }
                return tableCellRendererComponent;
            }
        };
    }
       
       public void runTimer(){
           Timer timer = new Timer();
           timer.schedule( new TimerTask(){
               @Override
               public void run(){
                   parentScreen.refreshComboBox();    
               }
           }, 0, 8000);   
       }
         
}
