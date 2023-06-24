/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Model.Employee;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Lenovo
 */
public class DAOEmployee extends DBContext{
    //check Employee login
    public boolean checkLogin(String account, String password) throws SQLException{
        //check the input is null value or not
        if(account.isEmpty()||password.isEmpty()){
            return false;
        }
        String sql = "Select * from Employee\n" +
            "where empId = ?\n" +
            "and password = ?";
        PreparedStatement pre = connection.prepareStatement(sql);
        pre.setString(1, account);
        pre.setString(2, password);
        ResultSet rs = pre.executeQuery();
        //check if the password is equal to the password user typed or not
        while(rs.next()){
            return true;
        }
        return false;
    }
    //getEmployee by Id
    public Employee getEmployeeById(String id) throws SQLException, ParseException{
        Employee newEmployee = new Employee();
        String sql = "select * from Employee\n" +
        "where empId = ?";
        PreparedStatement pre = connection.prepareStatement(sql);
        pre.setString(1, id);
        ResultSet rs = pre.executeQuery();
        String gender;
        //get All Employee value
        while(rs.next()){
            newEmployee.setEmpId(rs.getString(1));
            newEmployee.setEmpPassword(rs.getString(2));
            newEmployee.setEmpPhone(rs.getString(3));
            newEmployee.setEmpAddress(rs.getString(4));
            newEmployee.setEmpFirstName(rs.getString(5));
            newEmployee.setEmpLastName(rs.getString(6));
            
            //convert gender from number to String
            if(rs.getInt(7)==1){
                gender = "Male";
            }else{
                gender = "Female";
            }
            newEmployee.setEmpGender(gender);
            
            newEmployee.setEmpEmail(rs.getString(8));
            newEmployee.setEmpRole(rs.getString(9));
        }
        return newEmployee;
    }
    //get All Employee
    public ArrayList<Employee> getEmployeeList() throws SQLException{
        ArrayList<Employee> list = new ArrayList<>();
        String sql = "Select * from Employee";
        PreparedStatement pre = connection.prepareStatement(sql);
        ResultSet rs = pre.executeQuery();
        //access all Employee table elements
        while(rs.next()){
            list.add(new Employee(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                    rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)));
        }
        return list;
    }
}
