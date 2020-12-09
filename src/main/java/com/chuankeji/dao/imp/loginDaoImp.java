package com.chuankeji.dao.imp;

import com.chuankeji.bean.User;
import com.chuankeji.dao.loginDao;
import com.chuankeji.mapper.UserMapper;
import com.chuankeji.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.sql.*;

public class loginDaoImp implements loginDao {

    @Override
    public User login(String username, String password) {
        SqlSession sqlSession = MyBatisUtil.getInstance().getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.login("淼刷刷", "Admin001");
        return user;
    }
}
