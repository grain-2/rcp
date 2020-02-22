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

	// �����ҳ
	public void addPages() {
		pageOne = new PatientInfoWizardPage();
		pageTwo = new PatientExpenseInforWizardPage();
		addPage(pageOne);
		addPage(pageTwo);
	}

	// ����"���"��ť,ִ�����²���
	public boolean performFinish() {
		Expense expense = new Expense();
		Doctor doctor = new Doctor();
		// ��õ�һ����ҳ��Ϣ����ֲ����Ӧʵ�����Է����С�
		String pi = pageOne.getPaientId();
		expense.setPatientId(Long.valueOf(pi));
		String dn = pageOne.getDoctorName();
		doctor.setName(dn);
		// ��õڶ�����ҳ��Ϣ����ֲ����Ӧʵ�����Է����С�
		String expE = pageTwo.getExpenseExplain();
		expense.setExpenseIllustrate(expE);
		String en = pageTwo.getExpenseName();
		expense.setExpenseName(en);
		float up = pageTwo.getUnpice();
		expense.setUnitPrice(up);
		int nu = pageTwo.getNumber();
		expense.setNumber(nu);
		// ��������
		if (DataBaseOperate.insertExpenseInfor(expense, doctor)) {
			MessageDialog.openError(null, null, "����ɹ�����");
			return true;
		} else {
			MessageDialog.openError(null, null, "����ʧ�ܣ���");
		}
		return false;
	}

}
