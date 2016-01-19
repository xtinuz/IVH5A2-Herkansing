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
    String address;
    String postal;
    String city;
    String phone;
    String email;
    String KVK;
    String IBAN;
    String BIC;
    String bank;
    
    public PhysioPractice(String name, String address, String postal, String city, String phone, String email, String KVK, String IBAN, String BIC, String bank){
        this.name = name;
        this.address = address;
        this.postal = postal;
        this.city = city;
        this.phone = phone;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address= address;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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