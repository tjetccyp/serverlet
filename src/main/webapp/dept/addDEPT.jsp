<%--
  Created by IntelliJ IDEA.
  User: 17691
  Date: 2020/9/21
  Time: 10:03
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
<body>
<div class="container text-center">
    <form action="<%=request.getContextPath()%>/AddDEPT" method="get">
        <div class="form-group">
            <label for="name">name</label>
            <input type="text" class="form-control" id="name" placeholder="name" name="name">
        </div>
        <div class="form-group">
            <label for="price">loc</label>
            <input type="text" class="form-control" id="price" placeholder="loc" name="loc">
        </div>
        <button type="submit" class="btn btn-danger">添加</button>
    </form>
</div>
</body>
</html>
