/**
 *@author MengQingChang
 *Copyright 2007-12-7 2007-12-6,MenqQingChang all rights reserved.
 */
package com.mengqingchang.patientims.model;

import java.util.Date;

public class Expense {
	private Long id;// 定义费用的ID号
	private String expenseIllustrate;// 定义费用说明
	private String expenseName;// 定义费用名称
	private float unitPrice;// 定义单价
	private int number;// 定义数量
	private float occurExpense;// 定义发生的实际费用
	private Date takeDate;// 费用发生时间
	private Patient patient;// 定义Patient类对象
	private Doctor doctor; // 定义Doctor类对象
	private Long patientId;// 在expense表中与patient表Id主键约束的外键

	// ------实现类对象的get/set方法---------
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	// -----------实现属性get/set方法------------
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getExpenseIllustrate() {
		return expenseIllustrate;
	}

	public void setExpenseIllustrate(String expenseIllustrate) {
		this.expenseIllustrate = expenseIllustrate;
	}

	public String getExpenseName() {
		return expenseName;
	}

	public void setExpenseName(String expenseName) {
		this.expenseName = expenseName;
	}

	public float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public float getOccurExpense() {
		return occurExpense;
	}

	public void setOccurExpense(float occurExpense) {
		this.occurExpense = occurExpense;
	}

	public Date getTakeDate() {
		return takeDate;
	}

	public void setTakeDate(Date takeDate) {
		this.takeDate = takeDate;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
}
