/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Model.Customer;
import Model.Employee;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Lenovo
 */
public class DAOCustomer extends DBContext {

    //check Customer Login
    public boolean checkLogin(String account, String password) throws SQLException {
        String sql = "Select password from Customer\n"
                + "where customerId = ?;";
        PreparedStatement pre = connection.prepareStatement(sql);
        pre.setString(1, account);
        ResultSet rs = pre.executeQuery();
        //check if the password is valid or not
        while (rs.next()) {
            if (rs.getString(1).equals(password)) {
                return true;
            }
        }
        return false;
    }

    //get Customer by id
    public Customer getCustomerById(String account) throws SQLException {
        String sql = "Select * from Customer\n"
                + "where customerId = ?";
        PreparedStatement pre = connection.prepareStatement(sql);
        pre.setString(1, account);
        ResultSet rs = pre.executeQuery();
        while (rs.next()) {
            return new Customer(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                    rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8));
        }
        return null;
    }

    //Create new Customer
    public void addCustomer(Customer cus) throws SQLException {
        String sql = "insert into Customer values(\n"
                + "	?,?,?,?,?,?,?,?\n"
                + ")";
        PreparedStatement pre = connection.prepareStatement(sql);
        pre.setString(1, cus.getCustomerId());
        pre.setString(2, cus.getCustomerPassword());
        pre.setString(3, cus.getCustomerPhone());
        pre.setString(4, cus.getCustomerAddress());
        pre.setString(5, cus.getCustomerFirstName());
        pre.setString(6, cus.getCustomerLastName());
        pre.setInt(7, cus.getCustomerGender());
        pre.setString(8, cus.getEmail());
        
        pre.execute();
    }
    
    public boolean checkIdExist(String cusId) throws SQLException{
        String sql = "Select * from Customer\n" +
            "where customerId = ?";
        PreparedStatement pre = connection.prepareStatement(sql);
        pre.setString(1, cusId);
        ResultSet rs = pre.executeQuery();
        while(rs.next()){
            return true;
        }
        return false;
    }

    public boolean checkEmailExist(String email) throws SQLException {
        String sql = "Select * from Customer\n" +
            "where email = ?";
        PreparedStatement pre = connection.prepareStatement(sql);
        pre.setString(1, email);
        ResultSet rs = pre.executeQuery();
        while(rs.next()){
            return true;
        }
        return false;
    }
    
    public Customer getCustomerByEmail(String email) throws SQLException{
        String sql = "Select * from Customer\n" +
            "where email = ?";
        PreparedStatement pre = connection.prepareStatement(sql);
        pre.setString(1, email);
        ResultSet rs = pre.executeQuery();
        while(rs.next()){
            return new Customer(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                    rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8));
        }
        return null;
    }
}
