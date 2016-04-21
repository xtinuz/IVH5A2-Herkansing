/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.server.model.main;

import edu.avans.ivh5.shared.rmi.*;
import edu.avans.ivh5.shared.models.*;
import edu.avans.ivh5.server.model.dao.DAOFactory;
import edu.avans.ivh5.server.model.dao.api.TreatmentAndSessionDAOIF;
import edu.avans.ivh5.shared.model.domain.TreatmentType;
import java.rmi.RemoteException;
import java.util.ArrayList;


/**
 *
 * @author Geberuiker
 */
public class InsuranceServerImpl implements PhysioServerInterface{
    private final DAOFactory daoFactory;
        
    public InsuranceServerImpl(){
        daoFactory = DAOFactory.getDAOFactory("edu.avans.ivh5.server.model.dao.xml.dom.XmlDOMDAOFactory");
    }
    
    @Override
    public ArrayList<SharedTreatment> getAllFinishedTreatments() throws RemoteException{
        TreatmentAndSessionDAOIF dao = daoFactory.getTreatmentAndSessionDAO();
        return dao.getAllFinishedTreatments();
    }
    
    @Override
    public TreatmentType getTreatmentTypeByTreatmentCode(String Treatmentcode) throws RemoteException{
        TreatmentAndSessionDAOIF dao = daoFactory.getTreatmentAndSessionDAO();
        return null;
    }

}