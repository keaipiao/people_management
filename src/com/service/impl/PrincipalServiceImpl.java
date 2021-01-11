package com.service.impl;

import java.util.List;

import com.bean.Principal;
import com.dao.PrincipalDao;
import com.dao.impl.PrincipalDaoImpl;
import com.service.PrincipalService;

public class PrincipalServiceImpl implements PrincipalService{

	private PrincipalDao principalDao = new PrincipalDaoImpl();
	
	@Override
	public Boolean add(Principal principal) {
		return principalDao.add(principal) > 0;
	}

	@Override
	public Boolean deleteById(Integer id) {
		return principalDao.delete(id) > 0;
	}

	@Override
	public Boolean updateById(Principal principal) {
		return principalDao.update(principal) > 0;
	}

	@Override
	public List<Principal> findAllPrincipal() {
		return principalDao.findAll();
	}
	
}
