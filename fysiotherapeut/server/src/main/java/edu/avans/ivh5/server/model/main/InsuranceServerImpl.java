/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.server.model.main;

import edu.avans.ivh5.api.PhysioManagerServerIF;
import edu.avans.ivh5.server.model.dao.DAOFactory;
import edu.avans.ivh5.server.model.dao.api.TreatmentAndSessionDAOIF;
import edu.avans.ivh5.shared.model.domain.SharedTreatment;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Geberuiker
 */
public class InsuranceServerImpl implements PhysioManagerServerIF{
    private final DAOFactory daoFactory;
        
    public InsuranceServerImpl(){
        daoFactory = DAOFactory.getDAOFactory("edu.avans.ivh5.server.model.dao.xml.dom.XmlDOMDAOFactory");
    }
    @Override
    public ArrayList<SharedTreatment> getAllFinishedTreatments() throws RemoteException{
        TreatmentAndSessionDAOIF dao = daoFactory.getTreatmentAndSessionDAO();
        return dao.getAllFinishedTreatments();
    }
}