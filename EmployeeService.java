/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author PHONG VU
 */
public interface EmployeeService extends Remote{

    Employee getEmployee(String id) throws RemoteException;

    void addNewEmployee(Employee employee) throws RemoteException;

    void delete(String id) throws RemoteException;

    ArrayList<Employee> getAll() throws RemoteException;

    void update(String id, Employee employee) throws RemoteException;
}
