package com.example.demo.repositories;

import com.example.demo.models.Department;
import com.example.demo.utility.DatabaseConnectionManager;

import java.sql.*;
import java.util.ArrayList;


public class  DepartmentRepository {

    public ArrayList<Department> getAllDepartments() {
        Connection con = DatabaseConnectionManager.getConnection();
        ArrayList<Department> allDepartments = new ArrayList<Department>();
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM departments");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Department temp = new Department(
                  rs.getInt(1),
                  rs.getString(2),
                  rs.getString(3)
                );
                allDepartments.add(temp);
            }
        }
        catch (SQLException e){
            System.out.println(e);
        }
        return allDepartments;
    }
}
