<%@ page import="com.one.utils.DBUtil" %>
<%@ page import="com.one.service.impl.LoginServiceImpl" %>
<%@ page import="com.one.entity.TeacherBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>学生管理系统</title>
  <link rel="icon" href="${pageContext.request.contextPath}/img/favicon.ico" type ="image/x-icon">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
</head>
<body>
<jsp:include page="/menu/teaD.jsp" flush="true" >
  <jsp:param name="B" value="nav-item active"/>
</jsp:include>
<div class="container mt-3">
  <h2>修改个人信息</h2>
  <form action="${pageContext.request.contextPath}/UpdateTeacherSMServlet" method="post">

    <input type="hidden" class="form-control"  placeholder="请输入账号" name="id" required value="<%=request.getSession().getAttribute("admin")%>">
    <%
      TeacherBean tea=null;
      DBUtil dbUtil=new DBUtil();
      try {
        String id=(String)request.getSession().getAttribute("admin");
        tea =new LoginServiceImpl().findAllTeacher(id).get(0);
      }catch (Exception e){
        String id=request.getParameter("idt");
        tea =new LoginServiceImpl().findAllTeacher(id).get(0);
        e.printStackTrace();
      }



    %>
    <div class="mb-3 mt-3">
      <label for="pwd" class="form-label">密码:</label>
      <input type="password" class="form-control" id="pwd" placeholder="请输入密码" name="pwd"  value="<%=tea.getPwd()%>" required>
    </div>



    <div class="mb-3 mt-3">
      <label for="phone" class="form-label">手机号:</label>
      <input type="text" class="form-control" id="phone" placeholder="请输入手机号"value="<%=tea.getPhone()%>"  name="phone" required>
    </div>


    <div class="mb-3 mt-3">
      <label for="adress" class="form-label">家庭住址:</label>
      <input type="text" class="form-control" id="adress" placeholder="请输入家庭住址" name="adress"value="<%=tea.getAdress()%>" required>
    </div>

    <button type="submit" class="btn btn-primary">修改个人信息</button>
    <label style="text-align: center;color: #ff0000;">${error}</label>
    <%request.getSession().removeAttribute("error");%>

  </form>
</div>
</body>
</html>
