package com.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.bean.Principal;
import com.dao.PrincipalDao;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class PrincipalDaoImpl implements PrincipalDao {
	//创建c3p0数据源
	private ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
	//使用DButils工具类提供的QueryRunner类与数据库做交互
	private QueryRunner qr = new QueryRunner(comboPooledDataSource);
	
	//添加
	@Override
	public int add(Principal principal) {
		String sql = "INSERT INTO principal VALUES(?,?,?,?,?)";
		try {
			return qr.update(sql, principal.getId(),principal.getName(),principal.getSex(),principal.getBirthday(),principal.getPhone());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	//删除
	@Override
	public int delete(Integer id) {
		String sql = "DELETE FROM principal WHERE id = ?";
		try {
			return qr.update(sql,id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	//修改
	@Override
	public int update(Principal principal) {
		String sql = "UPDATE principal SET NAME = ?,sex=?,birthday=?,phone=? WHERE id = ?";
		try {
			return qr.update(sql, principal.getName(),principal.getSex(),principal.getBirthday(),principal.getPhone(),principal.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	//查询全部
	@Override
	public List<Principal> findAll() {
		String sql = "SELECT * FROM principal";
		try {
			return qr.query(sql, new BeanListHandler<Principal>(Principal.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
