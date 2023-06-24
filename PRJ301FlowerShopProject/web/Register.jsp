<%-- 
    Document   : index
    Created on : Jun 14, 2023, 9:05:59 PM
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Web bán hoa online</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="Resource/css/index.css">
        <link rel="stylesheet" href="Resource/css/register.css">
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
                <a href="./homepage">
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
                <li><a href="./">Danh mục sản phẩm</a>
                    <ul id="category-list">
                        <li id="category"><a>Hoa cao cấp</a></li>
                        <li id="category"><a>Hoa kỉ niệm</a></li>
                        <li id="category"><a>Hoa khai trương</a></li>
                        <li id="category"><a>Hoa tang lễ</a></li>
                        <li id="category"><a>Hoa sinh nhật</a></li>
                        <li id="category"><a>Hoa tình yêu</a></li>
                        <li id="category"><a>Hoa cưới</a></li>
                        <li id="category"><a>Lẵng hoa</a></li>
                        <li id="category"><a>Hoa sự kiện</a></li>
                        <li id="category"><a>Hoa bó</a></li>
                    </ul>
                </li>
                <li><a href="./homepage">Trang chủ</a></li>
                <li><a href="">Giới thiệu</a></li>
                <li><a href="">Liên hệ</a></li>
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
                        <label for="phoneInput">Số điện thoại</label>
                        <input type="text" id="phoneInput" name="phoneInput" oninput="validatePhoneInput()">
                    </div>
                    <div class="form-row">
                        <label for="firstNameInput">First name:</label>
                        <input type="text" name="firstNameInput">
                    </div>
                    <div class="form-row">
                        <label for="lastNameInput">Last name:</label>
                        <input type="text" name="lastNameInput">
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