package com.service;

import java.util.List;

import com.bean.Principal;

public interface PrincipalService {
	
	//添加负责人
	public Boolean add(Principal principal);
	//根据id删除负责人
	public Boolean deleteById(Integer id);
	//根据id修改负责人信息
	public Boolean updateById(Principal principal);
	//查询所有负责人
	public List<Principal> findAllPrincipal();
}
