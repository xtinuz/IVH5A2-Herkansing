/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.client.view.ui;

import edu.avans.ivh5.client.control.LoginController;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author bernd_000
 */
public class LoginScreen extends JFrame {
    
    private final LoginController controller;
    private JLabel usernameLabel, passwordLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginScreen(LoginController ctrl) {
        controller = ctrl;
        controller.setUIRef(this);
        init();
    }
    
    private void init() {
        setTitle("Log in");
        setSize(450, 300);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(createLoginPanel());

        setVisible(true);
        
    }

    private JPanel createLoginPanel() {
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(3, 2));
        loginPanel.setBorder(new EmptyBorder(80, 60, 80, 60));

        usernameLabel = new JLabel("Username: ");
        passwordLabel = new JLabel("Password: ");

        usernameField = new JTextField();
        usernameField.setName("usernameField");
        usernameField.addKeyListener(controller);

        passwordField = new JPasswordField();
        passwordField.setName("passwordField");
        passwordField.addKeyListener(controller);

        loginButton = new JButton("Log in");
        loginButton.setName("loginButton");
        loginButton.addActionListener(controller);

        loginPanel.add(usernameLabel);
        loginPanel.add(usernameField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(new JLabel(""));
        loginPanel.add(loginButton);

        return loginPanel;
    }
    
    public String getUsername() {
        return usernameField.getText();
    }
    
    public char[] getPassword() {
        return passwordField.getPassword();
    }
    
    public void setFocus(String focusOn) {
        if (focusOn.equals("passwordField")) {
            passwordField.requestFocus();
        }
    }
    
    public void setPasswordFieldBackground(Color c) {
        passwordField.setBackground(c);
    }
}
