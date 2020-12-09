package com.chuankeji.servlet;

import com.chuankeji.bean.User;
import com.chuankeji.service.LoginService;
import com.chuankeji.service.RegisteService;
import com.chuankeji.util.ObjectFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/resisterServlet")
public class RegisterServlet extends HttpServlet {
    RegisteService registeService=(RegisteService) ObjectFactory.newInstance("com.chuankeji.service.imp.RegisteServiceImp");
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        user.setUsername(req.getParameter("username"));
        user.setPassword(req.getParameter("password"));
        user.setEmail(req.getParameter("email"));
        user.setPhone(req.getParameter("phone"));
        user.setSex(req.getParameter("sex"));
        user.setEducation(req.getParameter("education"));
        user.setTruename(req.getParameter("truename"));
//        {"username":"焱刷刷","password":"Admin001","passwords":"Admin001","email":"1146589010@qq.com","phone":"18359209223","sex":"男","education":"1","truename":"卢振良"}

        int i = registeService.registe(user);

        if(i==1){
            resp.getWriter().write("ok");
        }else if(i==2){
            resp.getWriter().write("error1");
        }else {
            resp.getWriter().write("error");
        }


    }
}
