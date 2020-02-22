/**
 *@author MengQingChang
 *Copyright 2007-12-7 2007-12-6,MenqQingChang all rights reserved.
 */
package com.mengqingchang.patientims.model;

import java.util.Date;

public class Diagnose {
	private Long id;//������ϵ�ID��
	private String sickname;//��Ͻ���������߻�������
	private String therapeutic;//���˵��
	private Date treatDate;//�������
	private Patient patient;//����Patient�����
	private Doctor doctor;//����Doctor�����
    private Long patientId;//���岡��ID�ţ���patient���Id����������
    // -----------ʵ��������get/set����--------
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

	// ----------���Ե�get/set����-----------
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSickName() {
		return sickname;
	}

	public void setSickName(String sickname) {
		this.sickname = sickname;
	}

	public String getTherapeutic() {
		return therapeutic;
	}

	public void setTherapeutic(String therapeutic) {
		this.therapeutic = therapeutic;
	}

	public Date getTreatDate() {
		return treatDate;
	}

	public void setTreatDate(Date treatDate) {
		this.treatDate = treatDate;
	}
	public Long getPatientId(){
		return patientId;
	}
	public void  setPatientId(Long patientId){
		this.patientId=patientId;
	}
}
