package com.one.servlet;

import com.one.service.impl.TeacherServiceImpl;
import com.one.utils.DBUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UpdateSoreServlet")
public class UpdateSoreServlet extends HttpServlet{
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

        String account=request.getParameter("id");//学号
        String cname=request.getParameter("cid");//课程ID
        String pos=request.getParameter("sore");//分数


        int a=new  TeacherServiceImpl().updateSoreS(pos,account,cname);
        if(a==1){
            request.getSession().setAttribute("error","录入成功");
        }else{
            request.getSession().setAttribute("error","录入失败");
        }



        RequestDispatcher rd = request.getRequestDispatcher("tea/addSore.jsp");
        rd.forward(request, response);


    }
}

