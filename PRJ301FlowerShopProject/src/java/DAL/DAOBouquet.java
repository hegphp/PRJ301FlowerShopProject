/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Model.Bouquet;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class DAOBouquet extends DBContext{
    //Get all bouquet list
    public ArrayList<Bouquet> getBouquetList() throws SQLException{
        ArrayList<Bouquet> list = new ArrayList();
        String sql = "select * from Bouquet";
        PreparedStatement pre = connection.prepareStatement(sql);
        ResultSet rs = pre.executeQuery();
        //access all Bouquet table data
        while(rs.next()){
            list.add(new Bouquet(rs.getString(1), rs.getString(2),rs.getInt(3), rs.getString(4), rs.getFloat(5), rs.getFloat(6), rs.getString(7), rs.getInt(8)));
        }
        return list;
    }
    //get Bouquet by ID
    public Bouquet getBouquetById(String id) throws SQLException{
        String sql = "select * from Bouquet\n" +
            "where bouquetId = ?";
        PreparedStatement pre = connection.prepareStatement(sql);
        ResultSet rs = pre.executeQuery();
        //Access every values of Bouquet founded
        while(rs.next()){
            return new Bouquet(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4),
                    rs.getFloat(5), rs.getFloat(6), rs.getString(7), rs.getInt(8));
        }
        return null;
    }
    //Add bouquet
    public void addBouquet(Bouquet newBouquet) throws SQLException{
        String sql = "INSERT INTO Bouquet (bouquetId, bouquetName, description,type, price, discount, imageUrl, quantity)\n" +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement pre = connection.prepareStatement(sql);
        pre.setString(1, newBouquet.getBouquetId());
        pre.setString(2, newBouquet.getBouquetName());
        pre.setString(3, newBouquet.getBouquetDesc());
        pre.setInt(4, newBouquet.getBouquetType());
        pre.setFloat(5, newBouquet.getBouquetPrice());
        pre.setFloat(6, newBouquet.getBouquetDiscount());
        pre.setString(7, newBouquet.getBouquetImageUrl());
        pre.setInt(8, newBouquet.getBouquetQuantity());
        pre.execute();
    }
    //Delelte Bouquet
}
