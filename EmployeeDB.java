package RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class EmployeeDB extends UnicastRemoteObject implements EmployeeService {

    public EmployeeDB() throws RemoteException {

    }

    @Override
    public Employee getEmployee(String id) throws RemoteException {
       return Model.getEmployee(id);
    }

    @Override
    public void addNewEmployee(Employee employee) throws RemoteException {
        Model.addNewEmployee(employee);
    }

    @Override
    public void delete(String id) throws RemoteException {
        Model.delete(id);
    }

    @Override
    public ArrayList<Employee> getAll() throws RemoteException {
      
        return Model.getAll();
    }

    @Override
    public void update(String id, Employee employee) throws RemoteException {
        Model.update(id, employee);
    }
}
