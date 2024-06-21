package com.one.servlet;

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

@WebServlet("/SelectCoureseServlet")
public class SelectCoureseServlet extends HttpServlet{
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

        String account=request.getParameter("id");//学生装好
        String cib=request.getParameter("cid");//课程
        String sta=request.getParameter("sta");//账号
        if(sta.equals("1")){//选课
            int a=new TeacherServiceImpl().selectCourse(account,cib);
            if(a==1){
                request.getSession().setAttribute("error","选课成功");
            }else{
                request.getSession().setAttribute("error","选课失败");
            }
        }else{//退
            int a=new TeacherServiceImpl().noSelectCourse(account,cib);
            if(a==1){
                request.getSession().setAttribute("error","退课成功");
            }else{
                request.getSession().setAttribute("error","退课失败");
            }
        }


        response.sendRedirect("stu/course.jsp");


    }
}

