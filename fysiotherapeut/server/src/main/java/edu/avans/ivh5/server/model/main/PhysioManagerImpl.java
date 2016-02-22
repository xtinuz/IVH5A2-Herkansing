/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.server.model.main;

import edu.avans.ivh5.api.PhysioManagerClientIF;
import edu.avans.ivh5.server.model.dao.DAOFactory;
import edu.avans.ivh5.server.model.dao.api.EmployeeDAOIF;
import edu.avans.ivh5.server.model.dao.api.PhysioPracticeDAOIF;
import edu.avans.ivh5.server.model.dao.api.SessionDAOIF;
import edu.avans.ivh5.server.model.dao.api.TreatmentAndSessionDAOIF;
import edu.avans.ivh5.server.model.dao.api.TreatmentDAOIF;
import edu.avans.ivh5.server.model.dao.api.UserDAOIF;
import edu.avans.ivh5.shared.model.domain.ClientDTO;
import edu.avans.ivh5.shared.model.domain.Employee;
import edu.avans.ivh5.shared.model.domain.PhysioPractice;
import edu.avans.ivh5.shared.model.domain.Schedule;
import edu.avans.ivh5.shared.model.domain.ScheduleItem;
import edu.avans.ivh5.shared.model.domain.Session;
import edu.avans.ivh5.shared.model.domain.Treatment;
import edu.avans.ivh5.shared.model.domain.TreatmentType;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PhysioManagerImpl implements PhysioManagerClientIF {

    private final DAOFactory daoFactory;
    private final PasswordManager passwordManager;
    private final String service;

    public PhysioManagerImpl(String service) {
        daoFactory = DAOFactory.getDAOFactory("edu.avans.ivh5.server.model.dao.xml.dom.XmlDOMDAOFactory");
        passwordManager = new PasswordManager();
        this.service = service;
    }

    @Override
    public boolean checkPassword(String username, char[] password) throws RemoteException {
        System.out.println("PhysioManagerImpl is checking password");
        UserDAOIF userDAO = daoFactory.getUserDAO();
        if (userDAO.checkUserExistance(username)) {
            String hashedPassword = passwordManager.hashPassword(
                    passwordManager.saltPassword(password, userDAO.getSalt(username))
                    .getBytes()
            );

            boolean passwordIsCorrect = userDAO.checkPassword(username, hashedPassword);
            System.out.println("PhysioManagerImpl returns: " + passwordIsCorrect + "\n");
            return passwordIsCorrect;
        }
        System.out.println("PhysioManagerImpl returns: false\n");
        return false;
    }

    
    //Employees
    @Override
    public boolean saveEmployee(Employee employee) throws RemoteException {
        System.out.println("Create employeeDao with daofactory");
        EmployeeDAOIF dao = daoFactory.getEmployeeDAO();
        System.out.println("dao saving employee");
        return dao.saveEmployee(employee);
    }

    @Override
    public void alterEmployee(Employee employee) throws RemoteException {
        System.out.println("alter employee in manager");
        EmployeeDAOIF dao = daoFactory.getEmployeeDAO();
        System.out.println("dao alter employee");
        dao.alterEmployee(employee);
    }

    @Override
    public boolean removeEmployee(String employeeID) throws RemoteException {
        System.out.println("delete employee in manager");
        EmployeeDAOIF dao = daoFactory.getEmployeeDAO();
        System.out.println("dao delete employee");
        return dao.deleteEmployee(employeeID);
    }

    @Override
    public ArrayList<Employee> getEmployees() throws RemoteException {
        EmployeeDAOIF dao = daoFactory.getEmployeeDAO();
        return dao.getEmployees();
    }

    @Override
    public int getMaxID() throws RemoteException {
        EmployeeDAOIF dao = daoFactory.getEmployeeDAO();
        return dao.getMaxID();
    }

    @Override
    public Employee getTherapist(String name) throws RemoteException {
        EmployeeDAOIF employeeDAO = daoFactory.getEmployeeDAO();
        return employeeDAO.getEmployee(name);
    }
    
    @Override
    public Employee getTherapistByTherapistID(int therapistID) throws RemoteException {
        EmployeeDAOIF employeeDAO = daoFactory.getEmployeeDAO();
        return employeeDAO.getEmployee(therapistID);
    }

    //Treatments
    @Override
    public boolean saveTreatment(Treatment treatment) throws RemoteException {
        System.out.println("Savinug treatmenrt: " + treatment.toString());
        TreatmentAndSessionDAOIF dao = daoFactory.getTreatmentAndSessionDAO();
        System.out.println("DAO Save treatment");
        return dao.saveTreatment(treatment);
    }

    @Override
    public boolean alterTreatment(Treatment treatment) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteTreatment(Treatment treatment) throws RemoteException {
        TreatmentDAOIF dao = daoFactory.getTreatmentDAO();
        System.out.println("dao alter Treatment");
        return dao.deleteTreatment(treatment);
    }
    
    
    @Override
    public boolean deleteTreatmentByTreatmentID(int treatmentID) throws RemoteException{
        TreatmentDAOIF dao = daoFactory.getTreatmentDAO();
        System.out.println("dao alter Treatment");
        return dao.deleteTreatmentByTreatmentID(treatmentID);
    }

    //Sessions
    @Override
    public boolean saveSession(Session session) throws RemoteException {
        System.out.println("save session in manager");
        TreatmentAndSessionDAOIF dao = daoFactory.getTreatmentAndSessionDAO();
        //dao.saveSession();
        return true; //change later 
    }

    @Override
    public boolean alterSession(Session session) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteSession(Session session) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //CLient
    @Override
    public ClientDTO getClient() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Treatment> getTreatmentsByTherapistID(int therapistID) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getBSNBySession(int sessionID) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Employee getTherapistBySession(int sessionID) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Treatment getTreatmentBySession(int sessionID) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Treatment getTreatmentByID(int treatmentID) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //Company
    @Override
    public PhysioPractice getCompanyInfo() {
        PhysioPracticeDAOIF dao = daoFactory.getPhysioPracticeDAO();
        return dao.getCompanyInfo();
    }

    @Override
    public void saveCompanyInfo(PhysioPractice practice) throws RemoteException{
        System.out.println("start saveCompany"); 


        PhysioPracticeDAOIF dao = daoFactory.getPhysioPracticeDAO();
        dao.savePhysioPractice(practice);
    }

    @Override
    public Schedule getScheduleTableData(ArrayList dates, String lastname) throws RemoteException{
        System.out.println("manager getScheduleTableData");
        TreatmentAndSessionDAOIF dao = daoFactory.getTreatmentAndSessionDAO();
        Schedule schedule = dao.getScheduleTableData(dates, lastname);
  
        return schedule;
   
    }
    
//    @Override
//    public ArrayList<Session> getsessionsByDate(Date date1, Date date2) throws RemoteException{
//        ArrayList dates = new ArrayList();
//        System.out.println("manager getsessionsbyDate");
//        return dates;  
//    }
    
    
    @Override
    public ArrayList<Employee> getTherapists() throws RemoteException {
       EmployeeDAOIF employeeDAO = daoFactory.getEmployeeDAO();
       System.out.println("getTherapists in managerImpl");
       System.out.println(employeeDAO.getEmployees());
        return employeeDAO.getEmployees();  
    }   
    
        
    @Override
    public ArrayList<TreatmentType> getTreatmentTypes() throws RemoteException {
        System.out.println("getting treatmenttypes in managerimp");
        TreatmentDAOIF dao = daoFactory.getTreatmentDAO();
        System.out.println("got the dao in managerimp");
        return dao.getTreatmentTypes();
    }
    
        @Override
    public ArrayList<Treatment> getTreatments() throws RemoteException {
        System.out.println("getting treatments in ManagerImpl");
        TreatmentAndSessionDAOIF dao = daoFactory.getTreatmentAndSessionDAO();
        System.out.println("Got dao in ManagerImpl");
        return dao.getTreatments();
    }
}
