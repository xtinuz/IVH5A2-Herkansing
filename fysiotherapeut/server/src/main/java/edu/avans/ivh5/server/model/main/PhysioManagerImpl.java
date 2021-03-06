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
import edu.avans.ivh5.server.model.dao.api.TreatmentAndSessionDAOIF;
import edu.avans.ivh5.server.model.dao.api.TreatmentDAOIF;
import edu.avans.ivh5.server.model.dao.api.UserDAOIF;
import edu.avans.ivh5.shared.model.domain.ClientDTO;
import edu.avans.ivh5.shared.model.domain.Employee;
import edu.avans.ivh5.shared.model.domain.PhysioPractice;
import edu.avans.ivh5.shared.model.domain.Schedule;
import edu.avans.ivh5.shared.model.domain.Session;
import edu.avans.ivh5.shared.model.domain.Treatment;
import edu.avans.ivh5.shared.model.domain.TreatmentType;
import java.rmi.RemoteException;
import java.util.ArrayList;
import edu.avans.ivh5.shared.rmi.*;
import java.util.Random;

public class PhysioManagerImpl implements PhysioManagerClientIF {

    private final InsuranceServerInterface insuranceServer;
    private final DAOFactory daoFactory;
    private final PasswordManager passwordManager;
    private final String service;

    public PhysioManagerImpl(String service) {
        daoFactory = DAOFactory.getDAOFactory("edu.avans.ivh5.server.model.dao.xml.dom.XmlDOMDAOFactory");
        passwordManager = new PasswordManager();
        this.service = service;
        insuranceServer = PhysioServer.getInsuranceServerInterface();
    }

    //Login
    // <editor-fold>
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
// </editor-fold>

    //Employees
    // <editor-fold>
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

    @Override
    public Employee getTherapistBySession(int sessionID) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Employee> getTherapists() throws RemoteException {
        EmployeeDAOIF employeeDAO = daoFactory.getEmployeeDAO();
        //System.out.println("getTherapists in managerImpl");
        //System.out.println(employeeDAO.getEmployees());
        return employeeDAO.getEmployees();
    }
    // </editor-fold>

    //Treatment & Session
    // <editor-fold>
    @Override
    public boolean saveTreatment(Treatment treatment, ArrayList<Session> sessions) throws RemoteException {
        System.out.println("Saving treatment in manager");
        boolean saveSuccess = false;
        TreatmentAndSessionDAOIF dao = daoFactory.getTreatmentAndSessionDAO();
        // if the basic treatmentinfo is saved succesfully
        if (dao.saveTreatment(treatment)) {
            System.out.println("add the sessions");
            for (Session s : sessions) {
                s.setTreatmentID("" + dao.getMaxID());
                dao.saveSession(s);
            }
            saveSuccess = true;

        }
        System.out.println(saveSuccess + " test");
        return saveSuccess;
    }

    @Override
    public boolean alterTreatment(Treatment treatment) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteTreatment(Treatment treatment) throws RemoteException {
        TreatmentDAOIF dao = daoFactory.getTreatmentDAO();
        System.out.println("dao delete Treatment");
        return dao.deleteTreatment(treatment);
    }

    @Override
    public ArrayList<Treatment> getTreatments() throws RemoteException {
        System.out.println("getting treatments in ManagerImpl");
        TreatmentAndSessionDAOIF dao = daoFactory.getTreatmentAndSessionDAO();
        System.out.println("Got dao in ManagerImpl");
        return dao.getTreatments();
    }

    @Override
    public boolean deleteTreatmentByTreatmentID(int treatmentID) throws RemoteException {
        System.out.println("DeleteTreatmentByTreatmentID In de impl");
        TreatmentAndSessionDAOIF dao = daoFactory.getTreatmentAndSessionDAO();
        return dao.deleteTreatmentByTreatmentID(treatmentID);
    }

    @Override
    public ArrayList<Treatment> getTreatmentsByTherapistID(int therapistID) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Treatment getTreatmentBySession(int sessionID) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Treatment getTreatmentByID(int treatmentID) throws RemoteException {
        TreatmentAndSessionDAOIF dao = daoFactory.getTreatmentAndSessionDAO();
        Treatment treatment = dao.getTreatmentByTreatmentID(treatmentID);
        return treatment;
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

    @Override
    public ArrayList getAllSessionsByTreatmentID(int treatmentID) {
        System.out.println("getALlSessionsByTreatmentID in manager");
        TreatmentAndSessionDAOIF dao = daoFactory.getTreatmentAndSessionDAO();
        return dao.getSessionsByTreatmentID(treatmentID);
    }

    @Override
    public ArrayList<TreatmentType> getTreatmentTypes() throws RemoteException {
        System.out.println("getting treatmenttypes in managerimp");
        TreatmentDAOIF dao = daoFactory.getTreatmentDAO();
        System.out.println("got the dao in managerimp");
        return dao.getTreatmentTypes();
    }

    // </editor-fold>
    //CLient
    // <editor-fold>

    @Override
    public edu.avans.ivh5.shared.models.ClientDTO getClient(String needle) throws RemoteException { // needle is bsn
//        edu.avans.ivh5.shared.models.ClientDTO client = insuranceServer.getClient(needle);
//        System.out.println("Functionality getClient trough RMI");
//        System.out.println("Naam: " + client.getName() + " " + client.getLastName());
        
        return new edu.avans.ivh5.shared.models.ClientDTO("blabla", "bla", needle, "mail", "06000000");
    }

    @Override
    public String getBSNBySession(int sessionID) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    // </editor-fold>

    //Company
    //<editor-fold>
    @Override
    public PhysioPractice getCompanyInfo() {
        PhysioPracticeDAOIF dao = daoFactory.getPhysioPracticeDAO();
        return dao.getCompanyInfo();
    }

    @Override
    public void saveCompanyInfo(PhysioPractice practice) throws RemoteException {
        System.out.println("start saveCompany");

        PhysioPracticeDAOIF dao = daoFactory.getPhysioPracticeDAO();
        dao.savePhysioPractice(practice);
    }
    //</editor-fold>

    //Scedule
    //<editor-fold>
    @Override
    public Schedule getScheduleTableData(ArrayList dates, String lastname) throws RemoteException {
        System.out.println("manager getScheduleTableData");
        TreatmentAndSessionDAOIF dao = daoFactory.getTreatmentAndSessionDAO();
        Schedule schedule = dao.getScheduleTableData(dates, lastname);

        return schedule;

    }

    //</editor-fold>
//    @Override
//    public ArrayList<Session> getsessionsByDate(Date date1, Date date2) throws RemoteException{
//        ArrayList dates = new ArrayList();
//        System.out.println("manager getsessionsbyDate");
//        return dates;  
//    } 
}
