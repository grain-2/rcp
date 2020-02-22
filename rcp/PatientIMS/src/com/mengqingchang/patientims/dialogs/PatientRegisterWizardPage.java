/**
 *@author MengQingChang
 *Copyright 2007-12-14 ,MenqQingChang all rights reserved.
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

public class PatientRegisterWizardPage extends WizardPage implements
		ModifyListener {
	private Combo comboDepar;
	private Text textSickR;
	private Text textSickB;

	protected PatientRegisterWizardPage() {
		super("");
		// TODO Auto-generated constructor stub
		setTitle("添加病房信息");
		setMessage("注意：请正确填写如下信息！！！", IMessageProvider.INFORMATION);
	}

	@Override
	public void createControl(Composite parent) {
		// TODO Auto-generated method stub
		Composite comp = new Composite(parent, SWT.NONE);
		comp.setLayout(new GridLayout(2, false));
		new Label(comp, SWT.NONE).setText("科室：");
		//创建下拉框，从数据库中获取下拉框的数据值。
		comboDepar = CreateCombo.createAllDeparCombo(comp, SWT.NONE);
		comboDepar.addModifyListener(this);
		GridData layoutData = new GridData(GridData.FILL_HORIZONTAL);
		comboDepar.setLayoutData(layoutData);

		new Label(comp, SWT.NONE).setText("病房：");
		textSickR = new Text(comp, SWT.BORDER);
		textSickR.setLayoutData(layoutData);
		textSickR.addModifyListener(this);

		new Label(comp, SWT.NONE).setText("病床：");
		textSickB = new Text(comp, SWT.BORDER);
		textSickB.setLayoutData(layoutData);
		textSickB.addModifyListener(this);

		this.setControl(comp);

	}

	public String getDepar() {
		return comboDepar.getText();
	}

	public int getSickRoomID() {
		String tsr = textSickR.getText();
		return Integer.valueOf(tsr);
	}

	public int getSickBedID() {
		String tsb = textSickB.getText();
		return Integer.valueOf(tsb);
	}

	@Override
	public void modifyText(ModifyEvent e) {

		if (comboDepar.getText().length() == 0) {
			setMessage("注意：请选择科室！！！！", IMessageProvider.WARNING);
			setPageComplete(false);

			return;
		}
		if (textSickR.getText().length() == 0) {
			setMessage("注意： 请选择病房！！！！", IMessageProvider.WARNING);
			setPageComplete(false);
			return;
		}
		if (textSickB.getText().length() == 0) {
			setMessage("注意： 请添加病床号！！！！", IMessageProvider.WARNING);
			setPageComplete(false);
			return;

		}
		setMessage(null);
		setPageComplete(true);
	}
}
