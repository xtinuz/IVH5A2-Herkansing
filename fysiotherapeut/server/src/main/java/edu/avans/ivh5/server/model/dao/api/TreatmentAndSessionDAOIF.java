/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.server.model.dao.api;

import edu.avans.ivh5.shared.model.domain.Schedule;
import edu.avans.ivh5.shared.model.domain.Treatment;
import java.rmi.RemoteException;
import java.util.ArrayList;


public interface TreatmentAndSessionDAOIF {
    
    public Schedule getSceduleTableData(ArrayList dates, String lastname);
    
    public boolean deleteTreatment(Treatment treatment) throws RemoteException;
    
    public boolean deleteTreatmentByTreatmentID(int treatment) throws RemoteException;
    
}
