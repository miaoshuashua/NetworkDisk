package com.chuankeji.dao;

import com.chuankeji.bean.PageBen;
import com.chuankeji.bean.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface PersInfoDao {
    /*查询用户*/
    public List<User> firstSelect(PageBen pageBen, Map map);
    /*查询总记录数*/
    public int firstSelectCount(Map map);
    /*修改用户状态*/
    public int userStatusUpdate(int userId, String userStatus);
}
