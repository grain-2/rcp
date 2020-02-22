/**
 *@author MengQingChang
 *Copyright 2007-12-7 2007-12-6,MenqQingChang all rights reserved.
 */
package com.mengqingchang.patientims.model;

public class SickRoom {
	private Long id;// 定义病房的ID号
	private int sickRoomId;// 定义病房号
	// ------实现属性的get/set方法------

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getSickRoomId() {
		return sickRoomId;
	}

	public void setSickRoomId(int sickRoomId) {
		this.sickRoomId = sickRoomId;
	}

}
