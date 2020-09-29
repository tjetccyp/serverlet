<%@ page import="java.util.List" %>
<%@ page import="com.cyp.domain.Product" %><%--
  Created by IntelliJ IDEA.
  User: 17691
  Date: 2020/9/20
  Time: 10:26
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
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assert/css/manager.css" type="text/css">
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="<%=request.getContextPath()%>/assert/js/bootstrap.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(function(){
            //将所有单数行隐藏
            $(".bodyLeft>ul>li:odd").hide();
            //给所有双数行添加单击事件
            $(".bodyLeft>ul>li:even").click(function(){
                //被点击的元素的下一个元素显示隐藏
                $(this).next().slideToggle();
                //glyphicon glyphicon-menu-down
                if($(this).children("span").attr("class")=="glyphicon glyphicon-menu-down"){
                    $(this).children("span").attr("class","glyphicon glyphicon-menu-right");
                }else{
                    $(this).children("span").attr("class","glyphicon glyphicon-menu-down");
                }
            })
        })
    </script>
    <%
    String name=(String)request.getAttribute("name");
    %>
</head>
<body>

<div class="container">
    <div class="pageTop text-center">
        <h1>您好！<%=name%>欢迎登录后台管理页面</h1><a style="color: red" href="/login.jsp" >注销</a>
    </div>
    <div class="pageBody row">
        <div class="bodyLeft col-md-2">
            <ul>
                <li>商品管理<span class="glyphicon glyphicon-menu-right"></span>

                </li>
                <li>
                    <ul>
                        <li><a href="product/addProduct.jsp" target="frame">添加商品</a></li>
                        <li><a href="/ListProduct" target="frame">查看商品</a></li>
                    </ul>
                </li>
                <li>部门管理<span class="glyphicon glyphicon-menu-right"></span>

                </li>
                <li>
                    <ul>
                        <li><a href="dept/addDEPT.jsp" target="frame">添加部门</a></li>
                        <li><a href="/ListDEPT" target="frame">查看部门</a></li>
                    </ul>
                </li>
                <li>员工管理<span class="glyphicon glyphicon-menu-right"></span>

                </li>
                <li>
                    <ul>
                        <li><a href="emp/addEmp.jsp" target="frame">添加员工</a></li>
                        <li><a href="<%=application.getContextPath()%>/emp?op=listEmp" target="frame">查看员工</a></li>
                    </ul>
                </li>
            </ul>
        </div>
        <div class="bodyRight col-md-10">
            <!-- 菜单详情部分 -->                                                        <!--滚动条-->
            <iframe name="frame"  width="100%" height="100%" frameborder="0" >

            </iframe>

        </div>

    </div>

    <div class="pageDown"></div>
</div>
</body>
</html>
