<%@ page import="com.one.utils.DBUtil" %>
<%@ page import="com.one.service.impl.LoginServiceImpl" %>
<%@ page import="com.one.entity.TeacherBean" %>
<%@ page import="com.one.entity.ClsBean" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>学生管理系统</title>
  <link rel="icon" href="${pageContext.request.contextPath}/img/favicon.ico" type ="image/x-icon">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
</head>
<body>
<jsp:include page="/menu/tea.jsp" flush="true" >
  <jsp:param name="A" value="nav-item active"/>
</jsp:include>
<div class="container mt-3">
  <h2>更改班级数据</h2>
  <form action="${pageContext.request.contextPath}/UpdateSoreServlet" method="post">
    <div class="mb-3 mt-3">
      <label for="sore" class="form-label">分数:</label>
      <input type="number" class="form-control" id="sore" placeholder="请输入分数" name="sore" required >
      <input type="hidden" class="form-control" name="id"  value="<%=request.getParameter("id")%>" >
      <input type="hidden" class="form-control"  name="cid" value="<%=request.getParameter("cid")%>"  >
    </div>



    <button type="submit" class="btn btn-primary">录入成绩</button>
    <label style="text-align: center;color: #ff0000;">${error}</label>
    <%request.getSession().removeAttribute("error");%>

    <%
      if(request.getParameter("idc")!=null)
      request.getSession().setAttribute("aaa",request.getParameter("idc"));
    %>
    <a href="${pageContext.request.contextPath}/tea/showStu.jsp?id=${aaa}">返回</a>
  </form>
</div>
</body>
</html>
