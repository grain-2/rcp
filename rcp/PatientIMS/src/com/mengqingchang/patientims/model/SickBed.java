/**
 *@author MengQingChang
 *Copyright 2007-12-7 2007-12-6,MenqQingChang all rights reserved.
 */
package com.mengqingchang.patientims.model;

public class SickBed {
	private Long id;// ���崲λ��ID��
	private int sickBedId;// ���崲λ��
	private SickRoom sickRoom;// ����SickRoom�����

	// ------����SickRoom������get/set����------
	public SickRoom getSickRoom() {
		return sickRoom;
	}

	public void setSickRoom(SickRoom sickRoom) {
		this.sickRoom = sickRoom;
	}

	// ----------ʵ�����Ե�get/set����-----------
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
