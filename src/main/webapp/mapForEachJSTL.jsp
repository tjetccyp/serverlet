<%@ page import="com.cyp.dao.EmpDao" %>
<%@ page import="com.cyp.dao.impl.EmpDaoImpl" %>
<%@ page import="com.cyp.domain.Emp" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: 17691
  Date: 2020/9/24
  Time: 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>mapForEachJSTL</title>
    <%
        EmpDao empDao=new EmpDaoImpl();
        Map<String,Emp> maps=new HashMap<String,Emp>();
        for (Emp emp : empDao.findAllEmp()) {
            maps.put(emp.getEname(),emp);
        }
        request.setAttribute("maps",maps);
    %>
</head>
<body>
<c:forEach items="${maps}" var="e" varStatus="status">
    <p <c:if test="${status.index%2==0}"> style="background: #d43f3a"  </c:if>>${e.key}----------${e.value}</p>
</c:forEach>
</body>
</html>
