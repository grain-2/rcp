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

	// ��������ҳ����
	public void addPages() {
		pageOne = new PatientBasicInfoWizardPage();
		pageTwo = new PatientRegisterWizardPage();
		// ���������ҳ
		addPage(pageOne);
		addPage(pageTwo);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	// ������ɰ�ťִ�еĲ�����������������Ϊ��������
	public boolean performFinish() {
		// ��ȡ�򵼶Ի�����Ϣ����ֲ�뵽��Ӧ������
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
			MessageDialog.openError(null, null, "�˴�λ�ѱ�ռ��");
			return false;
		} else if (DataBaseOperate.insertPatientInfor(patient, depar, sickRoom,
				sickBed)) {
			MessageDialog.openError(null, null, "����ɹ�����");
			return true;
		} else {
			MessageDialog.openError(null, null, "����ʧ�ܣ���");
		}
		return false;
	}

}
