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
import edu.avans.ivh5.client.control.TreatmentAndSessionController;
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
        createTabs();
        setTitle("Fysiopraktijk");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        setVisible(true);
    }
    
    private void createTabs() {
        JTabbedPane panes = new JTabbedPane();

        JPanel TreatmentsPanel = new TreatmentPanel(this, new TreatmentAndSessionController(manager));
        JPanel SchedulePanel = new SchedulePanel(this, new ScheduleController(manager));
        JPanel OverviewPanel = new OverviewPanel(this, new ReportingController(manager));
        JPanel EmployeePanel = new EmployeePanel(this, new TherapistController(manager));
        JPanel CompanyInfoPanel = new CompanyInfoPanel(new PhysioPracticeController(manager));
        
        panes.add("Agenda", SchedulePanel);
        panes.add("Behandelingen", TreatmentsPanel);
        panes.add("Overzichten", OverviewPanel);
        panes.add("Fysiotherapeuten", EmployeePanel);
        panes.add("Praktijkgegevens", CompanyInfoPanel);
        
        add(panes);
    }
}
