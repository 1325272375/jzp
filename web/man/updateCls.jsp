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
<jsp:include page="/menu/man.jsp" flush="true" >
  <jsp:param name="C" value="nav-item active"/>
</jsp:include>

<div class="container mt-3">
  <h2>更改班级数据</h2>
  <form action="${pageContext.request.contextPath}/UpdateClsServlet" method="post">
    <div class="mb-3 mt-3">
      <label for="account" class="form-label">账号:</label>
      <input type="text" class="form-control" id="account" placeholder="请输入账号" name="id" required value="<%=request.getParameter("id")%>">
      <input type="hidden" class="form-control"  placeholder="请输入账号" name="idt" required value="<%=request.getParameter("id")%>">
    </div>

    <%
      ClsBean tea=null;
      DBUtil dbUtil=new DBUtil();
      try {
        String id=request.getParameter("id");
        tea =new LoginServiceImpl().findAllCls(id).get(0);
      }catch (Exception e){
        String id=request.getParameter("idt");
        tea =new LoginServiceImpl().findAllCls(id).get(0);
        e.printStackTrace();
      }



    %>
    <div class="mb-3 mt-3">
      <label for="bname" class="form-label">班级名称:</label>
      <input type="text" class="form-control" id="bname" placeholder="请输入班级名称" name="bname"  value="<%=tea.getBname()%>" required>
    </div>







    <div class="mb-3 mt-3">
      <label for="pro" class="form-label">班级专业:</label>
      <input type="text" class="form-control" id="pro" placeholder="请输入班级专业"value="<%=tea.getPro()%>"  name="pro" required>
    </div>


    <div class="mb-3 mt-3">

      <label for="dy" class="form-label">导员</label>


      <select class="form-select" id="dy" name="dy">
        <%

          List<TeacherBean> list = new LoginServiceImpl().getAllDyTeacher();
          request.getSession().setAttribute("dys",list);
          String teaId=tea.getS_id();
          TeacherBean teacherBeans=null;
          for(int i=0;i<list.size();i++){
            TeacherBean teacherBean=list.get(i);
            teacherBeans=teacherBean;
          }


        if(!(list==null||list.size()==0)){

        %>
        <option value="<%=tea.getS_id()%>"><%=teacherBeans.getXm()%>|(<%=tea.getS_id()%>)</option>
        <%}%>
      <c:forEach items="${dys}"  var="dy">
        <option value="${dy.id}">${dy.xm}|(${dy.id})</option>
      </c:forEach>
      </select>

    </div>

    <button type="submit" class="btn btn-primary">修改班级</button>
    <label style="text-align: center;color: #ff0000;">${error}</label>
    <%request.getSession().removeAttribute("error");%>
    <a href="${pageContext.request.contextPath}/man/clsManage.jsp">返回</a>
  </form>
</div>
</body>
</html>
