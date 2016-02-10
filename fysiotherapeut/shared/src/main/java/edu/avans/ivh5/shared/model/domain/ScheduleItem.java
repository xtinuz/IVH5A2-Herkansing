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
    private String startTime;
    private String endTime;
    private  Employee physio;
    private ClientDTO client;
    
    public ScheduleItem(String startTime, String endTime, Employee physio, ClientDTO client){
        this.startTime = startTime;
        this.endTime = endTime;
        this.physio = physio;
        this.client = client;
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

    public Employee getPhysio() {
        return physio;
    }

    public void setPhysio(Employee physio) {
        this.physio = physio;
    }

    public ClientDTO getClient() {
        return client;
    }

    public void setClient(ClientDTO client) {
        this.client = client;
    }
    
    
    
}
