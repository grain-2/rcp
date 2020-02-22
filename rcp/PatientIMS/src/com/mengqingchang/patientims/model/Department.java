/**
 *@author MengQingChang
 *Copyright 2007-12-17 ,MenqQingChang all rights reserved.
 */
package com.mengqingchang.patientims.model;

public class Department {
  private Long id;//定义科室的ID号
  private String department;//定义科室名称
  // -------实现属性的get/set方法-------
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
