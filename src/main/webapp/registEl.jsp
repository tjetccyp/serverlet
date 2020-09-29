<%--
  Created by IntelliJ IDEA.
  User: 17691
  Date: 2020/9/23
  Time: 10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="show.jsp" method="post">
    <input type="text" name="username" placeholder="请输入用户名"><br>
    <input type="password" name="password" placeholder="请输入密码"><br>
    游泳<input type="checkbox" name="habbit" value="游泳">
    跑步<input type="checkbox" name="habbit" value="跑步">
    跳远<input type="checkbox" name="habbit" value="跳远"><br>
    <input type="submit" value="提交">
</form>
</body>
</html>
