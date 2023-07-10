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

            body{
                position: relative;
                height: 100vh;
            }

            #footer {
                position: absolute;
                bottom: 0;
                width: 100%;
            }

            .bouquet-info {
                display: flex;
            }

            .bouquet-info-left {
                width: 37.5%;
                margin-left: 25vw;
                display: flex;
                justify-content: center;
            }

            .bouquet-info-right {
                width: 62.5%;
                display: flex;
                flex-direction: column;
                align-content:  flex-start;
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
                <li><a href="./Homepage">Danh mục sản phẩm</a>
                    <ul id="category-list">
                        <c:forEach items="${bouquetTypeList}" var="item">
                            <li id="category"><a href="BouquetTypeController?id=${item.getBouquetTypeId()}">${item.getBouquetTypeName()}</a></li>
                            </c:forEach>
                    </ul>
                </li>
                <li><a href="Homepage">Trang chủ</a></li>
                <li><a href="Homepage">Giới thiệu</a></li>
                <li><a href="Homepage">Liên hệ</a></li>
            </ul>


            <!--content-->
            <h1 style='text-align: center'>Thông tin sản phẩm</h1>
            <div class="bouquet-info">
                <div class='bouquet-info-left'>
                    <img src='${bouquetInfo.getBouquetImageUrl()}'>
                </div>
                <div class='bouquet-info-right'>
                    <form>
                        <h2>${bouquetInfo.getBouquetName()}</h2>
                        <p>Giá: ${bouquetInfo.getBouquetPrice()}$</p>
                        <p>Số lượng: <input type='number' id='quantity' max='${bouquetInfo.getBouquetQuantity()}'> (Số lượng tối đa: ${bouquetInfo.getBouquetQuantity()})</p>
                        <p id="errorMessage" style="display: none; color: red;">Giá trị không hợp lệ!</p>
                        <p>Thông tin sản phẩm:<br>${bouquetInfo.getBouquetDesc()}</p>
                        <input type='submit' value='Thêm vào giỏ hàng'>
                        <input type='submit' value='Đặt hàng'>
                    </form>
                </div>
            </div>

            <!--footer-->
            <div id="footer">
                <h4>Copyright by Hồng Việt Bùi</h4>
            </div>    
            <!--khi admin hoặc người dùng truy cập thành công-->
        </div>
        <script>
            let input = document.getElementById("quantity");
            let errorMessage = document.getElementById("errorMessage");

            input.addEventListener("input", function () {
                if (input.value > parseInt(input.max)) {
                    errorMessage.style.display = "block";
                } else {
                    errorMessage.style.display = "none";
                }
            });
        </script>
    </body>
</html>