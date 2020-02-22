/**
 *@author MengQingChang
 *Copyright 2007-10-29,MenqQingChang all rights reserved.
 */
package com.mengqingchang.myplugin1.editors;

import java.util.Date;

public class StaffEntity {
	// 定义私有变量
	private int id;
	private String name;
	private boolean sex;
	private int age;
	private int phone;
	private String department;
	private String relatPeople;
	private Date createDate;

	// 使从数据工厂中的读取数据更方便
	public StaffEntity(int id, String name, boolean sex, int age, int phone,
			String department, String relatPeople, Date createDate) {
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.phone = phone;
		this.department = department;
		this.relatPeople = relatPeople;
		this.createDate = createDate;
	}

	public StaffEntity() {
	}

	public int getID() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getRelatPeople() {
		return relatPeople;
	}

	public void setRelatPeople(String relatPeople) {
		this.relatPeople = relatPeople;
	}

	// create字段为java中的时间类型，注意导入包。
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
