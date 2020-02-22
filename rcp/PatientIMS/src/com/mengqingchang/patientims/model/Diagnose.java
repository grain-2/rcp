/**
 *@author MengQingChang
 *Copyright 2007-12-7 2007-12-6,MenqQingChang all rights reserved.
 */
package com.mengqingchang.patientims.model;

import java.util.Date;

public class Diagnose {
	private Long id;//定义诊断的ID号
	private String sickname;//诊断结果，即患者患名名称
	private String therapeutic;//诊断说明
	private Date treatDate;//诊断日期
	private Patient patient;//定义Patient类对象
	private Doctor doctor;//定义Doctor类对象
    private Long patientId;//定义病人ID号，与patient表的Id主键关联。
    // -----------实现类对象的get/set方法--------
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

	// ----------属性的get/set方法-----------
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
