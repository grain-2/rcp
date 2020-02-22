/**
 *@author MengQingChang
 *Copyright 2007-12-24 ,MenqQingChang all rights reserved.
 */
package com.mengqingchang.patientims.dialogs;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.wizard.Wizard;
import com.mengqingchang.patientims.database.DataBaseOperate;
import com.mengqingchang.patientims.model.Doctor;
import com.mengqingchang.patientims.model.Expense;

public class AddExpenseInforWizard extends Wizard {

	private PatientInfoWizardPage pageOne;
	private PatientExpenseInforWizardPage pageTwo;

	// 添加向导页
	public void addPages() {
		pageOne = new PatientInfoWizardPage();
		pageTwo = new PatientExpenseInforWizardPage();
		addPage(pageOne);
		addPage(pageTwo);
	}

	// 单击"完成"按钮,执行如下操作
	public boolean performFinish() {
		Expense expense = new Expense();
		Doctor doctor = new Doctor();
		// 获得第一个向导页信息，并植入相应实体属性方法中。
		String pi = pageOne.getPaientId();
		expense.setPatientId(Long.valueOf(pi));
		String dn = pageOne.getDoctorName();
		doctor.setName(dn);
		// 获得第二个向导页信息，并植入相应实体属性方法中。
		String expE = pageTwo.getExpenseExplain();
		expense.setExpenseIllustrate(expE);
		String en = pageTwo.getExpenseName();
		expense.setExpenseName(en);
		float up = pageTwo.getUnpice();
		expense.setUnitPrice(up);
		int nu = pageTwo.getNumber();
		expense.setNumber(nu);
		// 插入数据
		if (DataBaseOperate.insertExpenseInfor(expense, doctor)) {
			MessageDialog.openError(null, null, "插入成功！！");
			return true;
		} else {
			MessageDialog.openError(null, null, "插入失败！！");
		}
		return false;
	}

}
