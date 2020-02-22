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

public class PatientBasicInfoWizardPage extends WizardPage implements
		ModifyListener {

	private Text textName;
	private Text textAge;
	private Text textPhone;
	private Text textAddress;
	private Combo comboSex;

	// 设置标题及提示信息
	protected PatientBasicInfoWizardPage() {
		super("");
		setTitle("添加病人基本信息");
		setMessage("注意：请正确填写如下病人信息！！！", IMessageProvider.INFORMATION);
	}

	// 创建向导页内容
	public void createControl(Composite parent) {
		Composite comp = new Composite(parent, SWT.NONE);
		comp.setLayout(new GridLayout(2, false));
		new Label(comp, SWT.NONE).setText("姓名：");
		textName = new Text(comp, SWT.BORDER);
		// 添加监听器
		textName.addModifyListener(this);
		GridData layoutData = new GridData(GridData.FILL_HORIZONTAL);
		textName.setLayoutData(layoutData);
		new Label(comp, SWT.NONE).setText("年龄：");
		textAge = new Text(comp, SWT.BORDER);
		textAge.setLayoutData(layoutData);
		textAge.addModifyListener(this);
		new Label(comp, SWT.NONE).setText("性别：");
		comboSex = new Combo(comp, SWT.READ_ONLY);
		comboSex.setItems(new String[] { "男", "女" });
		comboSex.setLayoutData(layoutData);
		comboSex.addModifyListener(this);
		new Label(comp, SWT.NONE).setText("电话：");
		textPhone = new Text(comp, SWT.BORDER);
		textPhone.setLayoutData(layoutData);
		textPhone.addModifyListener(this);
		new Label(comp, SWT.NONE).setText("住址：");
		textAddress = new Text(comp, SWT.BORDER);
		textAddress.setLayoutData(layoutData);

		textAddress.addModifyListener(this);

		this.setControl(comp);

	}
   // 获得所要收集的向导页信息
	public String getPatientName() {
		return textName.getText();
	}

	public int getPatientAge() {
		String age = textAge.getText();
		return Integer.valueOf(age);
	}

	public String getPatientSex() {
		int index = comboSex.getSelectionIndex();
		if (index == -1) {
			return "";
		}
		return comboSex.getItem(index);
	}

	public String getPatientPhone() {
		return textPhone.getText();
	}

	public String getPatientAddress() {
		return textAddress.getText();
	}

	@Override
	// 监听验证信息的合法性，当文本被修改时触发。
	public void modifyText(ModifyEvent e) {
		if (textName.getText().length() == 0) {
			setMessage("注意：病人名不能为空！！！！", IMessageProvider.WARNING);
			setPageComplete(false);
			return;
		}
		if (textAge.getText().length() == 0) {
			setMessage("注意：请输入病人的年龄！！！！", IMessageProvider.WARNING);
			setPageComplete(false);
			return;

		}
		if (comboSex.getText().length() == 0) {
			setMessage("注意：请选择病人的性别！！！！", IMessageProvider.WARNING);
			setPageComplete(false);
			return;
		}
		if (textPhone.getText().length() == 0) {
			setMessage("注意：请输入病人的联系方式！！！！", IMessageProvider.WARNING);
			setPageComplete(false);
			return;
		}
		if (textAddress.getText().length() == 0) {
			setMessage("注意：请输入病人的家庭住址！！！！", IMessageProvider.WARNING);
			setPageComplete(false);
			return;
		}
		setMessage(null);
		setPageComplete(true);

	}

}
