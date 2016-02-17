/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.client.control;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author ferdinand
 */
public class CustomRenderer extends DefaultTableCellRenderer {
    JLabel label = new JLabel();
    
    public CustomRenderer(){
        
    }
    
    public Component getTableCellRendererComponent( JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column){
        label.setText("test");
        label.setBackground(Color.GREEN);
        return label;
    }
    
}
