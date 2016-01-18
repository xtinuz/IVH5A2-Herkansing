/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.server.model.dao.api;

import edu.avans.ivh5.shared.model.domain.Employee;
import java.util.ArrayList;

/**
 *
 * @author bernd_000
 */
public interface EmployeeDAOIF {
    
    public boolean saveEmployee(Employee employee);
 
    public boolean alterEmployee(Employee employee);
    
    public Employee getEmployee(String name);
    
    public boolean deleteEmployee(String employeeID);

    public ArrayList<Employee> getEmployees();
    
    public int getMaxID();
}
