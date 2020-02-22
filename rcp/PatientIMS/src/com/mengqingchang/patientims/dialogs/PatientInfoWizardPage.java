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
	 	setTitle("添加基本信息");
		setMessage("注意：请正确填写如下信息！！！", IMessageProvider.INFORMATION);
	}

	// 设置对话框内容
	public void createControl(Composite parent) {
		Composite comp = new Composite(parent, SWT.NONE);
		comp.setLayout(new GridLayout(2, false));
		new Label(comp, SWT.NONE).setText("病人住院号：");
		patientId = new Text(comp, SWT.BORDER);
		// 添加修改监听器
		patientId.addModifyListener(this);
		GridData layoutData = new GridData(GridData.FILL_HORIZONTAL);
		patientId.setLayoutData(layoutData);
		new Label(comp, SWT.NONE).setText("诊断医生签字：");
		doctorName = CreateCombo.createAllDoctorNameCombo(comp, SWT.NONE);
		// 添加修改监听器
		doctorName.addModifyListener(this);
		doctorName.setLayoutData(layoutData);
		this.setControl(comp);
	}

	// 收集信息
	public String getPaientId() {
		return patientId.getText();
	}

	public String getDoctorName() {
		return doctorName.getText();
	}

	// 当文本被修改时，监听文本修改的合法性
	public void modifyText(ModifyEvent e) {
		if (getPaientId().length() == 0) {
			setMessage("注意：请输病人住院号！！！！", IMessageProvider.WARNING);
			setPageComplete(false);
			return;
		}
		if (getDoctorName().length() == 0) {
			setMessage("注意：请输入诊断医生签字信息！！！！", IMessageProvider.WARNING);
			setPageComplete(false);
			return;
		}
		setMessage(null);
		setPageComplete(true);

	}

}
