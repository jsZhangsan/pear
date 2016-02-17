package com.pear.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pear.common.JSONReturn;
import com.pear.model.Login;
import com.pear.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController extends BaseContorller {

	@Resource
	private UserService userService;
	
	@RequestMapping("/register")
	public String showUser() {
		return "register";
	}
	
	/**
	 * @Title: addUser
	 * @Description: 注册账号并添加用户
	 * @param:
	 * @return:
	 * @author 张鑫磊
	 * @date 2016年2月17日 下午3:21:33
	 */
	@RequestMapping("/addUser")
	@ResponseBody
	public String addUser(Login login) {
		userService.addUser(login);
		return JSONReturn.newInstance().json("");
	}
	
	/**
	 * @Title: isHaved
	 * @Description: 判断账号是否存在,返回boolean
	 * @param:
	 * @return:
	 * @author 张鑫磊
	 * @date 2016年2月17日 下午3:20:49
	 */
	@RequestMapping("/isHaved")
	@ResponseBody
	public String isHaved(Login login) {
		Login tempLogin = userService.getLoginByUsername(login.getUsername());
		if(tempLogin != null){
			return JSONReturn.newInstance().json();
		}
		
		return JSONReturn.newInstance().json(false);
	}
	
	
}
