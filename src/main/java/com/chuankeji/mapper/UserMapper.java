package com.chuankeji.mapper;

import com.chuankeji.bean.PageBen;
import com.chuankeji.bean.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    //增加
    public int addUser (User user);
    //删除
    public void deleteUserByid(User user);
    //修改
    public void updateUser(User user);
    //查询
    public List<User> findAll(@Param("pageBen")  PageBen pageBen,@Param("hasMap")Map map);
    //查询
    public List<User> findMap(RowBounds rs);
    //登入查询
    public User login(String username, String password);
    //测试
    public  List<User> Test(@Param("username") String username);
    //
    public User findIn(@Param("list") List list);
    //查询总记录数
    public int findAllCount(@Param("hasMap")Map map);
    public Integer findAllCount2();
    /*修改用户状态*/
     public int userStatusUpdate(@Param("userId")int userId, @Param("userStatus")String userStatus);
}
