<%@ page import="com.cyp.domain.DEPT" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 17691
  Date: 2020/9/21
  Time: 10:05
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
    <%
        List<DEPT> depts= (List<DEPT>)request.getAttribute("depts");
    %>
    <script>
        function del(id) {
            if (confirm("是否删除id为"+id+"的商品？")) {
                location.href="RemoveDEPT?id="+id;
            }
        }
    </script>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <table class="table table-striped">
            <tr>
                <th>deptno</th>
                <th>dname</th>
                <th>loc</th>
            </tr>
            <%
                for (DEPT dept:depts) {
            %>

            <tr>
                <td><%=dept.getDeptno()%></td>
                <td><%=dept.getDname()%></td>
                <td><%=dept.getLoc()%></td>
                <td>
                    <a href="FindDEPT?id=<%=dept.getDeptno()%>">详情</a>
                    <a href="javascript:void(0)" onclick="del('<%=dept.getDeptno()%>')">删除</a>
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
