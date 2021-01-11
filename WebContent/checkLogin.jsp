<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = (String) session.getAttribute("username");
	String path = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
	if(name==null){
		response.sendRedirect(path + "/login.jsp");
	}
%>