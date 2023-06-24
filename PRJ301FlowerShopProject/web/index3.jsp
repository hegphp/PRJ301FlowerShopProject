<%-- 
    Document   : index3
    Created on : Jun 23, 2023, 6:50:37 PM
    Author     : Lenovo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="Model.Employee"%>
<%@page import="Model.Bouquet"%>
<%@page import="Model.Flower"%>
<%@page import="java.util.ArrayList"%>
<html>
    <head>
        <title>index</title>
    </head>
    <body>
        <h1>Account info:</h1>
        <%
        //Get Bouquet attribute
        ArrayList<Bouquet> bouquetList = (ArrayList)request.getAttribute("bouquetList");
        //Get Flower attribute
        ArrayList<Flower> flowerList = (ArrayList)request.getAttribute("flowerList");

        if(session.getAttribute("user")!=null){
            Employee emp = (Employee)session.getAttribute("user");
            out.print("Id: " + emp.getEmpId());
            out.print("<br/>Name: " + emp.getEmpFirstName()+" "+emp.getEmpLastName());
            out.print("<br/>Email: " + emp.getEmpEmail());
        }else{
            String id = request.getAttribute("id").toString();
            String name = (String)request.getAttribute("name");
            String email = (String)request.getAttribute("email");
            out.print("Id: " + id);
            out.print("<br/>Name: " + name);
            out.print("<br/>Email: " + email);
        }
        %>
        <h1>BouquetList</h1>
        <a href="BouquetController?add=1">Add new Bouquet</a><br><br>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Type</th>
                <th>Description</th>
                <th>price</th>
                <th>discount</th>
                <th>imageUrl</th>
                <th>quantity</th>
            </tr>
            <c:forEach items="${bouquetList}" var="item">
                <tr>
                    <td>${item.getBouquetId()}</td>
                    <td>${item.getBouquetName()}</td>
                    <td>${item.getBouquetType()}</td>
                    <td>${item.getBouquetDesc()}</td>
                    <td>${item.getBouquetPrice()}</td>
                    <td>${item.getBouquetDiscount()}</td>
                    <td>${item.getBouquetImageUrl()}</td>
                    <td>${item.getBouquetQuantity()}</td>
                    <td><a href="BouquetController?update=1&account=${item.getBouquetId()}">Update</a></td>
                    <td><a href="BouquetController?delete=1&account=${item.getBouquetId()}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
        <h1>FlowerList</h1>
        <a href="FlowerController?add=1">Add new Flower</a><br><br>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Description</th>
                <th>price</th>
                <th>imageUrl</th>
                <th>quantity</th>
            </tr>
            <c:forEach items="${flowerList}" var="item">
                <tr>
                    <td>${item.getFlowerId()}</td>
                    <td>${item.getFlowerName()}</td>
                    <td>${item.getFlowerDesc()}</td>
                    <td>${item.getFlowerPrice()}</td>
                    <td>${item.getFlowerImageUrl()}</td>
                    <td>${item.getFlowerQuantity()}</td>
                    <td><a href="FlowerController?update=1&account=${item.getFlowerId()}">Update</a></td>
                    <td><a href="FlowerController?delete=1&account=${item.getFlowerId()}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
