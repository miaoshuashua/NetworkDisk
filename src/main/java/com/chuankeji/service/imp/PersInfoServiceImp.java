package com.chuankeji.service.imp;

import com.chuankeji.bean.PageBen;
import com.chuankeji.bean.User;
import com.chuankeji.dao.PersInfoDao;
import com.chuankeji.dao.loginDao;
import com.chuankeji.service.PersInfoService;
import com.chuankeji.util.ObjectFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersInfoServiceImp implements PersInfoService {
    PersInfoDao persInfoDao=(PersInfoDao) ObjectFactory.newInstance("com.chuankeji.dao.imp.PersInfoDaoImp");

    /*查询用户基本信息*/
    @Override
    public List<User> firstSelect(PageBen pageBen, Map map) {
        List<User> userList = persInfoDao.firstSelect(pageBen,map);
        return userList;
    }
    /*查询总页数*/
    @Override
    public int firstSelectCount(Map map) {
       int i = persInfoDao.firstSelectCount(map);
        return i;
    }
    //修改用状态
    @Override
    public int userStatusUpdate(int userId, String userStatus) {
        int i = persInfoDao.userStatusUpdate(userId,userStatus);
        return i;
    }
}
