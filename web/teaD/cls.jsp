<%@ page import="com.one.entity.TeacherBean" %>
<%@ page import="java.util.List" %>
<%@ page import="com.one.service.impl.LoginServiceImpl" %>
<%@ page import="com.one.utils.DBUtil" %>
<%@ page import="com.one.entity.StudentBean" %>
<%@ page import="com.one.service.impl.TeacherServiceImpl" %>
<%@ page import="com.one.entity.CourseBean" %>
<%@ page import="com.one.dao.AdminDao" %>
<%@ page import="com.one.entity.ClsBean" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: laterstage
  Date: 2023-08-27
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title>学生管理系统</title>
  <link rel="icon" href="${pageContext.request.contextPath}/img/favicon.ico" type ="image/x-icon">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">

  <style>
    a{
      color: #007cf8;
    }
    a:hover{
      color: #3b0b0b;
    }
    a:active{
      color: #be0f55;
    }
    input {
      margin-left: 15px;
      border-radius: 5px;
      border-style: hidden;
      height: 30px;
      width: 140px;
      background-color: rgb(180, 180, 180);
      outline: none;
      color: #195886;
      padding-left: 10px;
    }
  </style>

</head>
<body>
<jsp:include page="/menu/teaD.jsp" flush="true" >
  <jsp:param name="A" value="nav-item active"/>
</jsp:include>
<!--接下来的界面实现，增，删，改，查-->
<div class="container-fluid">

  <div class="row-fluid">
    <div class="span12">
      <table class="table">
        <thead>
        <tr>
          <th>
            班级编号
          </th>
          <th>
            班级名字
          </th>
          <th>
            专业
          </th>
          <th>
            操作
          </th>
        </tr>
        </thead>
        <tbody>
      <%


        String ac=(String)request.getSession().getAttribute("admin");
        List<ClsBean> res = new LoginServiceImpl().findAllClsByS_id(ac);
        request.getSession().setAttribute("teas",res);

      %>
        <c:forEach items="${teas}"  var="tea">
          <tr>
            <td>

                ${tea.id}
            </td>
            <td>
                ${tea.bname}
            </td>
            <td>
                ${tea.pro}
            </td>

            <td>
              <a  href="${pageContext.request.contextPath}/teaD/stu.jsp?id=${tea.id}">查看学生</a>
            </td>

          </tr>
        </c:forEach>
        <%request.getSession().removeAttribute("teas"); %>


        </tbody>
      </table>
    </div>
  </div>
</div>





</body>
  <script>
    // Usage
    layui.use(function(){
    var layer = layui.layer;
    // Welcome
    layer.msg('Hello World', {icon: 6});
  });
  </script>
</html>
