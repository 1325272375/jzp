package com.one.servlet;

import com.one.entity.CourseBean;
import com.one.entity.StudentBean;
import com.one.service.impl.LoginServiceImpl;
import com.one.service.impl.TeacherServiceImpl;
import com.one.utils.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ShowAllCourseServlet")
public class ShowCourseStuServlet extends HttpServlet{
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
       String a= String.valueOf(request.getSession().getAttribute("admin"));
        String account=request.getParameter("account");//账号
        if(account==null||account.equals("")){
            List<CourseBean> list = new TeacherServiceImpl().findAllCourse(a);
            request.getSession().setAttribute("teas",list);
            response.sendRedirect("tea/course.jsp");
        }else{
            List<CourseBean> list = new TeacherServiceImpl().findAllCourse(account,a);
            request.getSession().setAttribute("teas",list);
            response.sendRedirect("tea/course.jsp");
        }




    }
}

