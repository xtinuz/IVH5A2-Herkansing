/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.shared.model.domain;

import java.util.Date;

/**
 *
 * @author Sjonn
 */
public class PhysioPractice {
    String name;
    String streetname;
    String houseNo;
    String postalcode;
    String city;
    String phoneNo;
    String email;
    String KVK;
    String IBAN;
    String BIC;
    String bank;
    
    public PhysioPractice(String name, String streetname, String houseNo, String postalcode, String city, String phoneNo, String email, String KVK, String IBAN, String BIC, String bank){
        this.name = name;
        this.streetname = streetname;
        this.houseNo = houseNo;
        this.postalcode = postalcode;
        this.city = city;
        this.phoneNo = phoneNo;
        this.email = email;
        this.KVK = KVK;
        this.IBAN = IBAN;
        this.BIC = BIC;
        this.bank = bank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreetname() {
        return streetname;
    }

    public void setStreetname(String streetname) {
        this.streetname = streetname;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKVK() {
        return KVK;
    }

    public void setKVK(String KVK) {
        this.KVK = KVK;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public String getBIC() {
        return BIC;
    }

    public void setBIC(String BIC) {
        this.BIC = BIC;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }
    
    public PhysioPractice(){}
    
}