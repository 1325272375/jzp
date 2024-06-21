package com.one.servlet;

import com.one.service.TeacherService;
import com.one.service.impl.LoginServiceImpl;
import com.one.service.impl.TeacherServiceImpl;
import com.one.utils.DBUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UpdateCourseServlet")
public class UpdateCourseServlet extends HttpServlet{
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
        String cname=request.getParameter("cname");//账号
        String pos=request.getParameter("pos");//账号
        String ctime=request.getParameter("ctime");//账号
        String peonum=request.getParameter("peonum");//账号

        String idt=request.getParameter("idt");//账号

        int a=new  TeacherServiceImpl().updateCourse(account,cname,pos,ctime,peonum,idt);
        if(a==1){
            request.getSession().setAttribute("error","更改成功");
        }else{
            request.getSession().setAttribute("error","更改失败");
        }



        RequestDispatcher rd = request.getRequestDispatcher("tea/updateCourse.jsp");
        rd.forward(request, response);


    }
}

