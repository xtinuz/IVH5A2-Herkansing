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
    
    public boolean deleteTreatment(Treatment treatment);
    
    public boolean deleteTreatmentByTreatmentID(int treatment);
    
    public ArrayList<SharedTreatment> getAllFinishedTreatments();
    
    public Treatment getTreatmentByTreatmentID(int treatmentID);
    
    public int getMaxID();
    
    public boolean saveSession(Session session);
    
    public ArrayList<Treatment> getTreatments();
    
    public ArrayList getSessionsByTreatmentID(int treatmentID);
    
    public ArrayList getAllSessionsByDate(String firstDate, String secondDate);
    
}
