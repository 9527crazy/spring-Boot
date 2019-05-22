<%--
  Created by IntelliJ IDEA.
  User: VULCAN
  Date: 2019-5-9
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<ul class="dropdown-menu dropdown-user">
    <li><a href="#"><i class="fa fa-user fa-fw"></i>用户：${USER_SESSION.user_name}</a></li>
    <li><a href="#"><i class="fa fa-gear fa-fw"></i>系统设置</a></li>
    <li class="divider"></li>
    <li><a href="${pageContext.request.contextPath}/logout.action"><i class="fa fa-sign-out fa-fw"></i>退出登录</a></li>
</ul>
我是Customer
</body>
</html>
