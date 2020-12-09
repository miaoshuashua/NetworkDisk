package com.chuankeji.dao.imp;

import com.chuankeji.bean.PageBen;
import com.chuankeji.bean.User;
import com.chuankeji.dao.PersInfoDao;
import com.chuankeji.mapper.UserMapper;
import com.chuankeji.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class PersInfoDaoImp implements PersInfoDao {
    /*查询用户基本信息*/
    @Override
    public List<User> firstSelect(PageBen pageBen, Map map) {
//        List<User> userList = new ArrayList<>();
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
//        ResultSet rs=null;
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
//            String sql = "select * from user";
//            pstm = conn.prepareStatement(sql);
//            rs = pstm.executeQuery();
//            while(rs.next()){
//                User user = new User();
//                user.setId(rs.getInt("id"));
//                user.setUsername(rs.getString("username"));
//                user.setRegistrationTime(rs.getDate("registrationTime"));
//                user.setIntegral(rs.getInt("integral"));
//                user.setDownloadNumer(rs.getInt("downloadNumer"));
//                user.setUpload(rs.getInt("upload"));
//                user.setUserStatus(rs.getString("userStatus"));
//                userList.add(user);
//            }
//
//            for(User user:userList){
//                System.out.println(user.getId()+"====="+user.getUsername()+"======"+user.getRegistrationTime());
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }finally {
//            try {
//                conn.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
        SqlSession sqlSession = MyBatisUtil.getInstance().getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.findAll(pageBen,map);
        for(User user :userList){
            SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
            String format = ft.format(user.getRegistrationTime());
            user.setRegistrationTimeStr(format);
        }


        return userList;

    }
    /*查询总记录数*/
    @Override
    public int firstSelectCount(Map map) {
        SqlSession sqlSession = MyBatisUtil.getInstance().getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int i = userMapper.findAllCount(map);
        //事务提交
        return i;
    }
    /*修改状态*/
    @Override
    public int userStatusUpdate(int userId, String userStatus) {
        SqlSession sqlSession = MyBatisUtil.getInstance().getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int i = userMapper.userStatusUpdate(userId,userStatus);
        //事务提交
        sqlSession.commit();
        return i;
    }
}
