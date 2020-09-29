<%@ page import="java.util.List" %>
<%@ page import="com.cyp.domain.Product" %><%--
  Created by IntelliJ IDEA.
  User: 17691
  Date: 2020/9/20
  Time: 15:16
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
</head>
<%
    List<Product> products= (List<Product>)request.getAttribute("products");
%>
<script>
    function del(id) {
        if (confirm("是否删除id为"+id+"的商品？")) {
            location.href="RemoveProduct?id="+id;
        }
    }
</script>
<body>
<div class="container-fluid">
    <div class="row">
        <table class="table table-striped">
            <tr>
                <th>编号</th>
                <th>名字</th>
                <th>价格</th>
                <th>图片</th>
            </tr>
            <%
                for (Product product:products) {
            %>

            <tr>
                <td><%=product.getPro_id()%></td>
                <td><%=product.getPro_name()%></td>
                <td><%=product.getPro_price()%></td>
                <td><img src="assert/img/<%=product.getPro_img1()%>" style="width: 40px"></td>
                <td>
                    <a href="FindProduct?id=<%=product.getPro_id()%>">详情</a>
                    <a href="javascript:void(0)" onclick="del('<%=product.getPro_id()%>')">删除</a>
                </td>
            </tr>
            <%
                }
            %>
        </table>
    </div>
</div>
</body>
</html>
