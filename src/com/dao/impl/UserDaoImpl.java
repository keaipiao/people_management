package com.dao.impl;

import java.sql.SQLException;
import java.util.List;



import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.bean.User;
import com.dao.UserDao;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class UserDaoImpl implements UserDao {
	
	//创建c3p0数据源
	private ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
	//使用DButils工具类提供的QueryRunner类与数据库做交互
	private QueryRunner qr = new QueryRunner(comboPooledDataSource);
	
	//添加用户
	@Override
	public int add(User user) {
		//这里没有先判断用户是否存在，因为添加了用户名唯一规则，用户名相同则会报错，返回0
		
		//向数据库添加数据使用的sql语句，此语句为预编译语句，不会出现sql注入的问题，？表示占位符
		String sql = "INSERT INTO user VALUES(?,?,?)";
		//try代码块表示发生异常后程序不会终止执行，匹配catch中的异常，执行catch中的代码
		try {
			//向数据库添加数据，插入成功返回1
			return qr.update(sql, user.getId(),user.getUsername(),user.getPassword());
		} catch (SQLException e) {
			// e.printStackTrace() 表示打印错误信息到控制台上
			e.printStackTrace();
		}
		return 0;
	}
	
	
	//检查用户名密码是否正确
	@Override
	public User checkUserNameAndPassword(String username, String password) {
		//向数据库查询使用的sql语句，判断用户名和密码是否已经存在
		String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
		try {
			//从数据库中查询用户是否存在，存在返回User对象，失败返回null。BeanHandler<User>表示返回单个对象，<User>为返回对象的类型 (User.class)表示返回类型的字节码文件
			return qr.query(sql, new BeanHandler<User>(User.class), username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	
}
