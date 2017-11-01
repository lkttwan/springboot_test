package com.gnrsoft.springboot_test.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gnrsoft.springboot_test.model.User;
import com.gnrsoft.springboot_test.service.UserService;

@Controller
public class UserController {

	@Resource
	private UserService userService;
	
	
	
	@RequestMapping("/getUserInfo")
	@ResponseBody
	public User getUserInfo(){
		User user = userService.findUserInfo();
		return user;
	}
	
	
	
	
}
