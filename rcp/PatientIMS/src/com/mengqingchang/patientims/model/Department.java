/**
 *@author MengQingChang
 *Copyright 2007-12-17 ,MenqQingChang all rights reserved.
 */
package com.mengqingchang.patientims.model;

public class Department {
  private Long id;//������ҵ�ID��
  private String department;//�����������
  // -------ʵ�����Ե�get/set����-------
  public Long getID(){
	  return id;
  }
  public void setID(Long id){
	  this.id=id;
  }
  
  public String getDepartment(){
	  return department;
  }
  public void setDepartment(String department) {
		this.department = department;
	}
}
