/**
 *@author MengQingChang
 *Copyright 2007-12-14 ,MenqQingChang all rights reserved.
 */
package com.mengqingchang.patientims.dialogs;

import java.util.Date;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.wizard.Wizard;
import com.mengqingchang.patientims.database.DataBaseOperate;
import com.mengqingchang.patientims.model.Department;
import com.mengqingchang.patientims.model.Patient;
import com.mengqingchang.patientims.model.SickBed;
import com.mengqingchang.patientims.model.SickRoom;

public class AddPatientInforWizard extends Wizard {
	private PatientBasicInfoWizardPage pageOne;
	private PatientRegisterWizardPage pageTwo;

	// 将两个向导页加入
	public void addPages() {
		pageOne = new PatientBasicInfoWizardPage();
		pageTwo = new PatientRegisterWizardPage();
		// 添加两个向导页
		addPage(pageOne);
		addPage(pageTwo);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	// 单击完成按钮执行的操作方法，返回数据为布尔类型
	public boolean performFinish() {
		// 获取向导对话框信息，并植入到相应对象中
		String name = pageOne.getPatientName();
		int age = pageOne.getPatientAge();
		String sex = pageOne.getPatientSex();
		String phone = pageOne.getPatientPhone();
		String address = pageOne.getPatientAddress();
		Date date = new Date();
		Patient patient = new Patient();
		patient.setName(name);
		patient.setAge(age);
		patient.setSex(sex);
		patient.setPhone(phone);
		patient.setAddress(address);
		patient.setLogDate(date);
		String de = pageTwo.getDepar();
		int sr = pageTwo.getSickRoomID();
		int sb = pageTwo.getSickBedID();
		Department depar = new Department();
		depar.setDepartment(de);
		SickRoom sickRoom = new SickRoom();
		sickRoom.setSickRoomId(sr);
		SickBed sickBed = new SickBed();
		sickBed.setSickBedId(sb);
		if (DataBaseOperate.getTest(depar, sickRoom, sickBed) != null) {
			MessageDialog.openError(null, null, "此床位已被占用");
			return false;
		} else if (DataBaseOperate.insertPatientInfor(patient, depar, sickRoom,
				sickBed)) {
			MessageDialog.openError(null, null, "插入成功！！");
			return true;
		} else {
			MessageDialog.openError(null, null, "插入失败！！");
		}
		return false;
	}

}
