/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.server.model.dao.api;
import edu.avans.ivh5.shared.model.domain.Session;
import edu.avans.ivh5.shared.model.domain.TreatmentType;
import edu.avans.ivh5.shared.model.domain.Employee;
import edu.avans.ivh5.shared.model.domain.Schedule;
import edu.avans.ivh5.shared.models.*;
import edu.avans.ivh5.shared.model.domain.Treatment;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author IVH5
 */
public interface TreatmentAndSessionDAOIF {
    
    public boolean saveTreatment(Treatment treatment);
    
    public Schedule getScheduleTableData(ArrayList dates, String lastname);
    
    public boolean deleteTreatment(Treatment treatment) throws RemoteException;
    
    public boolean deleteTreatmentByTreatmentID(int treatment) throws RemoteException;
    
    public ArrayList<SharedTreatment> getAllFinishedTreatments();
    
    public int getMaxID();
    
}
