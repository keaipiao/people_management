package com.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//此类需要其他Servle类继承
public class BaseServlet extends HttpServlet {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//用户访问后会请求到这里，其他继承此类的Servlet直接写方法即可，此方法通过反射调用方法
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置编码集
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		//获取方法名
		String method = req.getParameter("method");
		//通过反射获取当前类或当前类的子类的字节码对象，this表示当前对象的引用
		Class<? extends BaseServlet> clazz = this.getClass();
		try {
			//获取方法
			Method m = clazz.getMethod(method,HttpServletRequest.class,HttpServletResponse.class );
			//调用方法，this表示当前对象的引用
			m.invoke(this, req,resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
