/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.client.control;

import edu.avans.ivh5.api.PhysioManagerClientIF;
import edu.avans.ivh5.client.view.ui.LoginScreen;
import edu.avans.ivh5.client.view.ui.MainTabbedPaneScreen;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bernd_000
 */
public class LoginController implements ActionListener, KeyListener {

    private final PhysioManagerClientIF manager;
    private LoginScreen parentScreen;

    public LoginController(PhysioManagerClientIF manager) {
        this.manager = manager;
    }

    public void setUIRef(LoginScreen screen) {
        parentScreen = screen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        login();
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            switch (parentScreen.getFocusOwner().getName()) {
                case "loginButton":
                    login();
                    break;
                case "usernameField":
                    parentScreen.setFocus("passwordField");
                    break;
                case "passwordField":
                    login();
                    break;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    private void login() {
        System.out.println("trying to log in with:");
        System.out.println("username = " + parentScreen.getUsername());
        System.out.println("password = " + new String(parentScreen.getPassword()));
        boolean loginIsValid = false;
        try {
            loginIsValid = manager.checkPassword(parentScreen.getUsername(), parentScreen.getPassword());
        } catch (RemoteException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (loginIsValid) {
            parentScreen.dispose();
            new MainTabbedPaneScreen(manager);
        } else {
            parentScreen.setPasswordFieldBackground(Color.pink);
        }
    }
}
