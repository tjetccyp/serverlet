<%--
  Created by IntelliJ IDEA.
  User: 17691
  Date: 2020/9/25
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="<%=application.getContextPath()%>/assert/js/jquery-1.11.3.js" type="text/javascript"></script>
    <script>
        var user={
            "id":"1001",
            "name":"张三",
            "pwd":"123"
        }
        var arr=["中","英","美"];
        var users=[
            {
                "id":"1001",
                "name":"张三",
                "pwd":"123"
            },{
                "id":"1002",
                "name":"李四",
                "pwd":"456"
            },{
                "id":"1003",
                "name":"王五",
                "pwd":"789"
            }
        ]
        $(function () {
            $("#id").text(user.id);
            $("#name").text(user.name);
            $("#pwd").text(user.pwd);
            $.each(arr,function (index,obj) {
                $("#ul").append("<li>"+obj+"</li>");
                $("#sel").append("<option value='"+obj+"'>"+obj+"</option>");
            })
            $.each(users,function (index,obj) {
                $("#tab").append("<tr><td>"+obj.id+"</td><td>"+obj.name+"</td><td>"+obj.pwd+"</td></tr>")
            })
        })
    </script>
    <style>
        table,th,td{
            border: 1px solid black;

        }
        table{
            width: 300px;
            text-align: center;
            border-collapse: collapse;
        }
    </style>
</head>
<body>
id:<span id="id"></span><br>
name:<span id="name"></span><br>
pwd:<span id="pwd"></span><br>
<ul id="ul">

</ul>
<select id="sel">

</select>
<table id="tab">
    <tr>
        <th>id</th>
        <th>name</th>
        <th>password</th>
    </tr>
</table>
</body>
</html>
