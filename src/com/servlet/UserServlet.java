package com.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;

//此注解表示请求时需要加上/user否则无法使用此类的方法
@WebServlet("/user")
public class UserServlet extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//使用多态的方式创建对象，提高程序的可扩展性
	private UserService userService = new UserServiceImpl();
	
	//用户注册
	public void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取前端传递来的参数
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		//创建用户对象
		User user = new User(null,username,password);
		//调用service层的注册方法
		Boolean result = userService.register(user);
		//向页面返回是否成功
		resp.getWriter().print(result);
	}
	
	//用户登录
	public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取前端传递来的参数
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		//调用service层的登录方法
		User user = userService.login(username, password);
		if(user!=null) {
			HttpSession session = req.getSession();
			session.setAttribute("username", user.getUsername());
			resp.getWriter().print(true);
		}else {
			resp.getWriter().print(false);
		}
	}

}
