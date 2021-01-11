package com.dao;

import java.util.List;

import com.bean.User;

public interface UserDao {
	
	//添加用户
	public int add(User user);
	
	//检查用户名密码是否正确
	public User checkUserNameAndPassword(String username,String password);
	
}
