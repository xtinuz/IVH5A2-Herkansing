/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.shared.model.domain;

import java.io.Serializable;


public class Treatment implements Serializable {
    private String TreatmentID;
    private String TreatmentCode;
    private String BSN;
    private String PhysioTherapistID;
    
    public Treatment(String TreatmentID, String TreatmentCode, String BSN, String PhysioTherapistID)
    {
        this.TreatmentID = TreatmentID;
        this.TreatmentCode = TreatmentCode;
        this.BSN = BSN;
        this.PhysioTherapistID = PhysioTherapistID;
    }

    public String getTreatmentID() {
        return TreatmentID;
    }

    public void setTreatmentID(String TreatmentID) {
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

    public String getPhysioTherapistID() {
        return PhysioTherapistID;
    }

    public void setPhysioTherapistID(String PhysioTherapistID) {
        this.PhysioTherapistID = PhysioTherapistID;
    }
    
}
