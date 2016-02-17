package com.pear.service;

import com.pear.model.Login;

public interface UserService {
	/**
	 * @Title: addUser
	 * @Description: 注册用户,添加账号和用户
	 * @param:
	 * @return:
	 * @author 张鑫磊
	 * @date 2016年2月17日 下午2:54:38
	 */
	int addUser(Login login);
	
	/**
	 * @Title: getLoginByUsername
	 * @Description: 查询账号,根据用户名
	 * @param:
	 * @return:
	 * @author 张鑫磊
	 * @date 2016年2月17日 下午2:56:41
	 */
	Login getLoginByUsername(String username);
}
