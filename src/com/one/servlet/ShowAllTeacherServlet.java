package com.one.servlet;

import com.one.entity.TeacherBean;
import com.one.service.LoginService;
import com.one.service.impl.LoginServiceImpl;
import com.one.utils.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ShowAllTeacherServlet")
public class ShowAllTeacherServlet extends HttpServlet{
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

        String account=request.getParameter("account");//账号
        if(account==null||account.equals("")){
            List<TeacherBean> list = new LoginServiceImpl().findAllTeacher();
            request.getSession().setAttribute("teas",list);
            response.sendRedirect("man/tea.jsp");
        }else{
            List<TeacherBean> list = new LoginServiceImpl().findAllTeacher(account);
            request.getSession().setAttribute("teas",list);
            response.sendRedirect("man/tea.jsp");
        }




    }
}
