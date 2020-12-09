package com.chuankeji.servlet;

import com.chuankeji.bean.PageBen;
import com.chuankeji.bean.User;
import com.chuankeji.service.LoginService;
import com.chuankeji.service.PersInfoService;
import com.chuankeji.util.ObjectFactory;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*后台用户信息页面显示的*/
@WebServlet("/persInfoServlet")
public class PersInfoServlet extends HttpServlet {
    Gson gson = new Gson();

    PersInfoService persInfoService=(PersInfoService) ObjectFactory.newInstance("com.chuankeji.service.imp.PersInfoServiceImp");
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String methodName = req.getParameter("methodName");
        /*判断调用那个方法*/
        if("firstSelect".equals(methodName)){
            firstSelect(req,resp);
        }else if("userStatusUpdate".equals(methodName)){
            userStatusUpdate(req,resp);
        }

    }
    /*获取页面信息的方法*/
    public void firstSelect(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //我们在这边尝试获取分页
        String page = req.getParameter("page");
        String limit = req.getParameter("limit");
        //获取当前
        Map map = new HashMap<String,String>();
       String userName = req.getParameter("userName");
       String registerTime1 = req.getParameter("registerTime1");
        String registerTime2 =  req.getParameter("registerTime2");

        if(userName!=null&&!userName.trim().equals("")){
            map.put("userName",userName);
        }
        if(registerTime1!=null&&!registerTime1.trim().equals("")){
            map.put("registerTime1",registerTime1);
        }
        if(registerTime2!=null&&!registerTime2.trim().equals("")){
            map.put("registerTime2",registerTime2);
        }

        //获取当前页面的信息
        PageBen pageBen = new PageBen();
        pageBen.setCurePage(Integer.parseInt(page));
        pageBen.setPageSize(Integer.parseInt(limit));

        List<User> userList = persInfoService.firstSelect(pageBen,map);
        int Count = persInfoService.firstSelectCount(map);
        if(userList.size()!=0 && userList!=null){
            HashMap<String,Object> hashMap = new HashMap<>();
            hashMap.put("code",0);
            hashMap.put("msg","");
            //这边是获取总计入数的方法
            hashMap.put("count",Count);   //总的页数11条
            hashMap.put("data",userList);
            resp.getWriter().write(gson.toJson(hashMap));
        }else{
            resp.getWriter().write("error");
        }

    }
    /*获取页面信息的方法*/
    public void userStatusUpdate(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //我们在这边尝试获取分页
        String userIdStr = req.getParameter("userId");
        String userStatus = req.getParameter("userStatus");
//        System.out.println(userId+"==="+userStatus);
        int userId = 0;
        if(userIdStr!=null){
            userId  = Integer.parseInt(userIdStr);
        }
        int i = persInfoService.userStatusUpdate(userId,userStatus);
        if(i>=1){
            resp.getWriter().write("ok");
        }else{
            resp.getWriter().write("error");
        }

    }

}
