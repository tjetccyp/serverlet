<%--
  Created by IntelliJ IDEA.
  User: 17691
  Date: 2020/9/25
  Time: 11:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="<%=application.getContextPath()%>/assert/js/jquery-1.11.3.js" type="text/javascript"></script>
    <script>
        $(function () {
            $("#name").blur(function () {
                $.ajax({
                    url:"<%=application.getContextPath()%>/jqajax",
                    type:"post",
                    data:{
                        "name":"dad",
                    },
                    success:function (data) {

                    }


                })
            })
        })
    </script>
</head>
<body>
<form action="<%=application.getContextPath()%>/jqajax" method="post" id="sub">
    <input type="text" placeholder="请输入用户名" name="name" id="name">
    <input type="password" placeholder="请输入密码" name="password" id="password">
    <input type="submit" value="注册">
</form>
</body>
</html>
