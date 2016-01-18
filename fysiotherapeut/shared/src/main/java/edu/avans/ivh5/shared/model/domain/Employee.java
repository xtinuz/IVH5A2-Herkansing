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
public class Employee implements Serializable {

    private String ID;
    private String firstname;
    private String lastname;
    private String phoneNr;
    private String email;

    public Employee(String ID, String firstname, String lastname, String phoneNr, String email) {
        this.ID = ID;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phoneNr = phoneNr;
        this.email = email;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhoneNr() {
        return phoneNr;
    }

    public void setPhoneNr(String phoneNr) {
        this.phoneNr = phoneNr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
