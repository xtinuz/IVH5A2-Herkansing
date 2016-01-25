/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.client.view.ui;

import edu.avans.ivh5.api.PhysioManagerClientIF;
import edu.avans.ivh5.client.control.PhysioPracticeController;
import edu.avans.ivh5.client.control.ReportingController;
import edu.avans.ivh5.client.control.ScheduleController;
import edu.avans.ivh5.client.control.TherapistController;
import edu.avans.ivh5.client.control.TreatmentController;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author bernd_000
 */
public class MainTabbedPaneScreen extends JFrame {
    
    private final PhysioManagerClientIF manager;
    
    public MainTabbedPaneScreen(PhysioManagerClientIF manager) {
        this.manager = manager;
        setTitle("Fysiopraktijk");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        createTabs();
        
        setVisible(true);
    }
    
    private void createTabs() {
        JTabbedPane panes = new JTabbedPane();
        JPanel SchedulePanel = new SchedulePanel(this, new ScheduleController(this.manager));
        JPanel TreatmentsPanel = new TreatmentPanel(this, new TreatmentController(this.manager));
        JPanel OverviewPanel = new OverviewPanel(this, new ReportingController(this.manager));
        JPanel EmployeePanel = new EmployeePanel(this, new TherapistController(this.manager));
        JPanel CompanyInfoPanel = new CompanyInfoPanel(new PhysioPracticeController(this.manager));
        
        panes.add("Agenda", SchedulePanel);
        panes.add("Behandelingen", TreatmentsPanel);
        panes.add("Overzichten", OverviewPanel);
        panes.add("Fysiotherapeuten", EmployeePanel);
        panes.add("Praktijkgegevens", CompanyInfoPanel);
        
        add(panes);
    }
}
