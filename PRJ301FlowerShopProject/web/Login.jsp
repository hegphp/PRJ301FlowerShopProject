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
        <div class="container" style="margin: 35px">
            <br>
        </div>
        <div class="container">
            <div class="row">
                <!--content-->
                <div class="col-md-3"></div>
                <form class="form-group col-md-6" action="login" method="post">
                    <h1 class="h1 text-center text-dark">Đăng nhập</h1>
                    <input type="hidden" name="login">
                    <div class="input-group mb-2">
                        <div class="input-group-prepend">
                            <span class="input-group-text">Tài khoản</span>
                        </div>
                        <input class="form-control" type="text" name="account" id="accountInput">
                    </div>
                    <div class="input-group mb-2">
                        <div class="input-group-prepend">
                            <span class="input-group-text">Mật khẩu</span>
                        </div>
                        <input class="form-control" type="password" name="password" id="passwordInput">
                    </div>
                    <div class="input-group d-flex justify-content-between">
                        <div class="input-group-append">
                            <a class="" href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8080/PRJ301FlowerShopProject/login-google&response_type=code
                               &client_id=603686036073-m59br5hv3eimivgvuhllug3tden05v8i.apps.googleusercontent.com&approval_prompt=force">Login With Google</a>  
                        </div>
                        <input class="btn btn-primary" type="submit" value="Đăng nhập">
                    </div>
                </form>
                <br>
                <p>${errorMessage}</p>
                <div class="col-md-3"></div>
            </div>
        </div>

        <div style="margin-top: 10px">
            <br>
        </div>

        <footer class="py-5 bg-dark mt-3 w-100 fixed-bottom">
            <h5 class="text-center text-light">Copyright by Hong Viet Bui</h5>
        </footer>
    </body>
</html>
