/**
 *@author MengQingChang
 *Copyright 2007-12-21 ,MenqQingChang all rights reserved.
 */
package com.mengqingchang.patientims.dialogs;

import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.mengqingchang.patients.createcombo.CreateCombo;

public class PatientInfoWizardPage extends WizardPage implements ModifyListener {

	private Text patientId;
	private Combo doctorName;

	protected PatientInfoWizardPage() {
		super("");
	 	setTitle("��ӻ�����Ϣ");
		setMessage("ע�⣺����ȷ��д������Ϣ������", IMessageProvider.INFORMATION);
	}

	// ���öԻ�������
	public void createControl(Composite parent) {
		Composite comp = new Composite(parent, SWT.NONE);
		comp.setLayout(new GridLayout(2, false));
		new Label(comp, SWT.NONE).setText("����סԺ�ţ�");
		patientId = new Text(comp, SWT.BORDER);
		// ����޸ļ�����
		patientId.addModifyListener(this);
		GridData layoutData = new GridData(GridData.FILL_HORIZONTAL);
		patientId.setLayoutData(layoutData);
		new Label(comp, SWT.NONE).setText("���ҽ��ǩ�֣�");
		doctorName = CreateCombo.createAllDoctorNameCombo(comp, SWT.NONE);
		// ����޸ļ�����
		doctorName.addModifyListener(this);
		doctorName.setLayoutData(layoutData);
		this.setControl(comp);
	}

	// �ռ���Ϣ
	public String getPaientId() {
		return patientId.getText();
	}

	public String getDoctorName() {
		return doctorName.getText();
	}

	// ���ı����޸�ʱ�������ı��޸ĵĺϷ���
	public void modifyText(ModifyEvent e) {
		if (getPaientId().length() == 0) {
			setMessage("ע�⣺���䲡��סԺ�ţ�������", IMessageProvider.WARNING);
			setPageComplete(false);
			return;
		}
		if (getDoctorName().length() == 0) {
			setMessage("ע�⣺���������ҽ��ǩ����Ϣ��������", IMessageProvider.WARNING);
			setPageComplete(false);
			return;
		}
		setMessage(null);
		setPageComplete(true);

	}

}
