package com.gnrsoft.springboot_test.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gnrsoft.springboot_test.mapper.UserMapper;
import com.gnrsoft.springboot_test.model.User;
import com.gnrsoft.springboot_test.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;

	@Override
	public User findUserInfo() {
		return userMapper.findUserInfo();
	}

}
