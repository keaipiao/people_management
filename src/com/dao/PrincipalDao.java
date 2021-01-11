package com.dao;

import java.util.List;

import com.bean.Principal;

public interface PrincipalDao {
	//添加
	public int add(Principal principal);
	//删除
	public int delete(Integer id);
	//修改
	public int update(Principal principal);
	//查询全部
	public List<Principal> findAll();
	
}
