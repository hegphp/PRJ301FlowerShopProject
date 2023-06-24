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
public class DAOCustomer extends DBContext{
    //check Customer Login
    public boolean checkLogin(String account, String password) throws SQLException{
        String sql = "Select password from Customer\n" +
            "where customerId = ?;";
        PreparedStatement pre = connection.prepareStatement(sql);
        pre.setString(1, account);
        ResultSet rs = pre.executeQuery();
        //check if the password is valid or not
        while(rs.next()){
            if(rs.getString(1).equals(password))
                return true;
        }
        return false;
    }
    
    //get Customer by id
    public Customer getCustomerById(String account){
        return null;
    }
    
    //Create new Customer
    public void addCustomer(Customer cus){
        
    }
}
