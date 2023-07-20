/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Model.Bouquet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Lenovo
 */
public class DAOBouquet extends DBContext {

    //Get all bouquet list
    public ArrayList<Bouquet> getBouquetList() throws SQLException {
        ArrayList<Bouquet> list = new ArrayList();
        String sql = "select * from Bouquet";
        PreparedStatement pre = connection.prepareStatement(sql);
        ResultSet rs = pre.executeQuery();
        //access all Bouquet table data
        while (rs.next()) {
            list.add(new Bouquet(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4),
                    rs.getFloat(5), rs.getFloat(6), rs.getString(7), rs.getInt(8), rs.getBoolean(9)));
        }
        return list;
    }

    //get Bouquet by ID
    public Bouquet getBouquetById(String id) throws SQLException {
        String sql = "select * from Bouquet\n"
                + "where bouquetId = ?";
        PreparedStatement pre = connection.prepareStatement(sql);
        pre.setString(1, id);
        ResultSet rs = pre.executeQuery();
        //Access every values of Bouquet founded
        while (rs.next()) {
            return new Bouquet(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4),
                    rs.getFloat(5), rs.getFloat(6), rs.getString(7), rs.getInt(8), rs.getBoolean(9));
        }
        return null;
    }
    
    public ArrayList<Bouquet> getBouquetListByTypeId(int id) throws SQLException{
        ArrayList<Bouquet> list = new ArrayList<>();
        String sql = "select * \n" +
            "from Bouquet \n" +
            "where bouquetTypeId = ?";
        PreparedStatement pre = connection.prepareStatement(sql);
        pre.setInt(1, id);
        ResultSet rs = pre.executeQuery();
        //Access every element of table
        while(rs.next()){
            list.add(new Bouquet(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4),
                    rs.getFloat(5), rs.getFloat(6), rs.getString(7), rs.getInt(8), rs.getBoolean(9)));
        }
        return list;
    }

    //Add bouquet
    public void addBouquet(Bouquet newBouquet) throws SQLException {
        String sql = "INSERT INTO Bouquet (bouquetId, bouquetName, description,bouquetTypeId,"
                + " price, discount, imageUrl, quantity, isDisplayed)\n"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement pre = connection.prepareStatement(sql);
        pre.setString(1, newBouquet.getBouquetId());
        pre.setString(2, newBouquet.getBouquetName());
        pre.setString(3, newBouquet.getBouquetDesc());
        pre.setInt(4, newBouquet.getBouquetType());
        pre.setFloat(5, newBouquet.getBouquetPrice());
        pre.setFloat(6, newBouquet.getBouquetDiscount());
        pre.setString(7, newBouquet.getBouquetImageUrl());
        pre.setInt(8, newBouquet.getBouquetQuantity());
        pre.setBoolean(9, newBouquet.isDisplayed());
        pre.execute();
    }

    //Delete Bouquet
    public void deleteBouquetById(String id) throws SQLException {
        String sql = "delete from Bouquet\n"
                + "where bouquetId = ?";
        PreparedStatement pre = connection.prepareStatement(sql);
        pre.setString(1, id);
        pre.execute();
    }

    //update Bouquet
    public void updateBouquet(Bouquet newBouquet, String bouquetId) throws SQLException {
        String sql = "update Bouquet\n"
                + "set bouquetId = ?,\n" //1
                + "bouquetName = ?,\n"  //2
                + "bouquetTypeId = ?,\n" //3
                + "description = ?,\n" //4
                + "discount = ?,\n" //5
                + "imageUrl = ?,\n" //6
                + "price = ?,\n" //7
                + "quantity = ?,\n" //8
                + "isDisplayed = ?\n" //9
                + "where bouquetId = ?;"; //10
        PreparedStatement pre = connection.prepareCall(sql);
        pre.setString(1, newBouquet.getBouquetId());
        pre.setString(2, newBouquet.getBouquetName());
        pre.setInt(3, newBouquet.getBouquetType());
        pre.setString(4, newBouquet.getBouquetDesc());
        pre.setFloat(5, newBouquet.getBouquetDiscount());
        pre.setString(6, newBouquet.getBouquetImageUrl());
        pre.setFloat(7, newBouquet.getBouquetPrice());
        pre.setInt(8, newBouquet.getBouquetQuantity());
        pre.setBoolean(9, newBouquet.isDisplayed());
        
        pre.setString(10, newBouquet.getBouquetId());
        
        pre.execute();
    }
    //Search bouquet by name
    public ArrayList<Bouquet> searchBouquetByName(String name) throws SQLException{
        ArrayList<Bouquet> output = new ArrayList<>();
        ArrayList<Bouquet> list = getBouquetList();
        Map<Character, Character> data = UnicodeConverter.ConversionMap();
        String bouquetName = "";
        name = UnicodeConverter.UnicodeToAscii(name);
        //Access every value of database
        for(int i=0;i<list.size();i++){
            bouquetName = UnicodeConverter.UnicodeToAscii(list.get(i).getBouquetName());
            //check if bouquetName contains input value or not
            if(bouquetName.contains(name)){
                output.add(list.get(i));
            }
        }
        return output;
    }
    
    //Get display checked Bouquet
    public ArrayList<Bouquet> getBouquetDisplayedListById(int typeId) throws SQLException{
        ArrayList<Bouquet> list = new ArrayList<>();
        String sql = "Select *\n" +
            "from Bouquet\n" +
            "where bouquetTypeId = ?\n" +
            "and isDisplayed = 1";
        PreparedStatement pre = connection.prepareStatement(sql);
        pre.setInt(1, typeId);
        ResultSet rs = pre.executeQuery();
        //Access every elements of the Bouquet
        while(rs.next()){
            list.add(new Bouquet(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4),
                    rs.getFloat(5), rs.getFloat(6), rs.getString(7), rs.getInt(8), rs.getBoolean(9)));
        }
        return list;
    }
    
    public ArrayList<Bouquet> getBouquetDisplayedList() throws SQLException{
        ArrayList<Bouquet> list = new ArrayList<>();
        String sql = "Select *\n" +
            "from Bouquet\n" +
            "where isDisplayed = 1";
        PreparedStatement pre = connection.prepareStatement(sql);
        ResultSet rs = pre.executeQuery();
        //Access every elements of the Bouquet
        while(rs.next()){
            list.add(new Bouquet(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4),
                    rs.getFloat(5), rs.getFloat(6), rs.getString(7), rs.getInt(8), rs.getBoolean(9)));
        }
        return list;
    }
    
    //check Exist bouquet
    public boolean checkExistBouquetId(String bouquetId) throws SQLException{
        String sql = "Select * from Bouquet "
                + "where bouquetId = ?";
        PreparedStatement pre = connection.prepareStatement(sql);
        pre.setString(1, bouquetId);
        ResultSet rs = pre.executeQuery();
        while(rs.next()){
            return true;
        }
        return false;
    }
    
    public static ArrayList<Bouquet> getBouquetListByPage(ArrayList<Bouquet> list, HttpServletRequest request, HttpServletResponse response) {
        //check if the size is exceed 8 or 
        if (list.size() <= 8) {
            return list;
        } else {
            try {
                int page = Integer.parseInt(request.getParameter("page"));
                int max = (int) Math.ceil((double) list.size() / 8);
                request.setAttribute("totalPage", max);
                //check if page is valid or not
                if (page > max || page < 1) {
                    page = 1;
                    ArrayList<Bouquet> output = new ArrayList<>();
                    for (int i = 0; i < 8; i++) {
                        output.add(list.get(i));
                    }
                    return output;
                } else {
                    ArrayList<Bouquet> output = new ArrayList<>();
                    for (int i = (page - 1) * 8; i < page * 8 - 1; i++) {
                        output.add(list.get(i));
                    }
                    return output;
                }
            } catch (Exception ex) {
                System.out.println("PageController-err");
                return null;
            }
        }
    }
    
    public int getTotalPageNumber(ArrayList<Bouquet> list){
        return (int) Math.ceil((double) list.size() / 8);
    }
}
