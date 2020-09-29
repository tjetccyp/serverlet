<%--
  Created by IntelliJ IDEA.
  User: 17691
  Date: 2020/9/21
  Time: 19:28
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
    <form action="<%=application.getContextPath()%>/emp?op=addEmp" method="post">
        <div class="form-group">
            <label for="name">name</label>
            <input type="text" class="form-control" id="name" placeholder="name"  name="name">
        </div>
        <div class="form-group">
            <label for="job">job</label>
            <%--<select>
                <option name="job" value="dad" id="job">dad</option>
                <option name="job" value="gfds">gfds</option>
                <option name="job" value="gfg">gfg</option>
                <option name="job" value="werwe">werwe</option>
            </select>--%>
            <input type="text" class="form-control" id="job" placeholder="job"   name="job">
        </div>
        <div class="form-group">
            <label for="mgr">mgr</label>
            <input type="text" class="form-control" id="mgr" placeholder="mgr"   name="mgr">
        </div>
        <div class="form-group">
            <label for="hiredate">hiredate</label>
            <input type="text" class="form-control" id="hiredate" placeholder="hiredate"   name="hiredate">
        </div>
        <div class="form-group">
            <label for="sal">sal</label>
            <input type="text" class="form-control" id="sal" placeholder="sal"   name="sal">
        </div>
        <div class="form-group">
            <label for="comm">comm</label>
            <input type="text" class="form-control" id="comm" placeholder="comm"   name="comm">
        </div>
        <div class="form-group">
            <label for="deptno">deptno</label>
            <input type="text" class="form-control" id="deptno" placeholder="deptno"   name="deptno">
        </div>
        <button type="submit" class="btn btn-danger">添加</button>
    </form>
</body>
</html>
