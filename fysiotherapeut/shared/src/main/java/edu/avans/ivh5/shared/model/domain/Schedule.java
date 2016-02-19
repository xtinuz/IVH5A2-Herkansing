/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.shared.model.domain;

import java.util.ArrayList;
import java.io.Serializable;
/**
 *
 * @author ferdinand
 */
public class Schedule implements Serializable {
    private Employee physiotherapist;
    private ArrayList<ScheduleItem> scheduleItem;
    
    public Schedule(ArrayList scheduleItems){
            this.scheduleItem = scheduleItems;
    }
    
    public Schedule(String lastname, ArrayList scheduleItems){
        this.physiotherapist = physiotherapist;
        this.scheduleItem = scheduleItems;
    }

    public Employee getPhysiotherapist() {
        return physiotherapist;
    }

    public void setPhysiotherapist(Employee physiotherapist) {
        this.physiotherapist = physiotherapist;
    }

    public ArrayList<ScheduleItem> getScheduleItems() {
        return scheduleItem;
    }

    public void setScheduleItem(ArrayList<ScheduleItem> scheduleItem) {
        this.scheduleItem = scheduleItem;
    }


    
     
    
}
