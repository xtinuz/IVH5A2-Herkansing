/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.client.view.ui;

import edu.avans.ivh5.client.control.ReportingController;
import edu.avans.ivh5.client.control.TreatmentAndSessionController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;


public class OverviewPanel extends JPanel {

    private JButton logoutButton, planningButton, cumulatiefButton, financeButton, printButton, searchButton;
            /*setDaylyButton, setWeeklyButton, setMonthlyButton*/
    // private JDatePicker?
    private JLabel beginDateLabel, endDateLabel;
    private JComboBox employeeBox, treatmentBox, monthComboBox1, dayComboBox1, yearComboBox1, monthComboBox2, dayComboBox2, yearComboBox2;
    private final JPanel planningPanel, cumulatiefPanel, financePanel;
    private JTable planningTable, cumulatiefTable, financeTable, financeTotalsTable;
    private final JFrame parentFrame;
    private final ReportingController controller;
    private final TreatmentAndSessionController controller2;

    public OverviewPanel(JFrame parentFrame, ReportingController controller, TreatmentAndSessionController controller2) {
        this.parentFrame = parentFrame;
        this.controller = controller;
        this.controller2 = controller2;
        System.out.println("setting ui reference OverviewPanel");
        controller.setUIRef(this);
        setLayout(new BorderLayout());

        planningPanel = createPlanningPanel();
        cumulatiefPanel = createCumulatiefPanel();
        financePanel = createFinancePanel();

        add(createNorthPanel(), BorderLayout.NORTH);
        add(planningPanel, BorderLayout.CENTER);
    }

    private JPanel createNorthPanel() {
        JPanel panel = new JPanel();
        // panel consists of 5 columns and 5 rows
        panel.setLayout(new GridLayout(5, 5, 10, 10));

        // row 1
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));

        logoutButton = new JButton("Log uit");
        logoutButton.setActionCommand("logout");
        logoutButton.addActionListener(controller);
        panel.add(logoutButton);
        // end row 1

        // row 2
        panel.add(new JLabel(""));
//        employeeBox = new JComboBox();
//        panel.add(employeeBox);

        beginDateLabel = new JLabel("");
        panel.add(beginDateLabel);

        endDateLabel = new JLabel("");
        panel.add(endDateLabel);

        planningButton = new JButton("Planning");
        planningButton.setEnabled(false);
        planningButton.setActionCommand("planningButton");
        planningButton.addActionListener(controller);
        //panel.add(planningButton);
        panel.add(new JLabel(""));

        cumulatiefButton = new JButton("Cumulatief");
        cumulatiefButton.setActionCommand("cumulatiefButton");
        cumulatiefButton.addActionListener(controller);
        panel.add(cumulatiefButton);
        // end row 2

        // row 3
        panel.add(new JLabel(""));
//        panel.add(new JDateChooser());
//        panel.add(new JDateChooser());
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));

        financeButton = new JButton("Financieel");
        financeButton.setActionCommand("financeButton");
        financeButton.addActionListener(controller);
        panel.add(financeButton);
        // end row 3

        // row 4
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        // end row 4

        // row 5
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));

        printButton = new JButton("Print");
        printButton.setActionCommand("print");
        printButton.addActionListener(controller);
        panel.add(printButton);
        // end row 5

        return panel;
    }

    private JPanel createPlanningPanel() {
        JPanel panel = new JPanel(new GridLayout(1, 1));
        panel.setBorder(new EmptyBorder(15, 10, 0, 10));

        Object rowData[][] = {{"1000", "Row1-Column2", "Row1-Column3", "Row1-Column4", "Row1-Column5", "Row1-Column6"},
        {"1001", "Row2-Column2", "Row2-Column3", "Row2-Column4", "Row2-Column5", "Row2-Column6"}};
        Object columnNames[] = {"Datum", "Begintijd", "Eindtijd", "Fysiotherapeut", "CliÃ«nt", "Behandelcode"};
        planningTable = new JTable(rowData, columnNames);
        planningTable.setEnabled(false);
        planningTable.setFillsViewportHeight(true);
        planningTable.getTableHeader().setBackground(Color.CYAN);

        // Make the table vertically scrollable
        JScrollPane scrollPane = new JScrollPane(planningTable);

        panel.add(scrollPane);

        return panel;
        
    }

    private JPanel createCumulatiefPanel() {
        JPanel panel = new JPanel();

        panel.setLayout(new BorderLayout());

        // the northpanel has the buttons which control whether the
        // amount of session are shown for each day, week or month
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(1, 3));

//        setDaylyButton = new JButton("Dag");
//        northPanel.add(setDaylyButton);
//
//        setWeeklyButton = new JButton("Week");
//        northPanel.add(setWeeklyButton);
//
//        setMonthlyButton = new JButton("Maand");
//        northPanel.add(setMonthlyButton);
        northPanel.add(new JLabel("Begindatum:"));
        monthComboBox1 = new JComboBox();
        northPanel.add(monthComboBox1);
        dayComboBox1 = new javax.swing.JComboBox();
        northPanel.add(dayComboBox1);
        yearComboBox1 = new javax.swing.JComboBox();
        
        monthComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));

        dayComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        yearComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2016", "2015" }));
        
        northPanel.add(yearComboBox1);
        northPanel.add(new JLabel(""));
        northPanel.add(new JLabel(""));
        
        northPanel.add(new JLabel("Einddatum:"));
        monthComboBox2 = new JComboBox();
        northPanel.add(monthComboBox2);
        dayComboBox2 = new javax.swing.JComboBox();
        northPanel.add(dayComboBox2);
        yearComboBox2 = new javax.swing.JComboBox();
        northPanel.add(yearComboBox2);
        
        monthComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));

        dayComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        yearComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2016", "2015" }));
        

        searchButton = new javax.swing.JButton("Zoek");
        northPanel.add(searchButton);
        // end of northpanel

        // the centerpanel contains a jtable with the information
        // about the amount of sessions for each day/week/month
        JPanel centerPanel = new JPanel(new GridLayout(1, 1));
        panel.setBorder(new EmptyBorder(15, 10, 0, 10));

        Object rowData[][] = {{"1000", "Row1-Column2"},
        {"1001", "Row2-Column2"}};
        Object columnNames[] = {"Datum", "Aantal sessies"};
        cumulatiefTable = new JTable(rowData, columnNames);
        cumulatiefTable.setEnabled(false);
        cumulatiefTable.setFillsViewportHeight(true);
        cumulatiefTable.getTableHeader().setBackground(Color.CYAN);

        // Make the table vertically scrollable
        JScrollPane scrollPane = new JScrollPane(cumulatiefTable);

        centerPanel.add(scrollPane);
        // end of centerpanel

        // the southpanel contains the information about the total amount of sessions
        JPanel southPanel = new JPanel();

        southPanel.add(new JLabel("Totaal" + "(total sessions)"));

        // add the panels to the main panel
        panel.add(northPanel, BorderLayout.NORTH);
        panel.add(centerPanel, BorderLayout.CENTER);
        panel.add(southPanel, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createFinancePanel() {
        JPanel panel = new JPanel();

        panel.setLayout(new BorderLayout());

        // northpanel contains a combobox which allows the user
        // to select a treatmentcode
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(1, 5));

        JLabel label = new JLabel("Selecteer behandelcode: ");
        label.setFont(new Font("Arial", Font.PLAIN, 20));
        northPanel.add(label);

        treatmentBox = new JComboBox();
        northPanel.add(treatmentBox);

        northPanel.add(new JLabel(""));
        northPanel.add(new JLabel(""));
        northPanel.add(new JLabel(""));
        // end of northpanel

        // the centerpanel contains financial information for each treatment
        JPanel centerPanel = new JPanel(new GridLayout(1, 1));
        panel.setBorder(new EmptyBorder(15, 10, 0, 10));

        Object rowData[][] = {{"1000", "Row1-Column2", "Row1-Column3", "Row1-Column4", "Row1-Column5"},
        {"1001", "Row2-Column2", "Row2-Column3", "Row2-Column4", "Row2-Column5"}};
        Object columnNames[] = {"Behandelcode", "Aantal behandelingen", "Aantal sessies", "Prijs per sessie", "Totaal prijs"};
        financeTable = new JTable(rowData, columnNames);
        financeTable.setEnabled(false);
        financeTable.setFillsViewportHeight(true);
        financeTable.getTableHeader().setBackground(Color.CYAN);

        // Make the table vertically scrollable
        JScrollPane scrollPane = new JScrollPane(financeTable);

        centerPanel.add(scrollPane);
        // end of centerpanel

        // the southpanel contains the sums of the tables information
        JPanel southPanel = new JPanel(new GridLayout(1, 1));
        panel.setBorder(new EmptyBorder(15, 10, 0, 10));

        Object rowDataSouth[][] = {};
        Object columnNamesSouth[] = {"Totaal", "10", "5151", "41221", "324235"};
        financeTotalsTable = new JTable(rowDataSouth, columnNamesSouth);
        financeTotalsTable.getTableHeader().setBackground(Color.CYAN);
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) financeTotalsTable.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(SwingConstants.LEFT);

        // Make the table vertically scrollable
        JScrollPane scrollPane2 = new JScrollPane(financeTotalsTable);

        southPanel.setPreferredSize(new Dimension(0, 30));
        southPanel.add(scrollPane2);
        // end of southpanel

        // add the panels to the mainpanel
        panel.add(northPanel, BorderLayout.NORTH);
        panel.add(centerPanel, BorderLayout.CENTER);
        panel.add(southPanel, BorderLayout.SOUTH);

        return panel;
    }

    public JTable getTable() {
        if (!financeButton.isEnabled()) {
            return financeTable;
        } else if (!planningButton.isEnabled()) {
            return planningTable;
        } else if (!cumulatiefButton.isEnabled()) {
            return cumulatiefTable;
        }
        return null;
    }

    public void setPanel(String panel) {
        switch (panel) {
            case "planningPanel":
                planningButton.setEnabled(false);
                financeButton.setEnabled(true);
                cumulatiefButton.setEnabled(true);

                remove(cumulatiefPanel);
                remove(financePanel);
                add(BorderLayout.CENTER, planningPanel);
                break;
            case "cumulatiefPanel":
                cumulatiefButton.setEnabled(false);
                financeButton.setEnabled(true);
                planningButton.setEnabled(true);

                remove(planningPanel);
                remove(financePanel);
                add(BorderLayout.CENTER, cumulatiefPanel);
                revalidate();
                repaint();
                break;
            case "financePanel":
                financeButton.setEnabled(false);
                cumulatiefButton.setEnabled(true);
                planningButton.setEnabled(true);

                remove(planningPanel);
                remove(cumulatiefPanel);
                add(BorderLayout.CENTER, financePanel);
                revalidate();
                repaint();
                break;
        }
    }
        public Date getDate1(){
        Date date1 = null;
        try{
        String day = (String) dayComboBox1.getSelectedItem();
        String month = (String) monthComboBox1.getSelectedItem();
        String year = (String) yearComboBox1.getSelectedItem();
        
        String stringDate = day + month + year;
        Date formattedDate = new SimpleDateFormat("ddMMMMyyyy", Locale.US).parse(stringDate);
        date1 = formattedDate;
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        
        return date1;
    }
        
    public Date getDate2(){
        Date date2 = null;
        try{
        String day = (String) dayComboBox2.getSelectedItem();
        String month = (String) monthComboBox2.getSelectedItem();
        String year = (String) yearComboBox2.getSelectedItem();
        
        String stringDate = day + month + year;
        Date formattedDate = new SimpleDateFormat("ddMMMMyyyy", Locale.US).parse(stringDate);
        date2 = formattedDate;
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        
        return date2;
    }
    
//        public void setTableHeaderDates(Date date1, Date date2){
//        ArrayList datesOfSessions;
//        //String[] days = {"Zondag" ,"Maandag", "Dinsdag", "Woensdag", "Donderdag", "Vrijdag","Zaterdag"};
//        try {
//            ArrayList datesOfSession = controller2.getSessionDates(date1, date2);
//            JTableHeader th = cumulatiefTable.getTableHeader();
//            TableColumnModel tcm = th.getColumnModel();
//            for(int x = 1, y = tcm.getColumnCount()-1; x <= y; x++)
//            {
//                TableColumn tc = tcm.getColumn(x);
//                //tc.setHeaderValue("" + days[x-1] + " " + datesOfWeek.get(x-1) );
//                                
//            }
//            th.repaint();            
//            
//        } catch (ParseException ex) {
//            Logger.getLogger(SchedulePanel.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}
