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
            /* The hero image */
            .banner {
                /* Use "linear-gradient" to add a darken background effect to the image (photographer.jpg). This will make the text easier to read */
                background-image: linear-gradient(rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5)), url("Resource/hoadepcom-logos.jpeg");

                /* Set a specific height */
                height: 50vh;

                /* Position and center the image to scale nicely on all screens */
                background-position: center;
                background-repeat: no-repeat;
                background-size: cover;
                position: relative;
            }

            /* Place text in the middle of the image */
            .banner-text {
                text-align: center;
                position: absolute;
                top: 50%;
                left: 50%;
                transform: translate(-50%, -50%);
                color: white;
            }

            .content-container {
                min-height: 100vh;
                position: relative;
            }

            .content-object p {
                margin-top: 0;
            }

            .bouquet-category {
                background-color: aliceblue;
                margin: 0;
                padding: 1vh 0;
                text-align: center;
                margin-top: 1vh;
            }

            #body-webpage {
                min-height: 100%;
                position: relative;
            }

            #footer {
                position: absolute;
                bottom: 0;
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
                <a href="#">
                    <!--logo-->
                    <img src="Resource/hoadepcom-logos.jpeg" alt="logo">
                </a>
            </div>
            <!--center-->
            <div class="header-center">
                <!--searchbar-->
                <form action="search" method="get">
                    <input type="text" name="bouquetName" class="searchbar" placeholder="Tìm kiếm hoa tại đây">
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
                <li><a href="./Homepage">Danh mục sản phẩm</a>
                    <ul id="category-list">
                        <c:forEach items="${bouquetTypeList}" var="item">
                            <li id="category"><a href="BouquetTypeController?id=${item.getBouquetTypeId()}">${item.getBouquetTypeName()}</a></li>
                        </c:forEach>
                    </ul>
                </li>
                <li><a href="#">Trang chủ</a></li>
                <li><a href="#">Giới thiệu</a></li>
                <li><a href="#">Liên hệ</a></li>
            </ul>


            <div class="content-container">
                <div class="banner">
                    <div class="banner-text">
                        <h1>Chào mừng bạn đã đến với hoadep.com</h1>
                    </div>
                </div>

                <!--content-->
                <c:forEach items="${bouquetTypeList}" var="item">
                    <h1 class="bouquet-category"><a href="BouquetTypeController?id=${item.getBouquetTypeId()}">${item.getBouquetTypeName()}</a></h1>
                    <!--content-->
                    <div class="content">
                        <c:forEach items="${daoBouquet.getBouquetDisplayedList(item.getBouquetTypeId())}" var="i">
                            <!--object list-->
                            <div class="content-object">
                                <a href="BouquetController?info=1&id=${i.getBouquetId()}">
                                    <img src="${i.getBouquetImageUrl()}" alt="Ảnh">
                                </a>
                                <div class="object-desc">
                                    <p><a href="">
                                            ${i.getBouquetName()}</a><br>
                                            <c:choose>
                                                <c:when test="${i.getBouquetDiscount()==0}">
                                                    Giá: ${i.getBouquetPrice()}$<br>
                                                </c:when>
                                                <c:otherwise>
                                                    Giá: <span style="text-decoration: line-through">$${i.getBouquetPrice()}</span>$${Math.round(i.getBouquetPrice()*(1-i.getBouquetDiscount())*100)/100}<br>
                                                </c:otherwise>
                                            </c:choose>
                                        Số lượng: ${i.getBouquetQuantity()}</p>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </c:forEach>
                <c:forEach begin="0" end="3">
                    <br>
                </c:forEach>    
                <!--footer-->
                <div id="footer">
                    <h4>Copyright by Hồng Việt Bùi</h4>
                </div>
            </div>
        </div>
    </body>
</html>