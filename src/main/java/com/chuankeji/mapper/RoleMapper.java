package com.chuankeji.mapper;

import com.chuankeji.bean.PageBen;
import com.chuankeji.bean.Role;
import com.chuankeji.bean.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

public interface RoleMapper {
    //查询
   public List<Role> findAllRole();

    public List<User> findAllUser();
    //查询
    public List<Role> findUserByJoinRole();
}
