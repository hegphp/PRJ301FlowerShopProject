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
                    <a href="admin?showBouquetList=1" class="nav-link link-dark ">
                        <svg class="bi me-2" width="16" height="16"><use xlink:href="#grid"/></svg>
                        Bouquet
                    </a>
                </li>
                <li>
                    <a href="BouquetController?add=1" class="nav-link active">
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
            <h1 class="text-center">Add new Bouquet</h1>
            <div class="row">
                <form class="form-group" action="BouquetController" method="post" id="form" enctype="multipart/form-data">
                    <input type="hidden" name="add" value="1">
                    <div class="input-group mb-3" id="id">
                        <div class="input-group-prepend">
                            <span class="input-group-text">BouquetId:</span>
                        </div>
                        <input aria-label="BouquetId:" class="form-control" value="${bouquetId}" type="text" name="bouquetId">
                    </div>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text" >Name:</span>
                        </div>
                        <input class="form-control" type="text" name="bouquetName" id="bouquetName" value="${bouquetName}">
                    </div>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text">Type:</span>
                        </div>
                        <select class="form-select" id="inputGroupSelect01" name="bouquetTypeId">
                            <option value="0" selected>Chọn loại hoa</option>
                            <c:forEach items="${bouquetTypeList}" var="item">
                                <c:choose>
                                    <c:when test="${item.getBouquetTypeId()==bouquetTypeId}">
                                        <option value="${item.getBouquetTypeId()}" selected>${item.getBouquetTypeName()}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${item.getBouquetTypeId()}">${item.getBouquetTypeName()}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="input-group mb-3">
                        <span class="input-group-prepend input-group-text">Description:</span>
                        <textarea class="form-control" name="bouquetDescription">${bouquetDescription}</textarea>
                    </div>
                    <div class="input-group mb-3">
                        <span class="input-group-prepend input-group-text">Price:</span>
                        <input class="form-control" type="number" step="0.01" name="bouquetPrice" value="${bouquetPrice}">
                    </div>
                    <div class="input-group mb-3">
                        <span class="input-group-prepend input-group-text">Discount:</span>
                        <input class="form-control" type="number" name="bouquetDiscount" step="0.01" value="${bouquetDiscount}">
                    </div>
                    <div class="input-group mb-3">
                        <span class="input-group-prepend input-group-text">BouquetImageUrl:</span>
                        <input class="form-control" type="text" name="bouquetImageUrl" placeholder="Nhập đường dẫn tới ảnh hoặc upload img" value="${bouquetImageUrl}">
                        <input class="form-control" type="file" name="fileInput" accept="image/*">
                    </div>
                    <div class="input-group mb-3">
                        <span class="input-group-prepend input-group-text">Quantity:</span>
                        <input class="form-control" type="number" name="bouquetQuantity" value="${bouquetQuantity}">
                    </div>
                    <div class="form-check">
                        <span class="form-check-label">isDisplayed</span>
                        <c:choose>
                            <c:when test="${isDisplayed eq 'true'}">
                                <input type='checkbox' class="form-check-input" checked onchange="changeInputValue('isDisplayed')">
                                <input type="hidden" name="isDisplayed" value="true" name="isDisplayed" id="isDisplayed">
                            </c:when>
                            <c:otherwise>
                                <input type='checkbox' class="form-check-input" onchange="changeInputValue('isDisplayed')">
                                <input type="hidden" name="isDisplayed" value="false" name="isDisplayed" id="isDisplayed">
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <div class="d-flex flex-row justify-content-center">
                        <button type="submit" class="btn btn-primary">Add Bouquet</button>
                    </div>
                </form>
                <p class="border-0 alert alert-light text-danger" role="alert">${errorMessage}</p>
            </div>
        </div>
            <script>
                function changeInputValue(input){
                    let inputValue = document.getElementById(input).value;
                    if(inputValue === 'false'){
                        document.getElementById(input).value = 'true';
                    }else
                        document.getElementById(input).value = 'false';
                }
            </script>
    </body>
</html>