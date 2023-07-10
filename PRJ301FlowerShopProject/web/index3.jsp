<%-- 
    Document   : index3
    Created on : Jun 23, 2023, 6:50:37 PM
    Author     : Lenovo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="Model.Employee"%>
<%@page import="Model.Bouquet"%>
<%@page import="java.util.ArrayList"%>
<html>
    <head>
        <title>index</title>
        <style>
            a:visited {
                color: blue;
            }

            #deleteLink {
                color: blue;
                text-decoration: underline;
            }

            img {
                max-width: 100%;
                max-height: 100%;
            }
        </style>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    </head>
    <body class="row">
        <div class="d-flex flex-column flex-shrink-0 p-3 bg-light col-md-3" style="width: 280px;">
            <a href="admin" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-dark text-decoration-none">
                <svg class="bi me-2" width="40" height="32"><use xlink:href="#bootstrap"/></svg>
                <span class="fs-4">hoadep.com</span>
            </a>
            <hr>
            <ul class="nav nav-pills flex-column mb-auto">
                <li class="nav-item">
                    <a href="Homepage" class="nav-link link-dark" aria-current="page">
                        <svg class="bi me-2" width="16" height="16"><use xlink:href="#home"/></svg>
                        Trang chủ
                    </a>
                </li>
                <li>
                    <a href="admin?showBouquetList=1" class="nav-link active">
                        <svg class="bi me-2" width="16" height="16"><use xlink:href="#grid"/></svg>
                        Bouquet
                    </a>
                </li>
                <li>
                    <a href="BouquetController?add=1" class="nav-link link-dark">
                        <svg class="bi me-2" width="16" height="16"><use xlink:href="#people-circle"/></svg>
                        Thêm Bouquet mới
                    </a>
                </li>
                <li>
                    <a href="admin?info=1" class="nav-link link-dark">
                        <svg class="bi me-2" width="16" height="16"><use xlink:href="#people-circle"/></svg>
                        Thông tin cá nhân
                    </a>
                </li>
                <li>
                    <a href="user?logout=1" class="nav-link link-dark">
                        <svg class="bi me-2" width="16" height="16"><use xlink:href="#people-circle"/></svg>
                        Thoát
                    </a>
                </li>
            </ul>
        </div>
        <div class="col-md-9">
            <!--show account info-->
            <h1 class="text-center">BouquetList</h1>
            <!--searchbar-->
            <form action="search" class="row" method="get">
                <div class="col-md-3"></div>
                <input class="col-md-5" type="text" name='bouquetName' class="searchbar" placeholder="Tìm kiếm hoa tại đây" value="${bouquetName}">
                <button class="col-md-1" type="submit">Tìm kiếm</button>
            </form>
            <!--display Bouquet List-->
            <form id="bouquetForm" action="BouquetController" method="post">
                <table class="table">
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Type</th>
                        <th>Description</th>
                        <th>price</th>
                        <th>discount</th>
                        <th>imageUrl</th>
                        <th>quantity</th>
                        <th>isDisplayed</th>
                    </tr>
                    <c:forEach items="${bouquetList}" var="item">
                        <tr>
                            <td>${item.getBouquetId()}</td>
                            <td>${item.getBouquetName()}</td>
                            <td>${bouquetTypeMap.get(item.getBouquetType())}</td>
                            <td>${item.getBouquetDesc()}</td>
                            <td>${item.getBouquetPrice()}</td>
                            <td>${item.getBouquetDiscount()}</td>
                            <td><img src="${item.getBouquetImageUrl()}" alt="alt"/></td>
                            <td>${item.getBouquetQuantity()}</td>
                            <td>${item.isDisplayed()}</td>
                            <td><a href="BouquetController?update=1&id=${item.getBouquetId()}">Update</a></td>
                            <td><a href="#" onclick="deleteBouquet('${item.getBouquetId()}'); return false;">Delete</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </form>
        </div>
        <script>
            //deleteBouquet
            function deleteBouquet(bouquetId) {
                let form = document.getElementById("bouquetForm");
                form.method = 'post';
                form.action = 'BouquetController';
                //create bouquetId input        
                let input = document.createElement('input');
                input.value = bouquetId;
                input.type = 'hidden';
                input.name = 'bouquetId';
                form.appendChild(input);
                //create delete input        
                input = document.createElement('input');
                input.value = '1';
                input.name = 'delete';
                input.type = 'hidden';
                form.appendChild(input);
                form.submit();
            }
        </script>
    </body>
</html>