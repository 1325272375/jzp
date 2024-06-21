package com.one.servlet;

import com.one.service.impl.LoginServiceImpl;
import com.one.utils.DBUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UpdateClsServlet")
public class UpdateClsServlet extends HttpServlet{
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
        String bname=request.getParameter("bname");//账号
        String pro=request.getParameter("pro");//账号
        String dy=request.getParameter("dy");//账号
        String idt=request.getParameter("idt");//账号

        int a=new LoginServiceImpl().updateCls(account,bname,pro,dy,idt);
        if(a==1){
            request.getSession().setAttribute("error","更改成功");
        }else{
            request.getSession().setAttribute("error","更改失败");
        }



        RequestDispatcher rd = request.getRequestDispatcher("man/updateCls.jsp");
        rd.forward(request, response);


    }
}

