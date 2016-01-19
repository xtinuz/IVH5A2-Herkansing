/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.client.control;

import edu.avans.ivh5.api.PhysioManagerClientIF;
import edu.avans.ivh5.client.view.ui.AddEmployeeScreen;
import edu.avans.ivh5.client.view.ui.EmployeePanel;
import edu.avans.ivh5.client.view.ui.LoginScreen;
import edu.avans.ivh5.shared.model.domain.Employee;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

/**
 *
 * @author ferdinand
 */
public class TherapistController implements ActionListener, KeyListener, MouseListener {

    private AddEmployeeScreen parentScreen;
    private EmployeePanel parentPanel;
    private PhysioManagerClientIF manager;

    public TherapistController(PhysioManagerClientIF manager) {
        this.manager = manager;
    }

    public void saveEmployee(Employee employee) {
        employee = parentScreen.getEmployee();

    }

    public void setUIRef(AddEmployeeScreen parentScreen) {
        this.parentScreen = parentScreen;
    }

    public void setUIRef(EmployeePanel parentScreen) {
        this.parentPanel = parentScreen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "saveEmployee":
                System.out.println("actioncommand saveEmployee");
                new AddEmployeeScreen(this, "newEmployee");
                break;
            case "alter":
                System.out.println("actioncommand alter");
                Employee tempEmployee = parentPanel.getEmployee();
                try {
                    new AddEmployeeScreen(
                            this,
                            "alterEmployee",
                            tempEmployee.getID(),
                            tempEmployee.getFirstname(),
                            tempEmployee.getLastname(),
                            tempEmployee.getPhoneNr(),
                            tempEmployee.getEmail()
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
            case "delete":
                System.out.println("actioncommand delete");
                 {
                    try {
                        if (manager.removeEmployee(parentPanel.getEmployee().getID())) {
                            System.out.println("Deleting employee with id: " + parentPanel.getEmployee().getID());
                            parentPanel.removeRow(parentPanel.getTable().getSelectedRow());
                        }
                    } catch (RemoteException ex) {
                        
                    }
                }
                break;
            case "confirmSave":
                System.out.println("actioncommand confirmsave");
                 {
                    try {
                        if (manager.saveEmployee(parentScreen.getEmployee())) {
                            parentPanel.addEmployee(parentScreen.getEmployee(), manager.getMaxID());
                        }
                    } catch (RemoteException ex) {
                        Logger.getLogger(TherapistController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                parentScreen.dispose();
                break;
            case "confirmAlter":
                System.out.println("actioncommand confirmAlter");
                 {
                    try {
                        Employee AlteredEmployee = parentScreen.getEmployee();
                        //System.out.println("trying to alter Employee towards the manager");
                        manager.alterEmployee(AlteredEmployee);
                        this.parentPanel.updateTableRow(AlteredEmployee);
                        //System.out.println("altered the employee in the manager");
                    } catch (RemoteException ex) {
                        System.out.println("RemoteException is gedaan");
                        Logger.getLogger(TherapistController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
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

    public void addEmployees() {
        try {
            parentPanel.addEmployees(manager.getEmployees());
        } catch (RemoteException ex) {
            System.out.println("RemoteException at AddEmployees()");
            System.out.println(ex.getMessage());
        }
    }
}
