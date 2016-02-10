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
    private ArrayList<Schedule> scheduleItem;
    
    public Schedule(ArrayList scheduleItem){
            this.scheduleItem = scheduleItem;
    }
    
    public Schedule(Employee physiotherapist, ArrayList scheduleItem){
        this.physiotherapist = physiotherapist;
        this.scheduleItem = scheduleItem;
    }

    public Employee getPhysiotherapist() {
        return physiotherapist;
    }

    public void setPhysiotherapist(Employee physiotherapist) {
        this.physiotherapist = physiotherapist;
    }

    public ArrayList<Schedule> getScheduleItem() {
        return scheduleItem;
    }

    public void setScheduleItem(ArrayList<Schedule> scheduleItem) {
        this.scheduleItem = scheduleItem;
    }
    
     
    
}
