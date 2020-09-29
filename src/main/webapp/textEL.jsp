<%@ page import="com.cyp.dao.EmpDao" %>
<%@ page import="com.cyp.dao.impl.EmpDaoImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="com.cyp.domain.Emp" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: 17691
  Date: 2020/9/23
  Time: 9:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%
        EmpDao empDao=new EmpDaoImpl();
        List<Emp> emps = empDao.findAllEmp();
        Map<String,Emp> map=new HashMap<String,Emp>();
        for (Emp emp : emps) {
            map.put(emp.getEname(),emp);
        }
        request.setAttribute("map",map);
    %>
</head>
<body>
${map.SMITH}
<%--${emp.empno}--%>
</body>
</html>
