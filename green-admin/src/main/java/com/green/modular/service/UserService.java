package com.green.modular.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.modular.mapper.UserMapper;

@Service
public class UserService {
	
	@Autowired
	UserMapper userMapper;

	public List getUserList() {
		return userMapper.getUserList();
	}

}
