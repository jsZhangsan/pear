package com.pear.service;

import java.util.List;
import java.util.Map;

import com.pear.model.TUser;

public interface UserService {
	TUser selUser(String id);
	int addUser(Map<String, Object> map);
	List<Map<String, Object>> selUserList(Map<String, Object> map);
}
