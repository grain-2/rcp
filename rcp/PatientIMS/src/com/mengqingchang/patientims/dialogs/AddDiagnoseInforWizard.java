/**
 *@author MengQingChang
 *Copyright 2007-12-21 ,MenqQingChang all rights reserved.
 */
package com.mengqingchang.patientims.dialogs;

import java.util.Date;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.wizard.Wizard;

import com.mengqingchang.patientims.database.DataBaseOperate;
import com.mengqingchang.patientims.model.Diagnose;
import com.mengqingchang.patientims.model.Doctor;

public class AddDiagnoseInforWizard extends Wizard {
	private PatientInfoWizardPage pageOne;
	private PatientDiagnoseInforWizardPage pageTwo;

	public AddDiagnoseInforWizard() {
	}
    //���������ҳ
	public void addPages() {
		pageOne = new PatientInfoWizardPage();
		pageTwo = new PatientDiagnoseInforWizardPage();
		addPage(pageOne);
		addPage(pageTwo);
	}
   //����"���"��ťִ������Ĳ���
	public boolean performFinish() {
		Diagnose diagnose = new Diagnose();
		Doctor doctor = new Doctor();
		//��õ�һ����ҳ����Ϣ����ֲ��ʵ�����Է�����
		String patientId = pageOne.getPaientId();
		diagnose.setPatientId(Long.valueOf(patientId));
		String doctorName = pageOne.getDoctorName();
		doctor.setName(doctorName);
		//��õڶ�����ҳ����Ϣ����ֲ��ʵ�����Է�����
		String result = pageTwo.getResult();
		diagnose.setSickName(result);
		String explain = pageTwo.getExplain();
		diagnose.setTherapeutic(explain);
		if (DataBaseOperate.insertDiagnoseInfor(diagnose, doctor)) {
			MessageDialog.openError(null, null, "����ɹ�����");
			return true;
		} else {
			MessageDialog.openError(null, null, "����ʧ�ܣ���");
		}
		return false;
	}

}
