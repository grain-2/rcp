/**
 *@author MengQingChang
 *Copyright 2007-12-7 2007-12-6,MenqQingChang all rights reserved.
 */
package com.mengqingchang.patientims.model;

import java.util.Date;

public class Doctor  {
	private Long id;//定义Doctor的ID号
	private String name;//定义姓名
	private String sex;//定义性别
	private int age;//定义年龄
	private String phone;//定义联系电话
	private Date date;//登记日期
	private String username;//登陆用户名
	private String password;//登陆密码
 	private String rank;//职称
 	// ---------------以下实现get/set方法--------------
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return username;
	}

	public void setUserName(String username) {
		this.username = username;
	}

	public String getPassWord() {
		return password;
	}

	public void setPassWord(String password) {
		this.password = password;
	}
  	public String getRank() {
		return rank;
	}
 	public void setRank(String rank) {
		this.rank = rank;
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

	public int getAge() {

		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getLogDate() {

		return date;
	}

	public void setLogDate(Date date) {
		this.date = date;
	}

}
