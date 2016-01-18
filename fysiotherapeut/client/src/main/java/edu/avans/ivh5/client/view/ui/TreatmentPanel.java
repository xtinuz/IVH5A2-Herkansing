/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.client.view.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author bernd_000
 */
public class TreatmentPanel extends JPanel {

    private JButton logOutButton, newButton, changeButton, deleteButton;
    private JComboBox employeeBox;
    private JLabel overviewLabel;
    private JTextField searchField;
    private JFrame parentFrame;
    private JTable treatmentTable;
    private JMenuItem alter, delete;

    public TreatmentPanel(JFrame parentFrame) {
        this.parentFrame = parentFrame;
        setLayout(new BorderLayout());
        add(createNorthPanel(), BorderLayout.NORTH);
        add(createCenterPanel(), BorderLayout.CENTER);
    }

    private JPanel createNorthPanel() {
        JPanel panel = new JPanel();
        // panel consists of 5 columns and 3 rows
        panel.setLayout(new GridLayout(3, 5, 10, 10));

        // Begin row 1
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));

        logOutButton = new JButton("Log uit");
        logOutButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                parentFrame.dispose();
            }

        });
        panel.add(logOutButton);
        // end row 1

        // begin row 2
        employeeBox = new JComboBox();
        panel.add(employeeBox);

        panel.add(new JLabel(""));

        newButton = new JButton("Nieuwe behandeling");
        panel.add(newButton);
        changeButton = new JButton("Wijzig behandeling");
        panel.add(changeButton);
        deleteButton = new JButton("Verwijder behandeling");
        panel.add(deleteButton);
        // end row 2

        // begin row 3
        overviewLabel = new JLabel("Overzicht behandelingen: ");
        overviewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        panel.add(overviewLabel);

        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));

        searchField = new JTextField();
        panel.add(searchField);
        // end row 3

        return panel;
    }

    private JPanel createCenterPanel() {
        JPanel panel = new JPanel(new GridLayout(1, 1));
        panel.setBorder(new EmptyBorder(15, 10, 0, 10));

        Object rowData[][] = {{"1000", "Row1-Column2", "Row1-Column3", "Row1-Column4", "Row1-Column5"},
        {"1001", "Row2-Column2", "Row2-Column3", "Row2-Column4", "Row2-Column5"}};
        Object columnNames[] = {"ID", "Fysiotherapeut", "Cliënt", "Behandelcode", "Status"};
        treatmentTable = new JTable(rowData, columnNames);
        treatmentTable.setFillsViewportHeight(true);
        treatmentTable.getTableHeader().setBackground(Color.CYAN);
        treatmentTable.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    int row = treatmentTable.rowAtPoint(new Point(e.getX(), e.getY()));
                    // if the row is empty it will return -1
                    // you will not be able to right click on an empty row
                    if (row != -1) {
                        createRightClickMenu(row).show(treatmentTable, e.getX(), e.getY());
                    }
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

        });

        // Make the table vertically scrollable
        JScrollPane scrollPane = new JScrollPane(treatmentTable);

        panel.add(scrollPane);

        return panel;
    }

    private JPopupMenu createRightClickMenu(int row) {
        JPopupMenu menu = new JPopupMenu();

        String id = "";

        try {
            id = treatmentTable.getValueAt(row, 0) + "";
        } catch (Exception ex) {
        }

        alter = new JMenuItem("Wijzig behandeling " + id);
        alter.setName("" + row);
        alter.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // alterEmployee();
            }

        });

        delete = new JMenuItem("Verwijder behandeling " + id);
        delete.setName("" + row);
        delete.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // deleteEmployee();
            }

        });

        menu.add(alter);
        menu.add(delete);

        return menu;
    }
}
