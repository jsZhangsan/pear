package com.pear.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pear.common.CommonUtil;
import com.pear.dao.LoginMapper;
import com.pear.dao.UserMapper;
import com.pear.model.Login;
import com.pear.model.User;
import com.pear.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Resource
	private LoginMapper loginMapper;
	@Resource
	private UserMapper userMapper;

	@Override
	public int addUser(Login login) {
		String userId  = CommonUtil.getUUID();
		String loginId  = CommonUtil.getUUID();
		
		User user = new User();
		user.setName(login.getUsername());
		user.setId(userId);
		
		login.setUserId(userId);
		login.setId(loginId);
		
		userMapper.insertSelective(user);
		loginMapper.insertSelective(login);
		return 0;
	}

	@Override
	public Login getLoginByUsername(String username) {
		return loginMapper.selectByUsername(username);
	}

	@Override
	public List<Map<String, Object>> selectUserAndLogin(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return loginMapper.selectUserAndLogin(map);
	}

}
