package com.pear.service;

import java.util.List;
import java.util.Map;

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
