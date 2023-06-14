/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Model.Customer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Lenovo
 */
public class DALCustomer extends DBContext{
    //Add customer
    public boolean addCustomer(Customer newCustomer) throws SQLException{
        PreparedStatement pre;
        String sql;
        //Check if the id or password is empty
        if(newCustomer.getId().isEmpty()||newCustomer.getPassword().isEmpty())
            return false;
        //Check if the id is duplicate
        sql = "Select * from Customer "
            + "where customerId = ?";
        pre = connection.prepareStatement(sql);
        pre.setString(1,newCustomer.getId());
        ResultSet rs = pre.executeQuery();
        while(rs.next()){
            return false;
        }
        //Create SQL statement
        sql = "insert into Customer values(\n" +
        "	?,?,?,?,?,?,?\n" +
        ")";
        pre = connection.prepareStatement(sql);
        pre.setString(1,newCustomer.getId());
        pre.setString(2,newCustomer.getPassword());
        pre.setString(3,newCustomer.getPhoneNumber());
        pre.setString(4,newCustomer.getAddress());
        pre.setString(5,newCustomer.getFirstName());
        pre.setString(6,newCustomer.getLastName());
        pre.setString(7,newCustomer.getEmail());
        return pre.executeUpdate() > 0;
    }

    public boolean checkLogin(String account, String password) throws SQLException {
        boolean flag = false;
        //Create sql statement
        String sql = "Select * from Customer\n" +
        "where customerId = ?\n" +
        "and password = ?";
        PreparedStatement pre = connection.prepareStatement(sql);
        pre.setString(1,account);
        pre.setString(2,password);
        ResultSet rs = pre.executeQuery();
        //check if the information is contained in the database or not
        while(rs.next()){
            flag = true;
        }
        return flag;
    }
}
