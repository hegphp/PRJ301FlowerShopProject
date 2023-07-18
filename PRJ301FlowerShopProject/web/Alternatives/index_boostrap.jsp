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
    </head>
    <body class=".bg-light.bg-gradient">
        <div class="container">
            <div class="d-flex flex-warp align-items-center justify-content-center justify-content-md-between py-3 border-bottom">
                <a href="../Homepage" class="d-flex align-items-center col-md-3 mb-2 mb-md-0 text-dark text-decoration-none">
                    <img src="../Resource/hoadepcom-logos.jpeg" class="bi me-2" width="45" height="45">
                </a>
                <form class="input-group col-md-auto col-12 justify-content-center mb-2 mb-md-0 col-md-6 flex-fill">
                    <input type="text" class="form-control" placeholder="Tìm kiếm hoa tại đây">
                    <button type="submit" class="input-group-append btn btn-outline-secondary">
                        Tìm kiếm
                    </button>
                </form>
                <div class="px-3 col-md-3 text-end d-flex justify-content-around">
                    <a>Ðăng nhập</a>
                    <a>Đăng kí</a>
                    <a>Giỏ hàng</a>
                </div>
            </div>
            <nav class="navbar navbar-expand-md sticky-top">
                <ul class="navbar-nav row text-decoration-none w-100">
                    <li class="nav-item col-md-3 text-center">
                        <a class="nav-link" href="./Homepage">Danh mục sản phẩm</a>
                        <ul>
                            <c:forEach items="${bouquetTypeList}" var="item">
                            <li><a href="BouquetTypeController?id=${item.getBouquetTypeId()}">${item.getBouquetTypeName()}</a></li>
                            </c:forEach>
                        </ul>
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
            <h3 class="text-center">Hoa sinh nhật</h3>
            <div class="row">
                <div class="col-md-3">
                    <div class="card">
                        <img class="card-img-top" src="../Resource/hoadepcom-logos.jpeg" alt="Card image cap">
                        <div class="card-body">
                            <h5 class="card-title">Card title</h5>
                            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                            <a href="#" class="btn btn-primary">Go somewhere</a>
                        </div>
                    </div>
                </div>

                <div class="col-md-3">
                    <div class="card">
                        <img class="card-img-top" src="../Resource/hoadepcom-logos.jpeg" alt="Card image cap">
                        <div class="card-body">
                            <h5 class="card-title">Card title</h5>
                            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                            <a href="#" class="btn btn-primary">Go somewhere</a>
                        </div>
                    </div>
                </div>

                <div class="col-md-3">
                    <div class="card">
                        <img class="card-img-top" src="../Resource/hoadepcom-logos.jpeg" alt="Card image cap">
                        <div class="card-body">
                            <h5 class="card-title">Card title</h5>
                            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                            <a href="#" class="btn btn-primary">Go somewhere</a>
                        </div>
                    </div>
                </div>

                <div class="col-md-3">
                    <div class="card">
                        <img class="card-img-top" src="../Resource/hoadepcom-logos.jpeg" alt="Card image cap">
                        <div class="card-body">
                            <h5 class="card-title">Card title</h5>
                            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                            <a href="#" class="btn btn-primary">Go somewhere</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-md-3">
                    <div class="card">
                        <img class="card-img-top" src="../Resource/hoadepcom-logos.jpeg" alt="Card image cap">
                        <div class="card-body">
                            <h5 class="card-title">Card title</h5>
                            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                            <a href="#" class="btn btn-primary">Go somewhere</a>
                        </div>
                    </div>
                </div>

                <div class="col-md-3">
                    <div class="card">
                        <img class="card-img-top" src="../Resource/hoadepcom-logos.jpeg" alt="Card image cap">
                        <div class="card-body">
                            <h5 class="card-title">Card title</h5>
                            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                            <a href="#" class="btn btn-primary">Go somewhere</a>
                        </div>
                    </div>
                </div>

                <div class="col-md-3">
                    <div class="card">
                        <img class="card-img-top" src="../Resource/hoadepcom-logos.jpeg" alt="Card image cap">
                        <div class="card-body">
                            <h5 class="card-title">Card title</h5>
                            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                            <a href="#" class="btn btn-primary">Go somewhere</a>
                        </div>
                    </div>
                </div>

                <div class="col-md-3">
                    <div class="card">
                        <img class="card-img-top" src="../Resource/hoadepcom-logos.jpeg" alt="Card image cap">
                        <div class="card-body">
                            <h5 class="card-title">Card title</h5>
                            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                            <a href="#" class="btn btn-primary">Go somewhere</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <footer class="py-5 bg-dark mt-3">
            <h5 class="text-center text-light">Copyright by Hong Viet Bui</h5>
        </footer>
    </body>
</html>
