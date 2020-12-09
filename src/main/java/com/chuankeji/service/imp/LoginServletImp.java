package com.chuankeji.service.imp;

import com.chuankeji.bean.User;
import com.chuankeji.dao.loginDao;
import com.chuankeji.service.LoginService;
import com.chuankeji.util.ObjectFactory;


public class LoginServletImp implements LoginService {
    loginDao loginDao=(loginDao) ObjectFactory.newInstance("com.chuankeji.dao.imp.loginDaoImp");

    //登入
    @Override
    public User login(String username, String password) {
        User user = loginDao.login(username,password);
        return user;
    }
}
