/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.shared.model.domain;

import java.io.Serializable;

/**
 *
 * @author bernd_000
 */
public class SharedTreatment implements Serializable {
    private String BSN;
    private String treatmentCode;
    private int sessionAmount;

    public SharedTreatment(String BSN, String treatmentCode, int sessionAmount) {
        this.BSN = BSN;
        this.treatmentCode = treatmentCode;
        this.sessionAmount = sessionAmount;
    }

    public SharedTreatment() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getBSN() {
        return BSN;
    }

    public void setBSN(String BSN) {
        this.BSN = BSN;
    }

    public String getTreatmentCode() {
        return treatmentCode;
    }

    public void setTreatmentCode(String treatmentCode) {
        this.treatmentCode = treatmentCode;
    }

    public int getSessionAmount() {
        return sessionAmount;
    }

    public void setSessionAmount(int sessionAmount) {
        this.sessionAmount = sessionAmount;
    }
}
