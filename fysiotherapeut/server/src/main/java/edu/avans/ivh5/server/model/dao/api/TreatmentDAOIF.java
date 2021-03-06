/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.server.model.dao.api;

import edu.avans.ivh5.shared.model.domain.Treatment;
import edu.avans.ivh5.shared.model.domain.TreatmentType;
import java.rmi.RemoteException;
import java.util.ArrayList;


public interface TreatmentDAOIF {

    public void getSceduleTableData();
    
    public boolean deleteTreatment(Treatment treatment) throws RemoteException;
    
    public boolean deleteTreatmentByTreatmentID(int treatment) throws RemoteException;

    public ArrayList<TreatmentType> getTreatmentTypes() throws RemoteException; 
    
    public edu.avans.ivh5.shared.model.domain.TreatmentType getTreatmentTypeByTreatmentCode(String Treatmentcode);
    
}
