/**
 *@author MengQingChang
 *Copyright 2007-12-7 2007-12-6,MenqQingChang all rights reserved.
 */
package com.mengqingchang.patientims.model;

import java.util.Date;

public class Doctor  {
	private Long id;//����Doctor��ID��
	private String name;//��������
	private String sex;//�����Ա�
	private int age;//��������
	private String phone;//������ϵ�绰
	private Date date;//�Ǽ�����
	private String username;//��½�û���
	private String password;//��½����
 	private String rank;//ְ��
 	// ---------------����ʵ��get/set����--------------
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
