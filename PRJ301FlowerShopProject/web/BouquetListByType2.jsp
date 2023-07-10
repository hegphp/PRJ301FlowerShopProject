<%-- 
    Document   : index
    Created on : Jun 14, 2023, 9:05:59 PM
    Author     : Lenovo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" import="Model.Employee, Model.Customer"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.Bouquet"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Web bán hoa online</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="Resource/css/index.css">
        <style>
            body {
                position: relative;
                min-height: 100vh;
            }
            
            #footer {
                position: absolute;
                bottom: 0;
                width: 100%;
            }
            
            .content {
                margin-top: 0;
            }
            
            .content-object img {
                margin: 0;
                
            }
            
            .content-object p {
                margin: 0;
            }
        </style>
    </head>
    <body>
        <%
            String account = "";
            if(session.getAttribute("user") instanceof Employee){
                Employee emp = (Employee) session.getAttribute("user");
                account = emp.getEmpId();
            }else{
                Customer cus = (Customer) session.getAttribute("user");
                account = cus.getCustomerId();
            }
            
//            ArrayList<Bouquet> 
        %>
        <!--head-->
        <div class="header">
            <!--left-->
            <div class="header-left">
                <a href="./Homepage">
                    <!--logo-->
                    <img src="Resource/hoadepcom-logos.jpeg" alt="logo">
                </a>
            </div>
            <!--center-->
            <div class="header-center">
                <!--searchbar-->
                <form>
                    <input type="text" class="searchbar" placeholder="Tìm kiếm hoa tại đây">
                    <button type="submit">Tìm kiếm</button>
                </form>
            </div>
            <!--right-->
            <div class="header-right">
                <!--login-->
                <a href="user?info=1">Xin chào <%=account%></a>
                <!--register-->
                <a href="user?logout=1">Thoát</a>
                <!--Shopping list-->
                <a href="CartController?userId=<%=account%>">Giỏ hàng</a>
            </div>
        </div>
        <!--content-->
        <div id="body-webpage">
            <!--navbar-->
            <ul class="navbar">
                <li><a href="./Homepages">Danh mục sản phẩm</a>
                    <ul id="category-list">
                        <c:forEach items="${bouquetTypeList}" var="item">
                            <li id="category"><a href="BouquetTypeController?id=${item.getBouquetTypeId()}">${item.getBouquetTypeName()}</a></li>
                        </c:forEach>
                    </ul>
                </li>
                <li><a href="./Homepage">Trang chủ</a></li>
                <li><a href="#">Giới thiệu</a></li>
                <li><a href="#">Liên hệ</a></li>
            </ul>
            <h1 class="bouquet-category" style="text-align: center">${bouquetType}</h1>
            <div class="content">
                <c:forEach items="${bouquetList}" var="i">
                    <!--object list-->
                    <div class="content-object">
                        <a href="BouquetController?info=1&id=${i.getBouquetId()}">
                            <img src="${i.getBouquetImageUrl()}" alt="Ảnh 1">
                        </a>
                        <div class="object-desc">
                            <p><a href="BouquetController?info=1&id=${i.getBouquetId()}">
                                    ${i.getBouquetName()}</a><br>
                                Giá: ${i.getBouquetPrice()}$<br>
                                Số lượng: ${i.getBouquetQuantity()}</p>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <!--footer-->
            <div id="footer">
                <h4>Copyright by Hồng Việt Bùi</h4>
            </div>    
        </div>
    </body>
</html>