<%--
  Created by IntelliJ IDEA.
  User: 17691
  Date: 2020/9/24
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assert/css/bootstrap.css" type="text/css">
    <!-- 可选的Bootstrap主题文件（一般不用引入） -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assert/css/bootstrap-theme.css" type="text/css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="<%=request.getContextPath()%>/assert/js/jquery-1.11.3.js" type="text/javascript"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="<%=request.getContextPath()%>/assert/js/bootstrap.js" type="text/javascript"></script>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <table class="table table-striped">
            <tr>
                <th>empno</th>
                <th>ename</th>
                <th>job</th>
                <th>mgr</th>
                <th>hiredate</th>
                <th>sal</th>
                <th>comm</th>
                <th>deptno</th>
            </tr>

       <c:forEach items="${page.data}" var="emp">
            <tr>
                <td>${emp.empno}</td>
                <td>${emp.ename}</td>
                <td>${emp.job}</td>
                <td>${emp.mgr}</td>
                <td>${emp.hiredate}</td>
                <td>${emp.sal}</td>
                <td>${emp.comm}</td>
                <td>${emp.dept.deptno}</td>
            </tr>
       </c:forEach>
            <tr>
                <td colspan="8">
                    <a href="<%=application.getContextPath()%>/emp?op=selectByPage&currentPage=1">首页</a>
                    <a href="<%=application.getContextPath()%>/emp?op=selectByPage&currentPage=${page.prevPage()}">上一页</a>
                    <a href="<%=application.getContextPath()%>/emp?op=selectByPage&currentPage=${page.nextPage()}">下一页</a>
                    <a href="<%=application.getContextPath()%>/emp?op=selectByPage&currentPage=${page.sumPage()}">尾页</a>
                </td>
            </tr>
        </table>

    </div>
</div>
</body>
</html>
