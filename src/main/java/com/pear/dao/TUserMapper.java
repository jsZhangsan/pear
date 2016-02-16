package com.pear.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.pear.model.TUser;

@Repository
public interface TUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(TUser record);

    int insertSelective(TUser record);

    TUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TUser record);

    int updateByPrimaryKey(TUser record);
    
    int addUser(Map<String, Object> map);
    
    List<Map<String, Object>> selUserList(Map<String, Object> map);
}