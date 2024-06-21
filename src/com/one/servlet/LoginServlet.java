package com.one.servlet;
import com.one.service.LoginService;
import com.one.service.impl.LoginServiceImpl;
import com.one.utils.DBUtil;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        DBUtil dbUtil=new DBUtil();

        String account=request.getParameter("account");//账号
        String password=request.getParameter("password");//密码
        String pow=request.getParameter("pow");//密码
        LoginServiceImpl loginServlet= new LoginServiceImpl();
        int a=loginServlet.Login(account,password,pow);
        if(pow.equals("1")){
            if(a==1){
                request.getSession().setAttribute("admin",account);
                response.sendRedirect("manage.jsp");
            }else {
                request.getSession().setAttribute("error", "账号或密码错误！");
                response.sendRedirect("index.jsp");
            }
        }else if(pow.equals("2")){

            if(a==11){//导员
                request.getSession().setAttribute("admin",account);
                response.sendRedirect("teaD.jsp");
            }else if(a==22){//老师
                request.getSession().setAttribute("admin",account);
                response.sendRedirect("tea.jsp");
            }else{
                request.getSession().setAttribute("error", "账号或密码错误！");
                response.sendRedirect("index.jsp");
            }

        }else{


            if(a==1){//导员
                request.getSession().setAttribute("admin",account);
                response.sendRedirect("stu.jsp");
            }else{
                request.getSession().setAttribute("error", "账号或密码错误！");
                response.sendRedirect("index.jsp");
            }






        }





    }
}

