package com.pear.dao;

import java.util.List;
import java.util.Map;

import com.pear.model.Login;

public interface LoginMapper {
    int deleteByPrimaryKey(String id);

    int insert(Login record);

    int insertSelective(Login record);

    Login selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Login record);

    int updateByPrimaryKey(Login record);
    
    Login selectByUsername(String username);
    
    /**
     * @Title: selectUserAndLogin
     * @Description: 查询用户账号密码
     * @param:
     * @return:
     * @author 张鑫磊
     * @date 2016年2月18日 下午3:19:39
     */
    List<Map<String, Object>> selectUserAndLogin(Map<String, Object> map);
}