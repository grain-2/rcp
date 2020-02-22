/**
 *@author MengQingChang
 *Copyright 2007-12-7 2007-12-6,MenqQingChang all rights reserved.
 */
package com.mengqingchang.patientims.model;

import java.util.Date;

public class Patient {
	private Long id;// ����ID��
	private String name;// ���岡����
	private String sex;// �����Ա�
	private int age; // ��������
	private String phone;// ����绰
	private Date date;// ����Ǽ�����
	private String address;// �����ַ
	private SickBed sickBed;// ����sickbed�����
	private SickRoom sickRoom;// ����sickRoom�����
	private Doctor doctor; // ����Doctor�����
	private Diagnose diagnose; // ����Diagnose�����
	private Department department; // ����Department����
	private Expense expense; // ����Expense����

	// ----------ʵ��������get/set����-----------

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

	// ----------ʵ�����Ե�get/set����------------

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
