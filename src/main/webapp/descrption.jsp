<%@ page import="com.cyp.domain.Product" %><%--
  Created by IntelliJ IDEA.
  User: 17691
  Date: 2020/9/20
  Time: 12:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="assert/css/bootstrap.css" type="text/css">
    <!-- 可选的Bootstrap主题文件（一般不用引入） -->
    <link rel="stylesheet" href="assert/css/bootstrap-theme.css" type="text/css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="assert/js/jquery-1.11.3.js" type="text/javascript"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="assert/js/bootstrap.js" type="text/javascript"></script>
    <%
    Product product=(Product)request.getAttribute("product");
    %>
</head>
<body>
<div class="container-fluid" style="height: 200px;"></div>
<div class="container">
    <div class="row">
        <div class="col-lg-6">
            <img src="assert/img/<%=product.getPro_img2()%>" style="width: 100%">
        </div>
        <div class="col-lg-6">
            <h3><%=product.getPro_name()%></h3>
            <span style="color: #FF6700"><%=product.getPro_title()%></span><span style="color: dimgray"><%=product.getPro_info()%></span>
            <p style="color: #FF6700;font-size: 16px;margin-top: 20px"><%=product.getPro_price()%>元</p>
        </div>
    </div>
</div>
</body>
</html>
