<%-- 
    Document   : index
    Created on : Jul 12, 2023, 9:10:51 PM
    Author     : Lenovo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" ></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
    </head>
    <body class=".bg-light.bg-gradient min-vh-100">
        <div class="container">
            <div class="d-flex flex-warp align-items-center justify-content-center justify-content-md-between py-3 border-bottom">
                <a href="Homepage" class="d-flex align-items-center col-md-3 mb-2 mb-md-0 text-dark text-decoration-none">
                    <img src="Resource/hoadepcom-logos.jpeg" class="bi me-2" width="45" height="45">
                </a>
                <form action="search" method="get" class="input-group col-md-auto col-12 justify-content-center mb-2 mb-md-0 col-md-6 flex-fill">
                    <input type="text" name='bouquetName' value="${bouquetName}" class="form-control" placeholder="Tìm kiếm hoa tại đây">
                    <button type="submit" class="input-group-append btn btn-outline-secondary">
                        Tìm kiếm
                    </button>
                </form>
                <div class="px-3 col-md-3 text-end d-flex justify-content-around">
                    <c:if test="${user==null}">
                        <!--login-->
                        <a class="text-decoration-none text-dark" href="login">Đăng nhập</a>
                        <!--register-->
                        <a class="text-decoration-none text-dark" href="user?register=1">Đăng kí</a>
                        <!--Shopping list-->
                        <a class="text-decoration-none text-dark" href="login">Giỏ hàng</a>
                    </c:if>
                    <c:if test="${user != null}">
                        <c:if test="${user['class'].name eq 'Model.Customer'}">
                            <!--login-->
                            <a class="text-decoration-none text-dark" href="user?info=1">Xin chào ${user.getCustomerId()}</a>
                            <!--register-->
                            <a class="text-decoration-none text-dark" href="user?logout=1">Thoát</a>
                            <!--Shopping list-->
                            <a class="text-decoration-none text-dark" href="CartController?userId=${user.getCustomerId()}">Giỏ hàng</a>
                        </c:if>
                        <c:if test="${user['class'].name eq 'Model.Employee'}">
                            <!--login-->
                            <a class="text-decoration-none text-dark" href="user?info=1">Xin chào ${user.getEmpId()}</a>
                            <!--register-->
                            <a class="text-decoration-none text-dark" href="user?logout=1">Thoát</a>
                            <!--Shopping list-->
                            <a class="text-decoration-none text-dark" href="CartController?userId=${user.getEmpId()}">Giỏ hàng</a>
                        </c:if>
                    </c:if>
                </div>
            </div>

            <nav class="navbar navbar-expand-md sticky-top pt-0 row text-decoration-none w-100">
                <ul class="navbar-nav row text-decoration-none w-100">
                    <li class="nav-item col-md-3 text-center dropdown">
                        <a role="button" data-bs-toggle="dropdown" class="nav-link dropdown-toggle" id="navbarDropdown" href="#">Danh mục sản phẩm</a>
                        <div class="dropdown-menu w-100" aria-labelledby="navbarDropdown">
                            <c:forEach items="${bouquetTypeList}" var="item">
                                <a class="dropdown-item text-center" href="BouquetTypeController?id=${item.getBouquetTypeId()}">${item.getBouquetTypeName()}</a>
                            </c:forEach>
                        </div>
                    </li>

                    <li class="nav-item col-md-3 text-center">
                        <a class="nav-link" href="./Homepage">Trang chủ</a>
                    </li>
                    <li class="nav-item col-md-3 text-center">
                        <a class="nav-link" href="">Giới thiệu</a>
                    </li>
                    <li class="nav-item col-md-3 text-center">
                        <a class="nav-link" href="">Liên hệ</a>
                    </li>
                </ul>
            </nav>
        </div>

        <div class="container">
            <h1 class="h1 text-center">Thông tin sản phẩm</h1>
            <br>
            <div class="row">
                <div class="col-md-2"></div>
                <div class='col-md-4'>
                    <img class="h-100 w-100" src='${bouquetInfo.getBouquetImageUrl()}'>
                </div>
                <div class='col-md-5'>
                    <form>
                        <h2>${bouquetInfo.getBouquetName()}</h2>
                        <p>Giá: ${bouquetInfo.getBouquetPrice()}$</p>
                        <p>Số lượng: <input type='number' id='quantity' max='${bouquetInfo.getBouquetQuantity()}'> (Số lượng tối đa: ${bouquetInfo.getBouquetQuantity()})</p>
                        <p id="errorMessage" style="display: none; color: red;">Giá trị không hợp lệ!</p>
                        <p>Thông tin sản phẩm:<br>${bouquetInfo.getBouquetDesc()}</p>
                        <input class="btn btn-secondary" type='submit' value='Thêm vào giỏ hàng'>
                        <input class="btn btn-secondary" type='submit' value='Đặt hàng'>
                    </form>
                </div>
            </div>
        </div>
        <div class="m-3"><br><br><br></div>
        <footer class="py-5 bg-dark mt-3 w-100">
            <h5 class="text-center text-light">Copyright by Hong Viet Bui</h5>
        </footer>
    </body>
</html>
