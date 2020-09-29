<%--
  Created by IntelliJ IDEA.
  User: 17691
  Date: 2020/9/25
  Time: 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>
        var xhr;
        window.onload=function (ev) {
            document.getElementById("btn").onclick=function (ev1) {
                if (window.XMLHttpRequest) {
                    xhr=new XMLHttpRequest();
                }else {
                    xhr=new ActiveXObject("Mirosoft.XMLHTTP");
                }
                xhr.onreadystatechange=callback;
                xhr.open("post","<%=application.getContextPath()%>/ajxs",true);
                xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded")
                xhr.send("name="+document.getElementById("name").value);
            }
        }
        function callback() {
            if (xhr.readyState==4) {
                if (xhr.status==200) {
                    var s=xhr.responseText;
                    document.getElementById("back").innerHTML=s;
                }
            }
        }
    </script>
</head>
<body>
<input type="text" placeholder="请输入用户名！" name="name" id="name"><input type="submit" value="提交" id="btn">
    <p id="back"></p>

</body>
</html>
