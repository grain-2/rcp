/**
 *@author MengQingChang
 *Copyright 2007-12-7 2007-12-6,MenqQingChang all rights reserved.
 */
package com.mengqingchang.patientims.model;

import java.util.Date;

public class Patient {
	private Long id;// 定义ID号
	private String name;// 定义病人名
	private String sex;// 定义性别
	private int age; // 定义年龄
	private String phone;// 定义电话
	private Date date;// 定义登记日期
	private String address;// 定义地址
	private SickBed sickBed;// 定义sickbed类对象
	private SickRoom sickRoom;// 定义sickRoom类对象
	private Doctor doctor; // 定义Doctor类对象
	private Diagnose diagnose; // 定义Diagnose类对象
	private Department department; // 定义Department对象
	private Expense expense; // 定义Expense对象

	// ----------实现类对象的get/set方法-----------

	public SickBed getSickBed() {
		return sickBed;
	}

	public void setSickBed(SickBed sickBed) {
		this.sickBed = sickBed;
	}

	public SickRoom getSickRoom() {
		return sickRoom;
	}

	public void setSickRoom(SickRoom sickRoom) {
		this.sickRoom = sickRoom;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Diagnose getDiagnose() {
		return diagnose;
	}

	public void setDiagnose(Diagnose diagnose) {
		this.diagnose = diagnose;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Expense getExpense() {
		return expense;
	}

	public void setExpense(Expense expense) {
		this.expense = expense;
	}

	// ----------实现属性的get/set方法------------

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getAddress() {

		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getLogDate() {
		// TODO Auto-generated method stub
		return date;
	}

	public void setLogDate(Date date) {
		this.date = date;
	}

}
