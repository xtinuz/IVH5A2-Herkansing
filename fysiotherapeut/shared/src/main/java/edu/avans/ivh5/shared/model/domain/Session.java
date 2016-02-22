/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.shared.model.domain;

import java.io.Serializable;
import java.util.Date;


public class Session implements Serializable {
    private String Date;
    private String StartTime;
    private String EndTime;
    private String Notes;
    private String TreatmentID;
    
    public Session(String Date, String StartTime, String EndTime, String Notes, String TreatmentID)
    {
        this.Date = Date;
        this.StartTime = StartTime;
        this.EndTime = EndTime;
        this.Notes = Notes;
        this.TreatmentID = TreatmentID;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getStartTime() {
        return StartTime;
    }

    public void setStartTime(String StartTime) {
        this.StartTime = StartTime;
    }

    public String getEndTime() {
        return EndTime;
    }

    public void setEndTime(String EndTime) {
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
