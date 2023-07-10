<%-- 
    Document   : index
    Created on : Jun 14, 2023, 9:05:59 PM
    Author     : Lenovo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Web bán hoa online</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="Resource/css/index.css">
        <link rel="stylesheet" href="Resource/css/login.css">
    </head>
    <body>
        <%
            String account = "";
            if(request.getAttribute("account")!=null){
                account = (String)request.getAttribute("account");
            }
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
                <form action="search" method="get">
                    <input type="text" name='bouquetName' class="searchbar" placeholder="Tìm kiếm hoa tại đây">
                    <button type="submit">Tìm kiếm</button>
                </form>
            </div>
            <!--right-->
            <div class="header-right">
                <!--login-->
                <a href="./login">Đăng nhập</a>
                <!--register-->
                <a href="./user?register=1">Đăng kí</a>
                <!--Shopping list-->
                <a href="./login">Giỏ hàng</a>
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
                <li><a href="./Homepage">Trang chủ</a></li>
                <li><a href="">Giới thiệu</a></li>
                <li><a href="">Liên hệ</a></li>
            </ul>
            <!--content-->
            <div class="content">
                <form action="login" method="post">
                <h1>Đăng nhập</h1>
                <input type="hidden" name="login">
                <div class="form-row">
                <label for="accountInput">Tài khoản</label>
                <input type="text" name="account" id="accountInput">
                </div>
                <div class="form-row">
                <label for="passwordInput">Mật khẩu</label>
                <input type="password" name="password" id="passwordInput"><br><br>
                </div>
                <div class="form-row">
                <input type="submit" value="Đăng nhập">
                </div>
                <div class="form-row">
                </div>
                <a href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8080/PRJ301FlowerShopProject/login-google&response_type=code
    &client_id=603686036073-m59br5hv3eimivgvuhllug3tden05v8i.apps.googleusercontent.com&approval_prompt=force">Login With Google</a>  
                </form>
                <br>
                <% String errorMessage = "";
                   if(request.getAttribute("errorMessage") != null)
                       errorMessage = (String)request.getAttribute("errorMessage");
                   out.print("<p>" + errorMessage + "</p>");
                %>
            </div>
            
        </div>
        <!--footer-->
        <div id="footer">
            <h4>Copyright by Hồng Việt Bùi</h4>
        </div>
    </body>
</html>

<!--note

- Nên tìm hiểu về session để thuận tiện cho việc lưu một phiên, tạo điều kiện cho người dùng đỡ phải đăng nhập đi đăng nhập lại nhiều lần
- JSP thiếu vài trường hợp kiểm tra tài khoản đăng kí có hợp lệ hay không
- Add data cho Flower, Bouquet...
- Tìm hiểu về cách thêm photo
- Thêm tính chất undo, redo
- File JSP không tuân thủ tính chất view trong mô hình MVC, nên làm lại
-->