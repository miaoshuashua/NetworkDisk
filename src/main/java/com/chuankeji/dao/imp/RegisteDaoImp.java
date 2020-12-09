package com.chuankeji.dao.imp;

import com.chuankeji.bean.User;
import com.chuankeji.dao.RegisteDao;
import com.chuankeji.mapper.UserMapper;
import com.chuankeji.util.MyBatisUtil;
import com.mysql.cj.Session;
import com.mysql.cj.xdevapi.SessionFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.sql.*;

/*注册*/
public class RegisteDaoImp implements RegisteDao {
    /*注册*/
    @Override
    public int registe(User user) {
        int type = 0;
//        String driverClass = "com.mysql.cj.jdbc.Driver";
//        try {
//            Class.forName(driverClass);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        //连接地址
//        String url = "jdbc:mysql://localhost:3306/networkdisk?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";
//        Connection conn = null;
//        PreparedStatement pstm = null;
////        jdbc:mysql://localhost:3306/web17?serverTimezone=UTC&amp;useSSL=false
//        try {
//            conn = DriverManager.getConnection(url,"root","miaoshuashua");
//            //这边可以用连接的isClosed()判断是否连接上了
//            // 判断连接状态
//            // true为断开连接
//            // false为连接中
//            if(conn.isClosed()) {
//                System.out.println("连接失败");
//            }else {
//                System.out.println("连接成功");
//            }
//            String sql = "insert into user (username, password, email, phone, sex, name, eduction2) values (?,?,?,?,?,?,?);";
//            pstm = conn.prepareStatement(sql);
//            pstm.setString(1,user.getUsername());
//            pstm.setString(2,user.getPassword());
//            pstm.setString(3,user.getEmail());
//            pstm.setString(4,user.getPhone());
//            pstm.setString(5,user.getSex());
//            pstm.setString(6,user.getTruename());
//            pstm.setString(7,user.getEducation());
//
//            type = pstm.executeUpdate();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//            type = 2;
//        }finally {
//            try {
//                conn.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
        //mybatis框架
        //把配置文件
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.getInstance().getSqlSession();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            type = mapper.addUser(user);
        } catch (Exception e ) {
            type = 2;
            e.printStackTrace();
        }finally {
            sqlSession.commit();
            sqlSession.close();
        }
        //return type;
        return type;
    }
}
