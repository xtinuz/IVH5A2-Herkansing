/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.shared.model.domain;

import java.io.Serializable;
import java.util.Date;


public class Session implements Serializable {
    private Date Date;
    private Date StartTime;
    private Date EndTime;
    private String Notes;
    private String TreatmentID;
    
    public Session(Date Date, Date StartTime, Date EndTime, String Notes, String TreatmentID)
    {
        this.Date = Date;
        this.StartTime = StartTime;
        this.EndTime = EndTime;
        this.Notes = Notes;
        this.TreatmentID = TreatmentID;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date Date) {
        this.Date = Date;
    }

    public Date getStartTime() {
        return StartTime;
    }

    public void setStartTime(Date StartTime) {
        this.StartTime = StartTime;
    }

    public Date getEndTime() {
        return EndTime;
    }

    public void setEndTime(Date EndTime) {
        this.EndTime = EndTime;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String Notes) {
        this.Notes = Notes;
    }

    public String getTreatmentID() {
        return TreatmentID;
    }

    public void setTreatmentID(String TreatmentID) {
        this.TreatmentID = TreatmentID;
    }
}
