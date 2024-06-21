<%@ page import="com.one.entity.TeacherBean" %>
<%@ page import="java.util.List" %>
<%@ page import="com.one.service.impl.LoginServiceImpl" %>
<%@ page import="com.one.utils.DBUtil" %>
<%@ page import="com.one.entity.ClsBean" %><%--
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
      color: #382b2b;
      padding-left: 10px;
    }
  </style>

</head>
<body>
<jsp:include page="/menu/man.jsp" flush="true" >
  <jsp:param name="C" value="nav-item active"/>
</jsp:include>
<!--接下来的界面实现，增，删，改，查-->
<div class="container-fluid">
  <div class="row-fluid">

    <form action="${pageContext.request.contextPath}/ShowAllClsServlet" method="post">
      <div class="row">
        <div class="mb-md-5">
          <label for="account" >班级编号:</label>
          <input type="text"  class="inputText" placeholder="请输入班级编号" id="account" name="account">
          <button type="submit" id="search"class="btn btn-primary">搜索</button>
        </div>
      </div>
    </form>


    <a href="${pageContext.request.contextPath}/man/addCls.jsp">添加班级</a>

  </div>
  <div class="row-fluid">
    <div class="span12">
      <table class="table">
        <thead>
        <tr>
          <th>
            班级编号
          </th>
          <th>
            班级名称
          </th>
          <th>
            班级专业
          </th>
          <th>
            导员工号
          </th>
          <th>
            操作
          </th>
        </tr>
        </thead>
        <tbody>
        <%
          if(request.getSession().getAttribute("teas")==null){
            DBUtil dbUtil=new DBUtil();
            List<ClsBean> list = new LoginServiceImpl().findAllCls();
            request.getSession().setAttribute("teas",list);
          }
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
                ${tea.s_id}
            </td>

            <td>

              <a  href="${pageContext.request.contextPath}/man/updateCls.jsp?id=${tea.id}">修改</a>
              <a href="${pageContext.request.contextPath}/DelClsServlet?id=${tea.id}">删除</a>


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
