package com.service.impl;

import com.bean.User;
import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;
import com.service.UserService;

public class UserServiceImpl implements UserService {
	//使用多态的方式创建对象，提高程序的可扩展性
	private UserDao userDao = new UserDaoImpl();

	//用户注册
	@Override
	public Boolean register(User user) {
		//调用dao层的添加用户方法
		int result = userDao.add(user);
		//大于0返回true(注册成功)，否则返回false(注册失败)
		return result > 0;
	}

	@Override
	public User login(String username, String password) {
		//调用dao层的判断用户名密码是否正确方法，正确返回user对象，否则返回null
		return userDao.checkUserNameAndPassword(username, password);
	}

	
	
}
