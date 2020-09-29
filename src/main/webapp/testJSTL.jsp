<%@ page import="com.cyp.dao.EmpDao" %>
<%@ page import="com.cyp.dao.impl.EmpDaoImpl" %>
<%@ page import="com.cyp.domain.Emp" %><%--
  Created by IntelliJ IDEA.
  User: 17691
  Date: 2020/9/23
  Time: 11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<%
    EmpDao empDao=new EmpDaoImpl();
    Emp emp=empDao.findEmpById(7938);
    //emp=null;
    request.setAttribute("emp",emp);
%>
<body>
<c:set var="aaa" value="123" scope="request" />
${requestScope.aaa}<br>
${emp}<br>
<c:set target="${emp}" property="ename" value="123456" />
${emp}
<c:if test="${emp.ename ne null}">
    欢迎您${emp.ename}
</c:if>
<c:if test="${emp.ename eq null}">
    对不起请先登录
</c:if>
<c:choose>
    <c:when test="${emp.dept.deptno eq 10}">10号部门</c:when>
    <c:when test="${emp.dept.deptno eq 20}">20号部门</c:when>
    <c:when test="${emp.dept.deptno eq 30}">30号部门</c:when>
    <c:otherwise>其他部门</c:otherwise>
</c:choose>
</body>
</html>