<%--
  Created by IntelliJ IDEA.
  User: laterstage
  Date: 2023-08-27
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <title>学生管理系统</title>
  <link rel="icon" href="./img/favicon.ico" type ="image/x-icon">
  <link rel="stylesheet" href="./css/bootstrap.css">
  <style>
    * {
      margin: 0;
      padding: 0;
    }

    html {
      height: 100%;
      width: 100%;
      overflow: hidden;
      margin: 0;
      padding: 0;
      background: url(./img/bg.jpg) no-repeat 0px 0px;
      background-repeat: no-repeat;
      background-size: 100% 100%;
      -moz-background-size: 100% 100%;
    }

    body {
      display: flex;
      align-items: center;
      justify-content: center;
      height: 100%;
    }

    #loginDiv {
      width: 400px;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 400px;
      background-color: rgba(48, 52, 59, 0.3);
      box-shadow: 7px 7px 17px rgba(52, 56, 66, 0.5);
      border-radius: 250px;
    }


    p {
      margin-top: 30px;
      margin-left: 20px;
      color: #ffffff;
    }

    input {
      margin-left: 15px;
      border-radius: 5px;
      border-style: hidden;
      height: 30px;
      width: 140px;
      background-color: rgba(255, 255, 255, 0.6);
      outline: none;
      color: #f0edf3;
      padding-left: 10px;
    }

    .button {
      border-color: cornsilk;
      background-color: rgba(100, 149, 237, .7);
      color: aliceblue;
      border-style: hidden;
      border-radius: 5px;
      width: 100px;
      height: 31px;
      font-size: 16px;
    }
  </style>
  <style type="text/css">
    input::-ms-input-placeholder{text-align: center;}
    input::-webkit-input-placeholder{text-align: center;}
  </style>

</head>

<body style="width:100%;height: 100%; background-image: url(./img/bg.jpg);background-repeat: no-repeat;background-size: 100% 100%; ">
<div id="loginDiv">
  <form action="${pageContext.request.contextPath}/LoginServlet" id="form" method="post">
    <h1 style="text-align: center;color: aliceblue;"> 学生管理系统</h1>
    <p>账号:<input id="account" name="account" type="text" placeholder="请输入账号！" required></p>

    <p>密码:<input id="password" name="password"  type="password" placeholder="请输入密码！" required></p>

    <input class="form-check-input" type="radio" name="pow" id="man"  checked value="1"><label style="text-align: center;color: aliceblue;">管理员</label>
    <input class="form-check-input" type="radio" name="pow" id="tea" value="2"><label style="text-align: center;color: aliceblue;">老师</label>
    <input class="form-check-input" type="radio" name="pow" id="stu" value="3"><label style="text-align: center;color: aliceblue;">学生</label>
 
    <div style="text-align: center;margin-top: 30px;">
      <input type="submit" class="button" value="登录"  required>
    </div>

    <label style="text-align: center;color: #ff0000;">${error}</label>
    <%request.getSession().removeAttribute("error");%>
  </form>


</div>

</body>
</html>
