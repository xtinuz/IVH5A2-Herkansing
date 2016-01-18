/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.client.control;

import edu.avans.ivh5.api.PhysioManagerClientIF;
import edu.avans.ivh5.client.view.ui.OverviewPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.text.MessageFormat;
import javax.swing.JTable;

/**
 *
 * @author bernd_000
 */
public class ReportingController implements ActionListener {

    private final PhysioManagerClientIF manager;
    private OverviewPanel parentScreen;

    public ReportingController(PhysioManagerClientIF manager) {
        this.manager = manager;
    }

    public void setUIRef(OverviewPanel parentScreen) {
        this.parentScreen = parentScreen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("print")) {
            printTable();
        } else if (e.getActionCommand().equals("planningButton")) {
            parentScreen.setPanel("planningPanel");
        } else if (e.getActionCommand().equals("cumulatiefButton")) {
            parentScreen.setPanel("cumulatiefPanel");            
        } else if (e.getActionCommand().equals("financeButton")) {
            parentScreen.setPanel("financePanel");            
        }
    }

    private void printTable() {
        MessageFormat header = new MessageFormat("Test");
        MessageFormat footer = new MessageFormat("Test");
        try {
            JTable tableToPrint = parentScreen.getTable();
            System.out.println(tableToPrint.toString());
            tableToPrint.print(JTable.PrintMode.NORMAL, header, footer);
        } catch (PrinterException ex) {
            System.out.println("Unable to print the JTable");
        }
    }
}
