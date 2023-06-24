<%-- 
    Document   : ProductDetails
    Created on : Jun 19, 2023, 10:55:22 AM
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<!--import DAO-->
<%@page import="DAL.DAOFlower"%>
<%@page import="DAL.DAOBouquet"%>
<!--import model-->
<%@page import="Model.Flower"%>
<%@page import="Model.Bouquet"%>
<%@page import="Model.BouquetType"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <!--display all Flower-->
        <h1>Flower table</h1>
        <table border="1">
            <tr>
                <th>flowerId</th>
                <th>flowerName</th>
                <th>desc</th>
                <th>price</th>
                <th>imageUrl</th>
                <th>quantity</th>
            </tr>
        <%
            DAOFlower daoFlower = new DAOFlower();
            try{
                ArrayList<Flower> flowerList = daoFlower.getFlowerList();
                //Display all flowerList elements
                for(int i=0;i<flowerList.size();i++){
                    out.print("<tr>"
                    + "<td>"+flowerList.get(i).getFlowerId()+"</td>"
                    + "<td>"+flowerList.get(i).getFlowerName()+"</td>"
                    + "<td>"+flowerList.get(i).getDesc()+"</td>"
                    + "<td>"+flowerList.get(i).getPrice()+"</td>"
                    + "<td>"+flowerList.get(i).getImageUrl()+"</td>"
                    + "<td>"+flowerList.get(i).getQuantity()+"</td>"
                    + "</tr>");
                }
            }catch(Exception ex){
                System.out.println("ProductDetails: daoFlower: "+ex.getMessage());
            }
        %>
        </table>
        <!--display all Bouquet-->
        <h1>Bouquet table</h1>
        <table border="1">
            <th>bouquetId</th>
            <th>bouquetName</th>
            <th>desc</th>
            <th>price</th>
            <th>discount</th>
            <th>imageUrl</th>
            <th>quantity</th>
            <th>bouquetTypeId</th>
        <%
            DAOBouquet daoBouquet = new DAOBouquet();
            ArrayList<Bouquet> bouquetList = daoBouquet.getBouquetList();
            //Display all bouquet data
            for(int i=0;i<bouquetList.size();i++){
                out.print("<tr>"
                + "<td>"+bouquetList.get(i).getBouquetId()+"</td>"
                + "<td>"+bouquetList.get(i).getBouquetName()+"</td>"
                + "<td>"+bouquetList.get(i).getDesc()+"</td>"
                + "<td>"+bouquetList.get(i).getPrice()+"</td>"
                + "<td>"+bouquetList.get(i).getDiscount()+"</td>"
                + "<td>"+bouquetList.get(i).getImageUrl()+"</td>"
                + "<td>"+bouquetList.get(i).getQuantity()+"</td>"
                + "<td>"+bouquetList.get(i).getBouquetTypeId()+"</td>"
                + "</tr>");
            }
        %>
        </table>
    </body>
</html>
