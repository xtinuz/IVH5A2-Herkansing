/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.shared.model.domain;

import java.io.Serializable;
import java.util.ArrayList;


public class Treatment implements Serializable {
    private int TreatmentID;
    private String TreatmentCode;
    private String BSN;
    private String PhysioTherapistLastName;
    private String Status;
    private ArrayList<Session> sessions;
    
    public Treatment(int TreatmentID, String TreatmentCode, String BSN, String PhysioTherapistLastName, String Status)
    {
        this.TreatmentID = TreatmentID;
        this.TreatmentCode = TreatmentCode;
        this.BSN = BSN;
        this.PhysioTherapistLastName = PhysioTherapistLastName;
        this.Status = Status;
        this.sessions = new ArrayList<Session>();
    }

    public int getTreatmentID() {
        return TreatmentID;
    }

    public void setTreatmentID(int TreatmentID) {
        this.TreatmentID = TreatmentID;
    }

    public String getTreatmentCode() {
        return TreatmentCode;
    }

    public void setTreatmentCode(String TreatmentCode) {
        this.TreatmentCode = TreatmentCode;
    }

    public String getBSN() {
        return BSN;
    }

    public void setBSN(String BSN) {
        this.BSN = BSN;
    }

    public String getPhysioTherapistLastName() {
        return PhysioTherapistLastName;
    }

    public void setPhysioTherapistLastName(String PhysioTherapistLastName) {
        this.PhysioTherapistLastName = PhysioTherapistLastName;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }   
    
    public void addSession(Session session){
        this.sessions.add(session);
    }
    
    public ArrayList<Session> getSessions(){
        return this.sessions;
    }
}
