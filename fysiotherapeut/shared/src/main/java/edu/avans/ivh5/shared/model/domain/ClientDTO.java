/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.shared.model.domain;

import java.io.Serializable;
import java.util.Date;


public class ClientDTO implements Serializable {
    public String Name;
    public String LastName;
    public String BSN;
    public Date BirthDate;
    public String Gender;
    public String EmailAdress;
    public String PhoneNumber;
    
    public ClientDTO(String Name,String LastName, String BSN, Date BirthDate, String Gender, String EmailAdress, String PhoneNumber  ){
        this.Name = Name;
        this.LastName = LastName;
        this.BSN = BSN;
        this.BirthDate = BirthDate;
        this.Gender = Gender;
        this.EmailAdress = EmailAdress;
        this.PhoneNumber = PhoneNumber;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getBSN() {
        return BSN;
    }

    public void setBSN(String BSN) {
        this.BSN = BSN;
    }

    public Date getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(Date BirthDate) {
        this.BirthDate = BirthDate;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getEmailAdress() {
        return EmailAdress;
    }

    public void setEmailAdress(String EmailAdress) {
        this.EmailAdress = EmailAdress;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }
    
}
