package com.chuankeji.service;

import com.chuankeji.bean.PageBen;
import com.chuankeji.bean.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface PersInfoService {
    /*查询没有条件的查询信息*/
    public List<User> firstSelect(PageBen pageBen, Map map);
    /*查询当前总页数*/
    public int firstSelectCount(Map map);
    /*修改用户的状态*/
    public int userStatusUpdate(int userId, String userStatus);
}
