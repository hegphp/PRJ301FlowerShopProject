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
        <style>
            body {
                margin: 0;
                background: rgb(234,216,224);
                background: radial-gradient(circle, rgba(234,216,224,1) 30%, rgba(58,148,254,1) 100%);
            }
            
            a:visited {
                color: blue;
            }
            
            /*header*/
            
            .header {
                display: flex;
                margin: 0 10vh;
                height: 10vh;
            }
            
            .header-left {
                width: 20%;
            }
            
            .header-left img {
                height: 100%;
            }
            
            /*header center*/
            
            .header-center {
                width: 60%;
                display: flex;
                align-items: center;
            }
            
            .header-center form {
                width: 100%;
                display: flex;
                justify-content: center;
                height: 30%;
            }
            
            .searchbar {
                width: 80%;
            }
            
            /*header right*/
            .header-right {
                width: 20%;
                display: flex;
                justify-content: space-between;
                align-items: center;
            }
            
            /*body*/
            
            #body-webpage {
            }
            
            .navbar {
                /*remove the excess*/
                list-style-type: none;
                margin: 0;
                padding: 0;
                color: white;
                width: 100%;
                height: 34.4px;
                background-color: #e9d8f4;
                display: flex;
                position: sticky;
                top: 0;
                z-index: 1;
            }
            
            .navbar li {
                width: 25%;
                text-align: center;
            }
            
            .navbar li#category {
                width: 100%;
            }
            
            .navbar li a {
                padding: 8px;
                display: block;
                text-decoration: none;
            }
            
            .navbar li a:hover {  
                background-color: #58257b;  
                color: white;
            }
            
            /*category list*/
            
            .navbar ul{
                list-style-type: none;
                margin: 0;
                padding: 0;
                width: 200px;
                display: none;
                background-color: #e9d8f4;
            }
            
            #category-list {
                width: 25vw;
            }
            
            #category{
                width: 100%;
            }
            
            #category a {
                width: 100%;
            }
            
            .navbar ul li a{
                display: block;
                width: 60px;
            }
            
            .navbar li:hover ul{
                display: block;
            }
            /*Body*/
            #body-webpage {
                height:80vh;
            }
            /*content*/
            .content {
                margin: 1vh 10vh 0 10vh;
                display: flex;
                flex-wrap: wrap;
                overflow: hidden;
                position: relative;
                z-index: 0;
            }
            
            .content-object {
                width: 25%;
/*                margin-left: 1vw;
                margin-right: 1vw;*/
                padding: 0 1vw;
                box-sizing: border-box;
                display: block;
            }
            
            .content-object img {
                margin-top: 2em;
                height: 80%;
                width: 100%;
            }
            /*object description*/
            .object-desc {
                height: 20%;
                text-align: center;
            }
            
            /*footer*/
            #footer {
                height: 10vh;
                background-color: mediumorchid;
                color: white;
                display: flex;
                justify-content: center;
            }
            
            #footer h4{
                text-align: center;
                display: flex;
                align-items: center;
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
                <a href="./">
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
                <a href="./login">Xin chào: <%=account%></a> 
                <!--register-->
                <a href="./">Thoát</a>
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
                        <li id="category"><a>Hoa tang lễ</a></li>
                    </ul>
                </li>
                <li><a href="">Trang chủ</a></li>
                <li><a href="">Giới thiệu</a></li>
                <li><a href="">Liên hệ</a></li>
            </ul>
            <!--content-->
            <div class="content">
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
        </div>
        <!--footer-->
        <div id="footer">
            <h4>Copyright by Hồng Việt Bùi</h4>
        </div>
    </body>
</html>

<!--note

- Nên tìm hiểu về session để thuận tiện cho việc lưu một phiên, tạo điều kiện cho người dùng đỡ phải đăng nhập đi đăng nhập lại nhiều lần

-->