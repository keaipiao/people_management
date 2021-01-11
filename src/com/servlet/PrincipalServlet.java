package com.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Principal;
import com.service.PrincipalService;
import com.service.impl.PrincipalServiceImpl;
import com.util.DateFormat;

@WebServlet("/principal")
public class PrincipalServlet extends BaseServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private PrincipalService principalService = new PrincipalServiceImpl();
	
	//添加负责人
	public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取页面传递的负责人信息
		String name = req.getParameter("name");
		String sex = req.getParameter("sex");
		Date birthday = DateFormat.stringToDate(req.getParameter("birthday"));
		String phone = req.getParameter("phone");
		//创建负责人对象
		Principal principal = new Principal(null,name,sex,birthday,phone);
		//调用service层的添加方法
		Boolean result = principalService.add(principal);
		resp.getWriter().print(result);
	}
	
	//查询所有负责人
	public void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//调用service层的查询方法
		List<Principal> principalList = principalService.findAllPrincipal();
		req.setAttribute("principalList", principalList);
		req.getRequestDispatcher("principal/principalAll.jsp").forward(req, resp);
	}

	//修改负责人信息
	public void updateById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取页面传递的负责人信息
		Integer id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String sex = req.getParameter("sex");
		Date birthday = DateFormat.stringToDate(req.getParameter("birthday"));
		String phone = req.getParameter("phone");
		//创建负责人对象
		Principal principal = new Principal(id,name,sex,birthday,phone);
		//调用service层的修改方法
		Boolean result = principalService.updateById(principal);
		resp.getWriter().print(result);
	}
	
	//删除负责人
	public void deleteById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取页面传递的id
		Integer id = Integer.parseInt(req.getParameter("id"));
		Boolean result = principalService.deleteById(id);
		resp.getWriter().print(result);
	}
}
