package com.chuankeji.service.imp;

import com.chuankeji.bean.User;
import com.chuankeji.dao.RegisteDao;
import com.chuankeji.service.RegisteService;
import com.chuankeji.util.ObjectFactory;

public class RegisteServiceImp implements RegisteService {
    RegisteDao registeDao=(RegisteDao) ObjectFactory.newInstance("com.chuankeji.dao.imp.RegisteDaoImp");
    /*注册*/
    @Override
    public int registe(User user) {
       int i = registeDao.registe(user);
        return i;
    }
}
