/**
 *@author MengQingChang
 *Copyright 2007-12-7 2007-12-6,MenqQingChang all rights reserved.
 */
package com.mengqingchang.patientims.model;

import java.util.Date;

public class Expense {
	private Long id;// ������õ�ID��
	private String expenseIllustrate;// �������˵��
	private String expenseName;// �����������
	private float unitPrice;// ���嵥��
	private int number;// ��������
	private float occurExpense;// ���巢����ʵ�ʷ���
	private Date takeDate;// ���÷���ʱ��
	private Patient patient;// ����Patient�����
	private Doctor doctor; // ����Doctor�����
	private Long patientId;// ��expense������patient��Id����Լ�������

	// ------ʵ��������get/set����---------
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

	// -----------ʵ������get/set����------------
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
