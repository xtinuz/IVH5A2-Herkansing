/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.api;

import edu.avans.ivh5.shared.model.domain.SharedTreatment;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;


public interface PhysioManagerServerIF extends Remote {
    //ArrayList<SharedTreatment> getAllFinishedTreatments() throws RemoteException;
    
    public ArrayList<edu.avans.ivh5.shared.model.domain.SharedTreatment> getAllFinishedTreatments() throws RemoteException;
    
}
