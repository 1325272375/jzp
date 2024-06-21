<%--
  Created by IntelliJ IDEA.
  User: laterstage
  Date: 2023-08-27
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <ul class="navbar-nav">
    <li class="<% String a=request.getParameter("A1"); if(a==null)out.write("nav-item");%>">
      <a class="nav-link" href="${pageContext.request.contextPath}/stu.jsp">首页</a>
    </li>
    <li class="<% a=request.getParameter("A"); if(a==null)out.write("nav-item");%>">
      <a class="nav-link" href="${pageContext.request.contextPath}/stu/course.jsp">选课管理</a>
    </li>
    <li class="<% a=request.getParameter("B"); if(a==null)out.write("nav-item");%>">
      <a class="nav-link" href="${pageContext.request.contextPath}/stu/cj.jsp">查看成绩</a>
    </li>
    <li class="<% a=request.getParameter("C"); if(a==null)out.write("nav-item");%>">
      <a class="nav-link" href="${pageContext.request.contextPath}/stu/myMes.jsp">个人信息修改</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="${pageContext.request.contextPath}/index.jsp">退出</a>
    </li>
  </ul>
</nav>