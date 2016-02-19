/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.shared.model.domain;

import java.io.Serializable;


    

/**
 *
 * @author ferdinand
 */
public class ScheduleItem implements Serializable{
    private String date;
    private String startTime;
    private String endTime;
    private String lastname;
    private int BSN;
    
    public ScheduleItem(String date, String startTime, String endTime, String lastname, int BSN){
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.lastname = lastname;
        this.BSN = BSN;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getBSN() {
        return BSN;
    }

    public void setBSN(int BSN) {
        this.BSN = BSN;
    }

    
    
}
