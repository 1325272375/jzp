<%@ page import="com.one.entity.ClsBean" %>
<%@ page import="java.util.List" %>
<%@ page import="com.one.service.impl.LoginServiceImpl" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: laterstage
  Date: 2023-08-28
  Time: 0:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>学生管理系统</title>
  <link rel="icon" href="${pageContext.request.contextPath}/img/favicon.ico" type ="image/x-icon">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
</head>
<body>
<jsp:include page="/menu/man.jsp" flush="true" >
  <jsp:param name="B" value="nav-item active"/>
</jsp:include>
<div class="container mt-3">
  <h2>添加学生数据</h2>
  <form action="${pageContext.request.contextPath}/AddStuServlet" method="post">
    <div class="mb-3 mt-3">
      <label for="account" class="form-label">账号:</label>
      <input type="text" class="form-control" id="account" placeholder="请输入账号" name="id" required>
    </div>
    <div class="mb-3 mt-3">
      <label for="name" class="form-label">姓名:</label>
      <input type="text" class="form-control" id="name" placeholder="请输入姓名" name="name" required>
    </div>


    <div class="mb-3 mt-3">
      <div class="mb-md-5"> <label  class="form-label">性别:</label>
        <input class="form-check-input" type="radio" name="sex"  value="男" checked><label style="text-align: center;color: #000000;">男</label>
        <input class="form-check-input" type="radio" name="sex"  value="女"><label style="text-align: center;color: #070707;">女</label>
      </div>


    <div class="mb-3 mt-3">
      <label for="phone" class="form-label">手机号:</label>
      <input type="text" class="form-control" id="phone" placeholder="请输入手机号" name="phone" required>
    </div>


    <div class="mb-3 mt-3">
      <label for="adress" class="form-label">家庭住址:</label>
      <input type="text" class="form-control" id="adress" placeholder="请输入家庭住址" name="adress" required>
    </div>


      <div class="mb-3 mt-3">
        <label for="adress" class="form-label">班级:</label>
        <%
          List<ClsBean> list = new LoginServiceImpl().findAllCls();
          request.getSession().setAttribute("dys",list);
        %>
        <select class="form-select" id="dy" name="bj">
          <c:forEach items="${dys}"  var="dy">
            <option value="${dy.id}">${dy.bname}</option>
          </c:forEach>
        </select>
      </div>





    <button type="submit" class="btn btn-primary">添加学生</button>
    <label style="text-align: center;color: #ff0000;">${error}</label>
    <%request.getSession().removeAttribute("error");%>
      <a href="${pageContext.request.contextPath}/man/stu.jsp">返回</a>
  </form>
</div>
</body>
</html>
