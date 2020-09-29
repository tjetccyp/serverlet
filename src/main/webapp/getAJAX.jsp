<%--
  Created by IntelliJ IDEA.
  User: 17691
  Date: 2020/9/27
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="<%=application.getContextPath()%>/assert/js/jquery-1.11.3.js" type="text/javascript"></script>
    <script>
        $(function () {
            $("#get").click(function () {
                $.get("<%=application.getContextPath()%>/jqajax",function (data) {
                    alert(data)
                })
            })

        })
    </script>
</head>

<body>
<input type="button" value="get" id="get">
<input type="button" value="post" id="post">
</body>
</html>
