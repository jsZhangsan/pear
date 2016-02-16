package com.pear.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pear.common.JSONReturn;
import com.pear.model.TUser;
import com.pear.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController extends BaseContorller {

	@Resource
	private UserService userService;
	
	@RequestMapping("/showUser")
	public String showUser() {
		return "showUser";
	}
	
	@RequestMapping("/getUserList")
	@ResponseBody
	public String showUser(Dto dto, ModelMap modelMap) {
		List<Map<String, Object>> list = userService.selUserList(dto.getMap());
		return JSONReturn.newInstance().page(list);
	}
	
	@RequestMapping("/addUser")
	@ResponseBody
	public String addUser(Dto dto) {
		Map<String, Object> map = dto.getMap();
		userService.addUser(map);
		
		return JSONReturn.newInstance().json(map);
	}
	
	@RequestMapping("/adu")
	@ResponseBody
	public String addUser2(TUser u) {
		System.out.println(ReflectionToStringBuilder.toString(u));
		return "showUser";
	}
}
