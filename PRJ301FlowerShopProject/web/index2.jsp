<%-- 
    Document   : index
    Created on : Jun 14, 2023, 9:05:59 PM
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="Model.Employee"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.Bouquet"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Web bán hoa online</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="Resource/css/index.css">
    </head>
    <body>
        <%
            String account = "";
            if(session.getAttribute("user") instanceof Employee){
                Employee emp = (Employee) session.getAttribute("user");
                account = emp.getEmpAccount();
            }
            
//            ArrayList<Bouquet> 
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
                <a href="user?account=<%=account%>">Xin chào <%=account%></a>
                <!--register-->
                <a href="user?logout=1">Thoát</a>
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
            <div class="content" id="content">
                <!--object list-->
                <div class="content-object">
                    <a href="">
                    <img src="Resource/object-image/Image1.png" alt="Ảnh 1">
                    </a>
                    <div class="object-desc">
                        <p><a href="">Đây chỉ là một dòng chữ bình thường</a></p>
                    </div>
                </div>
                <div class="content-object">
                    <a href="">
                    <img src="Resource/object-image/Image1.png" alt="Ảnh 1">
                    </a>
                    <div class="object-desc">
                        <p><a href="">Đây chỉ là một dòng chữ bình thường</a></p>
                    </div>
                </div>
                <div class="content-object">
                    <a href="">
                    <img src="Resource/object-image/Image1.png" alt="Ảnh 1">
                    </a>
                    <div class="object-desc">
                        <p><a href="">Đây chỉ là một dòng chữ bình thường</a></p>
                    </div>
                </div>
                <div class="content-object">
                    <a href="">
                    <img src="Resource/object-image/Image1.png" alt="Ảnh 1">
                    </a>
                    <div class="object-desc">
                        <p><a href="">Đây chỉ là một dòng chữ bình thường</a></p>
                    </div>
                </div>
            </div>
            <!--khi admin hoặc người dùng truy cập thành công-->
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