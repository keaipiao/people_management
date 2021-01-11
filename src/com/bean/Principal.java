package com.bean;

import java.util.Date;

//负责人表
public class Principal {
	private Integer id;
	private String name;//负责人名称
	private String sex;//性别
	private Date birthday;//出生日期
	private String phone;//联系电话
	
	
	public Principal() {
		super();
	}
	
	
	public Principal(Integer id, String name, String sex, Date birthday, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.birthday = birthday;
		this.phone = phone;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
