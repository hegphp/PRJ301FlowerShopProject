/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
public class DALEmployee extends DBContext{
    public boolean checkLogin(String account, String password){
        String sql = "select * from Employee \n" +
            "where empId = ?\n" +
            "and password = ?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, account);
            pre.setString(2, password);
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DALEmployee.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return false;
    }
}
