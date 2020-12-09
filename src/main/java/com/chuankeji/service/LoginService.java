package com.chuankeji.service;

import com.chuankeji.bean.User;

public interface LoginService {
    User login(String username, String password);
}
