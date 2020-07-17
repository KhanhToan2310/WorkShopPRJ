/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author PHONG VU
 */
public class Model {
      
    public static Employee getEmployee(String id) {
        Employee employee = null;
        try {
            Connection conn;
            conn = ConnectDB.getConnection();
            String sql = "Select * from Employees Where ID ='" + id + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                String ID = rs.getString(1);
                String FirstName = rs.getString(2);
                String LastName = rs.getString(3);
                String Email = rs.getString(4);
                String Address = rs.getString(5);
                String Gender = rs.getString(6);
                employee = new Employee(ID, FirstName, LastName, Email, Address, Gender);

            }
            conn.close();
            return employee;
        } catch (SQLException e) {
            System.out.println("Add failed!");
        }
        return null;
    }

    
    public static void addNewEmployee(Employee employee)  {
        Connection conn;
        conn = ConnectDB.getConnection();
        String sql = "Insert into Employees values (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement prs = conn.prepareStatement(sql);
            prs.setString(1, employee.getID());
            prs.setString(2, employee.getFirstName());
            prs.setString(3, employee.getLastName());
            prs.setString(4, employee.getEmail());
            prs.setString(5, employee.getAddress());
            prs.setString(6, employee.getGender());
            prs.execute();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Add failed!");
            e.printStackTrace();
        }
    }

    
    public static void delete(String id)  {
        try {
            String sql = "Delete from Employees where ID = '" + id + "'";
            Connection conn = ConnectDB.getConnection();
            PreparedStatement prs = conn.prepareStatement(sql);
            prs.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public static ArrayList<Employee> getAll()  {
        ArrayList<Employee> list = new ArrayList();
        try {
            String sql = "Select * from Employees";
            Connection conn = ConnectDB.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String ID = rs.getString(1);
                String FirstName = rs.getString(2);
                String LastName = rs.getString(3);
                String Email = rs.getString(4);
                String Address = rs.getString(5);
                String Gender = rs.getString(6);
                list.add(new Employee(ID, FirstName, LastName, Email, Address, Gender));
            }
            conn.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    
    public static void update(String id, Employee employee) throws RemoteException {
        try {
            String sql = "Update Employees set ID =?, FirstName =?, LastName =?, Email =?, Address =?, Gender =? where ID ='" + id + "'";
            Connection conn = ConnectDB.getConnection();
            PreparedStatement prs = conn.prepareStatement(sql);
            prs.setString(1, employee.getID());
            prs.setString(2, employee.getFirstName());
            prs.setString(3, employee.getLastName());
            prs.setString(4, employee.getEmail());
            prs.setString(5, employee.getAddress());
            prs.setString(6, employee.getGender());
            prs.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
