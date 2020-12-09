package com.chuankeji.servlet;

import com.chuankeji.bean.User;
import com.chuankeji.dao.loginDao;
import com.chuankeji.service.LoginService;
import com.chuankeji.util.ObjectFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/loginServlet")

public class LoginServlet extends HttpServlet {
    LoginService loginService=(LoginService) ObjectFactory.newInstance("com.chuankeji.service.imp.LoginServletImp");
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if(username!=null && password!=null) {

            User user = loginService.login(username, password);
            if (user != null) {
                System.out.println("ok");
                HttpSession session = req.getSession();
                session.setAttribute("user",user);
                resp.getWriter().write("ok");

            } else {
                resp.getWriter().write("error");
            }
        }
    }
}
