package com.example.demo.repositories;

import com.example.demo.models.Department;
import com.example.demo.models.Employee;
import com.example.demo.utility.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeRepository {
    public ArrayList<Employee> getAllEmployes(){
        Connection con = DatabaseConnectionManager.getConnection();
        ArrayList<Employee> allEmployees = new ArrayList<Employee>();
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM employees");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Employee temp = new Employee(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8)
                );
                allEmployees.add(temp);
            }
        }
        catch (SQLException e){
            System.out.println(e);
        }
        return allEmployees;
    }
    public Employee searchForEmployee(int id){
        Connection con = DatabaseConnectionManager.getConnection();
        Employee target = new Employee();
        try{
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM employees WHERE ID="+id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                target.setId(rs.getInt(1));
                target.setName(rs.getString(2));
                target.setJob(rs.getString(3));
                target.setManager(rs.getString(4));
                target.setHireDate(rs.getString(5));
                target.setSalary(rs.getInt(6));
                target.setCommision(rs.getInt(7));
                target.setDepartment(rs.getInt(8));
            }
        }
        catch (SQLException e){
            System.out.println(e);
        }
        return target;
    }
    public void createEmployee(int id, String name, String job, String manager, String hireDate, int salary, int commision, String department){
        Connection con = DatabaseConnectionManager.getConnection();
        try{
            PreparedStatement stmt = con.prepareStatement("INSERT INTO employees VALUES("+id+",'"+name+"','"+job+"','"+manager+"','"+hireDate+"',"+salary+","+commision+",'"+department+"');");
            stmt.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
}
