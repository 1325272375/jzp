<%@ page import="com.one.utils.DBUtil" %>
<%@ page import="com.one.service.impl.LoginServiceImpl" %>
<%@ page import="com.one.entity.TeacherBean" %><%--
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
  <jsp:param name="A" value="nav-item active"/>
</jsp:include>
<div class="container mt-3">
  <h2>修改学生数据</h2>
  <form action="${pageContext.request.contextPath}/UpdateTeacherServlet" method="post">
    <div class="mb-3 mt-3">
      <label for="account" class="form-label">账号:</label>
      <input type="text" class="form-control" id="account" placeholder="请输入账号" name="id" required value="<%=request.getParameter("id")%>">
      <input type="hidden" class="form-control"  placeholder="请输入账号" name="idt" required value="<%=request.getParameter("id")%>">
    </div>

    <%
      TeacherBean tea=null;
      DBUtil dbUtil=new DBUtil();
      try {
        String id=request.getParameter("id");
        tea =new LoginServiceImpl().findAllTeacher(id).get(0);
      }catch (Exception e){
        String id=request.getParameter("idt");
        tea =new LoginServiceImpl().findAllTeacher(id).get(0);
        e.printStackTrace();
      }



    %>
    <div class="mb-3 mt-3">
      <label for="name" class="form-label">姓名:</label>
      <input type="text" class="form-control" id="name" placeholder="请输入姓名" name="name"  value="<%=tea.getXm()%>" required>
    </div>



    <div class="mb-3 mt-3">
      <div class="mb-md-5"> <label  class="form-label">性别:</label>

        <%
          if(tea.getSex().equals("男")){
        %>
        <input class="form-check-input" type="radio" name="sex"  value="男" checked><label style="text-align: center;color: #000000;">男</label>
        <input class="form-check-input" type="radio" name="sex"  value="女"><label style="text-align: center;color: #070707;">女</label>

        <%
          }else {
        %>
        <input class="form-check-input" type="radio" name="sex"  value="男" ><label style="text-align: center;color: #000000;">男</label>
        <input class="form-check-input" type="radio" name="sex"  value="女" checked><label style="text-align: center;color: #070707;">女</label>
        <%
          }
        %>

      </div>

      <div class="mb-md-5">
        <label  class="form-label">职位:</label>
        <%
          if(tea.getZc().equals("授课老师")){
        %>
        <input class="form-check-input" type="radio" name="zc"   value="授课老师" checked><label style="text-align: center;color: #070707;">授课老师</label>

        <input class="form-check-input" type="radio" name="zc"  value="导员"><label style="text-align: center;color: #070707;">导员</label>

        <%
        }else {
        %>
        <input class="form-check-input" type="radio" name="zc"   value="授课老师" ><label style="text-align: center;color: #070707;">授课老师</label>

        <input class="form-check-input" type="radio" name="zc"  value="导员" checked><label style="text-align: center;color: #070707;">导员</label>
        <%
          }
        %>


      </div>


    </div>



    <div class="mb-3 mt-3">
      <label for="phone" class="form-label">手机号:</label>
      <input type="text" class="form-control" id="phone" placeholder="请输入手机号"value="<%=tea.getPhone()%>"  name="phone" required>
    </div>


    <div class="mb-3 mt-3">
      <label for="adress" class="form-label">家庭住址:</label>
      <input type="text" class="form-control" id="adress" placeholder="请输入家庭住址" name="adress"value="<%=tea.getAdress()%>" required>
    </div>

    <button type="submit" class="btn btn-primary">修改老师</button>
    <label style="text-align: center;color: #ff0000;">${error}</label>
    <%request.getSession().removeAttribute("error");%>
    <a href="${pageContext.request.contextPath}/man/tea.jsp">返回</a>
  </form>
</div>
</body>
</html>
