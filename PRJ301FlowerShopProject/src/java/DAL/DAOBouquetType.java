/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Model.BouquetType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Lenovo
 */
public class DAOBouquetType extends DBContext{
    //get All Bouquet type list
    public ArrayList<BouquetType> getBouquetTypeList() throws SQLException{
        ArrayList<BouquetType> list = new ArrayList();
        String sql = "select * from BouquetType";
        PreparedStatement pre = connection.prepareStatement(sql);
        ResultSet rs = pre.executeQuery();
        while(rs.next()){
            list.add(new BouquetType(rs.getInt(1), rs.getString(2)));
        }
        return list;
    }
    //get Bouquet Map
    public HashMap<Integer, String> getBouquetTypeMap() throws SQLException{
        HashMap<Integer, String> map = new HashMap<>();
        for(BouquetType x:getBouquetTypeList()){
            map.put(x.getBouquetTypeId(), x.getBouquetTypeName());
        }
        return map;
    }
    //getBouquetNameById
    public String getBouquetTypeNameById(int id) throws SQLException{
        String sql = "select * from BouquetType\n" +
            "where typeid = ?";
        PreparedStatement pre = connection.prepareStatement(sql);
        pre.setInt(1,id);
        ResultSet rs = pre.executeQuery();
        //Access all result elements
        while(rs.next()){
            return rs.getString(2);
        }
        return "";
    }
}
