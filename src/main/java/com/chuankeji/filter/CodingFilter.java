package com.chuankeji.filter;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//注解过滤
@WebFilter("/*")
public class CodingFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        //向下转型
        HttpServletRequest request=(HttpServletRequest) req;
        HttpServletResponse response=(HttpServletResponse) resp;
        //获取请求界面的路径   获取请求的url
        String a=request.getRequestURI();
        if(a.endsWith(".css") || a.endsWith(".js") || a.endsWith(".png")|| a.endsWith(".jpg")){
            System.out.println(".css文件过去了");
            //如果发现是css或者js文件，直接放行
            chain.doFilter(request, response);
        }else{
            //设置编码
            req.setCharacterEncoding("UTF-8");  //页面向服务器提供数据时
            resp.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html;charset=UTF-8");//服务器告知浏览器用UTF-8码表翻译
            chain.doFilter(req, resp);
        }


//        HttpServletRequest request=(HttpServletRequest) req;
//        HttpServletResponse response=(HttpServletResponse) resp;
//        //获取请求界面的路径   获取请求的url
//        String a=request.getRequestURI();

//        if(a.contains(".css") || a.contains(".js") || a.contains(".png")|| a.contains(".jpg")){
//            //如果发现是css或者js文件，直接放行
//            chain.doFilter(request, response);
//        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
