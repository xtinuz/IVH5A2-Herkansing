/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.shared.model.domain;

import java.io.Serializable;
/**
 *
 * @author Michel
 */
public class TreatmentType implements Serializable{
    private String TreatmentCode;
    private String TreatmentName;
    private double price;
    private String description;
    
public TreatmentType(String TreatmentCode, String TreatmentName, double price, String description) {
        this.TreatmentCode = TreatmentCode;
        this.TreatmentName = TreatmentName;
        this.price = price;
        this.description = description;
        }

    public String getTreatmentCode() {
        return TreatmentCode;
    }

    public void setTreatmentCode(String TreatmentCode) {
        this.TreatmentCode = TreatmentCode;
    }

    public String getTreatmentName() {
        return TreatmentName;
    }

    public void setTreatmentName(String TreatmentName) {
        this.TreatmentName = TreatmentName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
