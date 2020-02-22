/**
 *@author MengQingChang
 *Copyright 2007-12-7 2007-12-6,MenqQingChang all rights reserved.
 */
package com.mengqingchang.patientims.model;

public class SickBed {
	private Long id;// 定义床位的ID号
	private int sickBedId;// 定义床位号
	private SickRoom sickRoom;// 定义SickRoom类对象

	// ------设置SickRoom类对象的get/set方法------
	public SickRoom getSickRoom() {
		return sickRoom;
	}

	public void setSickRoom(SickRoom sickRoom) {
		this.sickRoom = sickRoom;
	}

	// ----------实现属性的get/set方法-----------
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getSickBedId() {
		return sickBedId;
	}

	public void setSickBedId(int sickBedId) {
		this.sickBedId = sickBedId;
	}
}
