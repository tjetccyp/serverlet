<%--
  Created by IntelliJ IDEA.
  User: 17691
  Date: 2020/9/27
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="<%=application.getContextPath()%>/assert/js/jquery-1.11.3.js" type="text/javascript"></script>
    <script>
        $(function () {
           $("#form").submit(function () {
               var data=$("#form").serializeArray();
              // var  s=JSON.stringify(data);
               var  s1=$.param(data)
               $("#div").text(s1);
              // $("#div").text(s);
               $.each(data,function (index,obj) {
                   $("#div").append("<p>"+obj.name+"-----"+obj.value+"</p>");
               })
               return false;
           })
        })
    </script>
</head>
<body>
<div id="div">

</div>
<form action="#" method="post" id="form">
    <input type="text" name="name" placeholder="请输入用户名"><br>
    <input type="text" name="pwd" placeholder="请输入密码"><br>
    <input type="datetime-local" name="time"><br>
    <input type="radio" name="sex" value="男">男<input type="radio" name="sex" value="女">女<br>
    <input type="checkbox" name="hobby" value="adad">adad
    <input type="checkbox" name="hobby" value="ksdf">ksdf
    <input type="checkbox" name="hobby" value="ygfsdhf">ygfsdhf<br>
    <input type="submit" value="提交">
</form>
</body>
</html>
