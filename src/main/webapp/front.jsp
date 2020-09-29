<%@ page import="com.cyp.domain.Product" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 17691
  Date: 2020/9/20
  Time: 11:09
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
    <style type="text/css">
        .do{
            cursor: pointer;
            transition: all 0.5s;
        }
        .do:hover{
            box-shadow: 0 0 15px 2px #ccc;
            transform:translateY(-3px);
        }
    </style>
    <script>
        function descrption(id) {
            location.href="/Descrption?id="+id;
        }
    </script>
    <%
        List<Product> products= (List<Product>)request.getAttribute("products");
    %>
</head>
<body>
<div class="container-fluid" style="height: 200px;background: #F5F5F5;"></div>
<div class="container" style="background: #F5F5F5;width:100%;height:100%;">

    <div class="row">
        <%
            for (Product product : products) {
        %>
        <div class="col-lg-3 text-center">
            <div style="background: white;width:90%;" class="do" onclick="descrption('<%=product.getPro_id()%>')">
                <img src="assert/img/<%=product.getPro_img1()%>">
                <h4><%=product.getPro_name()%></h4>
                <p style="color: dimgray;font-size: 10px;"><%=product.getPro_info().substring(0,20)%>...</p>
                <p style="color: #FF6700"><%=product.getPro_price()%></p>
            </div>
        </div>
        <%
            }
        %>
    </div>
</div>
</body>
<h3></h3>
<p style="color:dimgray;font-size: 10px;"></p>
</html>
