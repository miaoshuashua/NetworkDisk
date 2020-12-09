package com.chuankeji;

import com.chuankeji.bean.*;
import com.chuankeji.mapper.RoleMapper;
import com.chuankeji.mapper.UserMapper;
import com.chuankeji.util.MappingUtils;
import com.chuankeji.util.MyBatisUtil;
import com.chuankeji.util.ObjectCopyUtil;
import com.chuankeji.util.ObjectCopyUtil2;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.dom4j.Element;


import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class demo {
    public static void main(String[] args) throws Exception {
//        <property name="driverClass">com.mysql.cj.jdbc.Driver</property>
//	<property name="jdbcUrl">jdbc:mysql://localhost:3306/web17?serverTimezone=UTC&amp;useSSL=false</property>
//	<property name="user">root</property>
//	<property name="password">miaoshuashua</property>
        //连接路劲
//        OrmtBean ormtBean = new OrmtBean();
//        ormtBean.setAge(15);
//        ormtBean.setName("123123");
//        OrmtBean ormtBean1 =(OrmtBean) ObjectCopyUtil.copyObj(ormtBean);
//        System.out.println(ormtBean1.getName()+"===="+ormtBean1.getAge());
//
//        OrmtBean ormtBean2 =(OrmtBean) ObjectCopyUtil2.copyObj(ormtBean);
//        System.out.println(ormtBean2.getName()+"===="+ormtBean2.getAge());

//        TestTable tt = new TestTable();
//        tt.setName("peter");
//        tt.setPwd("123123");
//        Element root = MappingUtils.fetchXml();
//        Element foo;
//        for (Iterator i = root.elementIterator("table");i.hasNext();){
//            foo = (Element) i.next();
//            String sql = MappingUtils.fetchInsertSql(foo.attributeValue("name"));
//            System.out.println("sql"+sql);
//        }

//        SqlSession sqlSession = MyBatisUtil.getInstance().getSqlSession();
//        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//        User user = userMapper.login("淼刷刷", "Admin001");
//        System.out.println(user.getId()+"====="+user.getUsername());
//        SqlSession sqlSession = MyBatisUtil.getInstance().getSqlSession();
//        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//        List<User> all = userMapper.findAll();
//
//        for(User user :all){
//            System.out.println(user.getUsername());
//        }
//       Map map = new HashMap<String,Integer>();
////        map.put("initialCount",0);
////        map.put("pageSize",5);
//        SqlSession sqlSession = MyBatisUtil.getInstance().getSqlSession();
//        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//        List<User> userList = userMapper.findMap(map);
//
//        for (User user :userList){
//            System.out.println(user.getUsername());
//        }
//        PageBen pageBen = PageBen.class.newInstance();
//        pageBen.setCurePage(1);
//        pageBen.setPageSize(5);
//        SqlSession sqlSession = MyBatisUtil.getInstance().getSqlSession();
//       Map map = new HashMap();
//       map.put("userName","刷");
//        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//        List<User> userList = userMapper.findAll(pageBen,map);
//        List list = new ArrayList();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        list.add(5);
//        SqlSession sqlSession = MyBatisUtil.getInstance().getSqlSession();
//        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//        userMapper.findIn(list);

//        SqlSession sqlSession = MyBatisUtil.getInstance().getSqlSession();
//        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//        RowBounds rs = new RowBounds(4,4);
//        List<User> map = userMapper.findMap(rs);
//
//        for(User user:map){
//            System.out.println(user.getId());
//        }

//        SqlSession sqlSession = MyBatisUtil.getInstance().getSqlSession();
//        RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
//        List<Role> allRole = roleMapper.findAllRole();
//        for(Role role : allRole){
//            System.out.println(role.getId());
//            List<User> userList = role.getUserList();
//            for (User user:userList){
//                System.out.println(user.getUsername()+"==="+user.getRoleName2());
//            }
//        }

//        SqlSession sqlSession = MyBatisUtil.getInstance().getSqlSession();
//        RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
//        List<Role> allRole = roleMapper.findUserByJoinRole();
//        for(Role role : allRole){
//            System.out.println(role.getId());
//            List<User> userList = role.getUserList();
//            for (User user:userList){
//                System.out.println(user.getUsername()+"==="+user.getRoleName2());
//            }
//        }
        SqlSession sqlSession = MyBatisUtil.getInstance().getSqlSession();
        UserMapper userMapper =  sqlSession.getMapper(UserMapper.class);
        int allCount = userMapper.userStatusUpdate(1,"启用");
        /*事务提交*/
        sqlSession.commit();
        System.out.println("总记录数:"+allCount);

    }
}
