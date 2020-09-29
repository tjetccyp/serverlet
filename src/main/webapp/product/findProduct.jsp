<%@ page import="com.cyp.domain.Product" %><%--
  Created by IntelliJ IDEA.
  User: 17691
  Date: 2020/9/20
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assert/css/bootstrap.css" type="text/css">
    <!-- 可选的Bootstrap主题文件（一般不用引入） -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assert/css/bootstrap-theme.css" type="text/css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="<%=request.getContextPath()%>/assert/js/jquery-1.11.3.js" type="text/javascript"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="<%=request.getContextPath()%>/assert/js/bootstrap.js" type="text/javascript"></script>
    <%
        Product product=(Product)request.getAttribute("product");
    %>
</head>
<body>
<div class="container text-center">
    <form action="<%=request.getContextPath()%>/UpdateProduct" method="get">
        <div class="form-group" hidden="hidden">
            <label for="id">id</label>
            <input type="text" class="form-control" id="id" value="<%=product.getPro_id()%>" name="id">
        </div>
        <div class="form-group">
            <label for="name">name</label>
            <input type="text" class="form-control" id="name" value="<%=product.getPro_name()%>" name="name">
        </div>
        <div class="form-group">
            <label for="price">price</label>
            <input type="text" class="form-control" id="price" value="<%=product.getPro_price()%>" name="price">
        </div>
        <div class="form-group">
            <label for="img1">img1</label>
            <input type="text" class="form-control" id="img1" value="<%=product.getPro_img1()%>" name="img1">
        </div>
        <div class="form-group">
            <label for="img2">img2</label>
            <input type="text" class="form-control" id="img2" value="<%=product.getPro_img2()%>" name="img2">
        </div>
        <div class="form-group">
            <label for="title">title</label>
            <input type="text" class="form-control" id="title" value="<%=product.getPro_title()%>" name="title">
        </div>
        <div class="form-group">
            <label for="info">info</label>
            <input type="text" class="form-control" id="info" value="<%=product.getPro_info()%>" name="info">
        </div>
        <button type="submit" class="btn btn-danger">修改</button>
    </form>
</div>
</body>
</html>
