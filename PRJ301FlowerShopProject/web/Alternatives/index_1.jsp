<%-- 
    Document   : index
    Created on : Jul 20, 2023, 8:55:14 AM
    Author     : Lenovo
--%>

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
    <body>
        <div class="row">
            <form action="test">
                <input type="hidden" name="imgNumValue" value="${imgNum}">
                <input class="col-md-2" type="submit" value="Previous">
                <div class="col-md-6">
                    <img src="${bouquetList.get(imgNum).getBouquetImageUrl()}">
                    <p>${imgNum}</p>
                </div>
                <input class="col-md-2" type="submit" value="Next">
            </form>
        </div>
    </body>
</html>
