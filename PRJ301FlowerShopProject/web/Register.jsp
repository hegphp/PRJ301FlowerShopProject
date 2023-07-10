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
        <link rel="stylesheet" href="Resource/css/register.css">
        <style>
            form {
                width: 55%;
            }

            .form-row-right {
                position: absolute;
                right: 0;
                width: 60%;
                display: flex;
            }

            .form-row {
                display: flex;
                align-content: center;
                position: relative;
            }
            
            .form-row p {
                position: absolute;
                left: 40%;
                margin: 0;
            }
            
/*            .form-row input[type="radio"] {
                position: absolute;
                left: 10%;
                margin: 0;
            }*/
            
            .no-margin {
                margin: 0;
            }
        </style>
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
                <a href="">Giỏ hàng</a>
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
                <li><a href="./Homepage">Giới thiệu</a></li>
                <li><a href="./Homepage">Liên hệ</a></li>
            </ul>
            <!--content-->
            <div class="content">
                <h1>Đăng kí</h1>
                <form action="user" method="post">
                    <input type ="hidden" name="register">
                    <div class="form-row">
                        <label for="accountInput">Tài khoản</label>
                        <input type="text" name="accountInput" id="accountInput">
                    </div>
                    <div class="form-row">
                        <label for="passwordInput">Mật khẩu</label>
                        <input type="password" name="passwordInput" id="passwordInput">
                    </div>
                    <div class="form-row">
                        <label for="repassword">Nhập lại mật khẩu</label><br>
                        <input type="password" id="repassword" name="repassword" style="width:60%">
                    </div>
                    <div class="form-row">
                        <label for="firstNameInput">First name:</label>
                        <input type="text" name="firstNameInput">
                    </div>
                    <div class="form-row">
                        <label for="lastNameInput">Last name:</label>
                        <input type="text" name="lastNameInput">
                    </div>
                    <div class="form-row" style="margin: 0">
                        <label for="genderInput">Giới tính:</label>
                        <input type='radio' id='genderInput' name='genderInput' value='1'>
                        <p>Nam</p>
                    </div>
                    <div class="form-row" style="margin: 0">
                        <input type='radio' id='genderInput' name='genderInput' value='0'>
                        <p>Nữ</p><br>
                    </div>
                    <div class="form-row">
                        <label for="phoneInput">Số điện thoại</label>
                        <input type="text" id="phoneInput" name="phoneInput" oninput="validatePhoneInput()">
                    </div>
                    <div class="form-row">
                        <label for="addressInput">Địa chỉ:</label>
                        <input type="text" name="addressInput">
                    </div>
                    <div class="form-row">
                        <label for="emailInput">Email:</label>
                        <input type="email" name="emailInput">
                    </div>
                    <div class="form-row">
                        <input type="submit" value="Đăng kí">
                    </div>
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