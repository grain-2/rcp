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
    //添加两个向导页
	public void addPages() {
		pageOne = new PatientInfoWizardPage();
		pageTwo = new PatientDiagnoseInforWizardPage();
		addPage(pageOne);
		addPage(pageTwo);
	}
   //单击"完成"按钮执行下面的操作
	public boolean performFinish() {
		Diagnose diagnose = new Diagnose();
		Doctor doctor = new Doctor();
		//获得第一个向导页的信息，并植入实体属性方法中
		String patientId = pageOne.getPaientId();
		diagnose.setPatientId(Long.valueOf(patientId));
		String doctorName = pageOne.getDoctorName();
		doctor.setName(doctorName);
		//获得第二个向导页的信息，并植入实体属性方法中
		String result = pageTwo.getResult();
		diagnose.setSickName(result);
		String explain = pageTwo.getExplain();
		diagnose.setTherapeutic(explain);
		if (DataBaseOperate.insertDiagnoseInfor(diagnose, doctor)) {
			MessageDialog.openError(null, null, "插入成功！！");
			return true;
		} else {
			MessageDialog.openError(null, null, "插入失败！！");
		}
		return false;
	}

}
