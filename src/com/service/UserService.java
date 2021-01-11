package com.service;


import com.bean.User;

public interface UserService {
	//用户注册
	public Boolean register(User user);
	
	//用户登录
	public User login(String username,String password);

}
