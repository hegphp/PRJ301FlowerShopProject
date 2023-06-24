/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Model.Flower;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class DAOFlower extends DBContext{
    //get all Flower
    public ArrayList<Flower> getFlowerList() throws SQLException{
        ArrayList<Flower> list = new ArrayList<>();
        String sql = "Select * from Flower";
        PreparedStatement pre = connection.prepareCall(sql);
        ResultSet rs = pre.executeQuery();
        //Access to all elements of Flower table
        while(rs.next()){
            list.add(new Flower(rs.getString(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getString(5), rs.getInt(6)));
        }
        return list;
    }
}
