package com.one.servlet;

import com.one.entity.TeacherBean;
import com.one.service.impl.LoginServiceImpl;
import com.one.utils.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/AddTeacherServlet")
public class AddTeacherServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doPost(request,response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        DBUtil dbUtil=new DBUtil();

        String account=request.getParameter("id");//账号
        String name=request.getParameter("name");//账号
        String sex=request.getParameter("sex");//账号
        String zc=request.getParameter("zc");//账号
        String phone=request.getParameter("phone");//账号
        String adress=request.getParameter("adress");//账号


        int a=new LoginServiceImpl().addTeacher(account,name,sex,zc,phone,adress);
        if(a==1){
            request.getSession().setAttribute("error","添加成功");
        }else{
            request.getSession().setAttribute("error","添加失败");
        }

        response.sendRedirect("man/addTeacher.jsp");




    }
}

