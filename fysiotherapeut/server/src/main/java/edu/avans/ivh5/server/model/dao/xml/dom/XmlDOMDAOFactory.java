/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.server.model.dao.xml.dom;

import edu.avans.ivh5.server.model.dao.DAOFactory;
import edu.avans.ivh5.server.model.dao.api.EmployeeDAOIF;
import edu.avans.ivh5.server.model.dao.api.PhysioPracticeDAOIF;
import edu.avans.ivh5.server.model.dao.api.SessionDAOIF;
import edu.avans.ivh5.server.model.dao.api.TreatmentDAOIF;
import edu.avans.ivh5.server.model.dao.api.UserDAOIF;

/**
 * The XML Document Object Model (DOM) implementation of the DAOFactory. This
 * factory provides XML DOM implementations for the domain classes in this
 * system.
 *
 * @author Robin Schellius
 */
public class XmlDOMDAOFactory extends DAOFactory {

    @Override
    public UserDAOIF getUserDAO() {
        return new XMLDOMUserDAO();
    }

    @Override
    public EmployeeDAOIF getEmployeeDAO() {
        return new XMLDOMEmployeeDAO();
    }
    
    @Override
    public PhysioPracticeDAOIF getPhysioPracticeDAO() {
        return new XMLDOMPhysioPracticeDAO();
    }

    @Override
    public SessionDAOIF getSessionDAO() {
        return new XMLDOMSessionDAO();
    }

    @Override
    public TreatmentDAOIF getTreatmentDAO() {
        return new XMLDOMTreatmentDAO();
    }
}
