/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.api;

import edu.avans.ivh5.shared.model.domain.ClientDTO;
import edu.avans.ivh5.shared.model.domain.Employee;
import edu.avans.ivh5.shared.model.domain.PhysioPractice;
import edu.avans.ivh5.shared.model.domain.Schedule;
import edu.avans.ivh5.shared.model.domain.Session;
import edu.avans.ivh5.shared.model.domain.Treatment;
import edu.avans.ivh5.shared.model.domain.TreatmentType;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;


public interface PhysioManagerClientIF extends Remote {
    public boolean checkPassword(String username, char[] password) throws RemoteException;
    
    //Employee
    
    public boolean saveEmployee(Employee employee) throws RemoteException;
    
    public void alterEmployee(Employee employee) throws RemoteException;
    
    public boolean removeEmployee(String employeeID) throws RemoteException;

    public ArrayList<Employee> getEmployees() throws RemoteException;
    
    public int getMaxID() throws RemoteException;
    
    public Employee getTherapist(String name) throws RemoteException;
    
    public Employee getTherapistByTherapistID(int therapistID) throws RemoteException;
    
    //Treatment
    
    public boolean saveTreatment(Treatment treatment, ArrayList<Session> sessions) throws RemoteException;
    
    public boolean alterTreatment(Treatment treatment) throws RemoteException;
    
    public boolean deleteTreatment(Treatment treatment) throws RemoteException;
    
    public boolean deleteTreatmentByTreatmentID(int treatmentID) throws RemoteException;
    
    public boolean saveSession(Session session) throws RemoteException;
    
    public boolean alterSession(Session session) throws RemoteException;
    
    public boolean deleteSession(Session session) throws RemoteException;
    
    public edu.avans.ivh5.shared.models.ClientDTO getClient(String needle) throws RemoteException;
    
    public ArrayList<Treatment> getTreatmentsByTherapistID(int therapistID) throws RemoteException;
    
    public String getBSNBySession(int sessionID) throws RemoteException;
    
    public Employee getTherapistBySession(int sessionID) throws RemoteException;
    
    public Treatment getTreatmentBySession(int sessionID) throws RemoteException;
    
    public Treatment getTreatmentByID(int treatmentID) throws RemoteException;
    
    public void saveCompanyInfo(PhysioPractice practice) throws RemoteException;
    
    public PhysioPractice getCompanyInfo() throws RemoteException; 

    public Schedule getScheduleTableData(ArrayList dates, String lastname) throws RemoteException;    

    public ArrayList<Employee> getTherapists() throws RemoteException;

    //public ArrayList<Session> getsessionsByDate(Date date1, Date date2) throws RemoteException;
    
    public ArrayList<TreatmentType> getTreatmentTypes() throws RemoteException;
    
    public ArrayList<Treatment> getTreatments() throws RemoteException;
    
    public ArrayList getAllSessionsByTreatmentID(int treatmentID) throws RemoteException;
}
