/**
 *
 */
package edu.avans.ivh5.server.model.dao;

import edu.avans.ivh5.server.model.dao.api.EmployeeDAOIF;
import edu.avans.ivh5.server.model.dao.api.PhysioPracticeDAOIF;
import edu.avans.ivh5.server.model.dao.api.SessionDAOIF;
import edu.avans.ivh5.server.model.dao.api.TreatmentDAOIF;
import edu.avans.ivh5.server.model.dao.api.UserDAOIF;

/**
 * <p>
 * The DAO Factory is an abstract class that provides the functionality for
 * creating data access objects for different data source implementations. A
 * data source can be anything that can hold data, such as a relational
 * database, XML file, flat file, serialized Java objects, or even remote
 * servers. Using this factory, a client can ask to create a specific factory,
 * which in turn can create specific data access objects for the given data
 * source implementation. The DAO's handle the persistent storage of the
 * specific domain class, such as (in this case) a Member, Loan of Reservation.
 * </p><p>
 * Clients can ask this class to create a DAOFactory instance for a specific
 * implementation, based on the classname that is provided. The implementation
 * for the specific data source has to extend from this DAOFactory class.
 * </p>
 *
 * @author Robin Schellius
 *
 */
public abstract class DAOFactory {

    /**
     * This method creates an instance of the specified factory class and
     * returns the instance to the caller. The class of the instance created has
     * to extend DAOFactory, which forces it to implement the abstract methods
     * to get domain objects from this factory.
     *
     * @param factoryClassName The string indicating the complete package name
     * of the factory class that must be loaded.
     * <br/>Example factoryClassName:
     * <code>edu.avans.aei.ivh5.model.dao.rdbms.mysql.MySqlDAOFactory</code>
     *
     * @return An object instance of the requested factory class.
     * @see edu.avans.ivh5.server.model.dao.rdbms.mysql.MySqlDAOFactory
     * @see edu.avans.ivh5.server.model.dao.xml.dom.XmlDOMDAOFactory
     *
     */
    public static DAOFactory getDAOFactory(String factoryClassName) {

        DAOFactory factoryInstance = null;

        try {
            Class<?> factoryClass = Class.forName(factoryClassName);
            factoryInstance = (DAOFactory) factoryClass.newInstance();
        } catch (ClassNotFoundException e) {
        } catch (Exception e) {
        }

        return factoryInstance;
    }

    public abstract UserDAOIF getUserDAO();

    public abstract EmployeeDAOIF getEmployeeDAO();

    public abstract SessionDAOIF getSessionDAO();

    public abstract TreatmentDAOIF getTreatmentDAO();
    
    public abstract PhysioPracticeDAOIF getPhysioPracticeDAO();

}
