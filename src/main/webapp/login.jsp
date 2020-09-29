<%--
  Created by IntelliJ IDEA.
  User: 17691
  Date: 2020/9/20
  Time: 9:46
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
</head>
<body>
<div class="container text-center">
    <h1>用户登录</h1>
</div>
<div class="container text-center">
    <form action="<%=request.getContextPath()%>/Login" method="post">
        <div class="form-group">
            <label for="name">username</label>
            <input type="text" class="form-control" id="name" placeholder="username" name="name">
        </div>
        <div class="form-group">
            <label for="pwd">Password</label>
            <input type="password" class="form-control" id="pwd" placeholder="Password" name="pwd">
        </div>
        <input value="账号或密码输入错误！" name="msg" hidden="hidden">
        <button type="submit" class="btn btn-danger">登录</button>
    </form>
</div>
</body>
</html>
