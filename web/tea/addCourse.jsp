<%@ page import="com.one.utils.DBUtil" %>
<%@ page import="com.one.service.impl.LoginServiceImpl" %>
<%@ page import="com.one.entity.TeacherBean" %>
<%@ page import="com.one.service.impl.TeacherServiceImpl" %>
<%@ page import="com.one.entity.CourseBean" %><%--
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
<jsp:include page="/menu/tea.jsp" flush="true" >
  <jsp:param name="A" value="nav-item active"/>
</jsp:include>


<div class="container mt-3">
  <h2>录入成绩数据</h2>
  <form action="${pageContext.request.contextPath}/AddCourseServlet" method="post">
    <div class="mb-3 mt-3">
      <label for="account" class="form-label">课程编号:</label>
      <input type="text" class="form-control" id="account" placeholder="请输入课程编号" name="id" required >
      <input type="hidden" class="form-control"  placeholder="请输入账号" name="idt" required value="<%=request.getParameter("idt")%>">
    </div>


    <div class="mb-3 mt-3">
      <label for="cname" class="form-label">课程名字:</label>
      <input type="text" class="form-control" id="cname" placeholder="请输入课程名字" name="cname"  required>
    </div>




    <div class="mb-3 mt-3">
      <label for="pos" class="form-label">上课地点:</label>
      <input type="text" class="form-control" id="pos" placeholder="请输入上课地点" name="pos" required>
    </div>

    <div class="mb-3 mt-3">
      <label for="ctime" class="form-label">上课时间:</label>
      <input type="text" class="form-control" id="ctime" placeholder="请输入上课时间" name="ctime" required>
    </div>

    <div class="mb-3 mt-3">
      <label for="peonum" class="form-label">课程人数:</label>
      <input type="number" class="form-control" id="peonum" placeholder="请输入课程人数" name="peonum" required>
    </div>



    <button type="submit" class="btn btn-primary">添加课程</button>
    <label style="text-align: center;color: #ff0000;">${error}</label>
    <%request.getSession().removeAttribute("error");%>
    <a href="${pageContext.request.contextPath}/tea/course.jsp">返回</a>
  </form>
</div>
</body>
</html>
