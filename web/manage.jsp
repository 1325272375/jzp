<%--
  Created by IntelliJ IDEA.
  User: laterstage
  Date: 2023-08-27
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>学生管理系统</title>
    <link rel="icon" href="./img/favicon.ico" type ="image/x-icon">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
</head>
<body>
<jsp:include page="/menu/man.jsp" flush="true" >
    <jsp:param name="A1" value="nav-item active"/>
</jsp:include>
<h3>欢迎用户: ${admin} 登录成功！</h3>
</body>
</html>
