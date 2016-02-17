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
	 * @Description: ע���˺Ų�����û�
	 * @param:
	 * @return:
	 * @author ������
	 * @date 2016��2��17�� ����3:21:33
	 */
	@RequestMapping("/addUser")
	@ResponseBody
	public String addUser(Login login) {
		userService.addUser(login);
		return JSONReturn.newInstance().json("");
	}
	
	/**
	 * @Title: isHaved
	 * @Description: �ж��˺��Ƿ����,����boolean
	 * @param:
	 * @return:
	 * @author ������
	 * @date 2016��2��17�� ����3:20:49
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
